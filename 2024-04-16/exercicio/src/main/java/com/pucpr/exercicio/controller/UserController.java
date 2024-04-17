package com.pucpr.exercicio.controller;

import com.pucpr.exercicio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pucpr.exercicio.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
