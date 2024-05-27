package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.User;
import com.firstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody User user) throws JsonProcessingException {
        userService.createUser(user);
    }


    @PutMapping("/update")
    public void updateUser(@RequestBody User user)throws JsonProcessingException{
        userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
       return userService.deleteUserById(userId);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) throws JsonProcessingException {
        return userService.getUserById(userId);
    }
}
