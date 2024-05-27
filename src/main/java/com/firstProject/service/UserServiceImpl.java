package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Status;
import com.firstProject.model.User;
import com.firstProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Long createUser(User user) throws JsonProcessingException {
        if (user.getStatus() == Status.REGISTER) {
            // If status is REGISTER, set the registerDate
            user.setRegisterDate(LocalDate.now().toString());
            return userRepository.createUser(user);
        } else {
            // If status is NOT_REGISTER, set the registerDate to null
            user.setRegisterDate(null);
            return userRepository.createUser(user);
        }
    }

    @Override
    public void updateUser(User user)throws JsonProcessingException {
        if (user.getStatus() == Status.REGISTER) {
            // If status is REGISTER, set the registerDate
            user.setRegisterDate(LocalDate.now().toString());
            userRepository.updateUser(user);
        } else {
            // If status is NOT_REGISTER, set the registerDate to null
            user.setRegisterDate(null);
            userRepository.updateUser(user);
        }
    }

    @Override
    public ResponseEntity<String> deleteUserById(Long id) {
        // Make an API call to the Poll service to delete user's data
        String pollServiceUrl = "http://localhost:8090/answer/deleteAllData/" + id;
        restTemplate.delete(pollServiceUrl);
        // Delete user data in the current service
        userRepository.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully and related data in poll service is deleted.");
    }


    @Override
    public User getUserById(Long id) throws JsonProcessingException {
        return userRepository.getUserById(id);
    }
}

