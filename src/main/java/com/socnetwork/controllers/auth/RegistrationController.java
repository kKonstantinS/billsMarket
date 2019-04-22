package com.socnetwork.controllers.auth;


import com.socnetwork.entities.UserEntity;
import com.socnetwork.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/registration")
public class RegistrationController {

    private UserService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/register")
    public void saveNewUser(UserEntity userEntity) {
        userDetailsService.saveNewUser(userEntity);
    }
}
