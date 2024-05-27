package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.User;
import org.springframework.http.ResponseEntity;

public interface UserRepository {
    Long createUser(User user);
    void updateUser(User user)throws JsonProcessingException;
    ResponseEntity<String> deleteUserById(Long id);
    User getUserById(Long id) throws JsonProcessingException;
}
