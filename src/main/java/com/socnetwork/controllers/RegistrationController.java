package com.socnetwork.controllers;


import com.socnetwork.entities.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/registration")
public class RegistrationController {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/register")
    public void saveNewUser(UserEntity userEntity) {
        userDetailsService.saveNewUser(userEntity);
    }
}
