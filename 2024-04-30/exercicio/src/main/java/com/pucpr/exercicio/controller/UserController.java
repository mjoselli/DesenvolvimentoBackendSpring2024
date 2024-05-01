package com.pucpr.exercicio.controller;

import com.pucpr.exercicio.entity.User;
import com.pucpr.exercicio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pucpr.exercicio.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
