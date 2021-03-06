package com.socnetwork.controllers;


import com.socnetwork.entities.UserEntity;
import com.socnetwork.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUsers() {
        log.trace(userService.getAllUsers().toString());
        return this.userService.getAllUsers();
    }

    @GetMapping("/me")
    public ResponseEntity getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList())
        );
        return ok(model);
    }

    @PostMapping("/update")
    public void modifyUser(@RequestBody UserEntity userEntity) {
        if (userEntity == null || userEntity.getId() == null) throw new RuntimeException("User or id equals null");
        userService.modifyUser(userEntity);
    }
}
