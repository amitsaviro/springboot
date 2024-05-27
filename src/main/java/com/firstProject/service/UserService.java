package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    Long createUser(User user) throws JsonProcessingException;

    void updateUser(User user)throws JsonProcessingException;

     ResponseEntity<String> deleteUserById( Long id);
        User getUserById(Long id) throws JsonProcessingException;
}

