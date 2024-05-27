package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.firstProject.repository.cache.CacheRepository;
import com.firstProject.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.firstProject.model.User;



@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " " + "(first_name, last_name, email, age, address, register_date, status) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getRegisterDate(),
                user.getStatus().name()
        );
        Long userId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
        user.setId(userId);
        String cacheKey = createUserIdCacheKey(userId);
        try {
            String userAsString = objectMapper.writeValueAsString(user);
            cacheRepository.createCacheEntity(cacheKey, userAsString);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            e.printStackTrace();
        }
        return userId;

    }

    @Override
    public void updateUser(User user)throws JsonProcessingException {
if(cacheRepository.isKeyExists(user.getId().toString())){
    String userAsString=objectMapper.writeValueAsString(user);
    cacheRepository.updateCacheEntity(user.getId().toString(), userAsString);
}
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, age=?, address=?, register_date=?, status=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getRegisterDate(),
                user.getStatus().name(),
                user.getId()
        );
    }

    @Override
    public ResponseEntity<String> deleteUserById(Long id) {
       cacheRepository.removeCacheEntity(id.toString());
       String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
        return ResponseEntity.ok("User deleted successfully!");
    }

    @Override
    public User getUserById(Long id) throws JsonProcessingException {
        String cacheKey = createUserIdCacheKey(id);
        if (cacheRepository.isKeyExists(cacheKey)) {
            String user = cacheRepository.getCacheEntity(cacheKey);
            return objectMapper.readValue(user, User.class);
        } else {
            String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
            try {
                User user = jdbcTemplate.queryForObject(sql, userMapper, id);
                String userAsString = objectMapper.writeValueAsString(user);
                cacheRepository.createCacheEntity(cacheKey, userAsString);
                return user;
            } catch (EmptyResultDataAccessException e) {
                System.out.println("Empty Data Warning");
                return null;
            }
        }
    }

 private String createUserIdCacheKey(Long userId){
    return "user.id: " + userId;
 }
}














