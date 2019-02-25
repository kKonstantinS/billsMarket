package com.socnetwork.controllers;


import com.socnetwork.entities.UserEntity;
import com.socnetwork.repositories.UserRepository;
import com.socnetwork.service.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/registration")
public class RegistrationController {

    private UserDetails userDetails;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserDetails userDetails, PasswordEncoder passwordEncoder) {
        this.userDetails = userDetails;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/register")
    public void saveNewUser(UserEntity userEntity) {
        userDetails.saveNewUser(userEntity);
    }
}
