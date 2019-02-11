package com.socNetwork.controllers;


import com.socNetwork.entities.UserEntity;
import com.socNetwork.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<UserEntity> findAllUsers() {
        return this.userService.getAllUsers();
    }
}
