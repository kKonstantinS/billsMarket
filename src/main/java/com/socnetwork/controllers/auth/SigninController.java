package com.socnetwork.controllers.auth;

import com.socnetwork.controllers.auth.domain.AuthenticationRequest;
import com.socnetwork.controllers.auth.domain.JwtAuthenticationResponse;
import com.socnetwork.entities.UserEntity;
import com.socnetwork.exceptions.UserAlreadyExistsException;
import com.socnetwork.security.JwtTokenProvider;
import com.socnetwork.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class SigninController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data, HttpServletResponse httpServletResponse) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        data.getUsername(),
                        data.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        Cookie cookie = new Cookie("token", jwt);
        httpServletResponse.addCookie(cookie);
        return ok("Token has been set.");
    }

    @PostMapping(path = "/register")
    public void saveNewUser(UserEntity userEntity) {
        Optional user = userService.getUserByUsername(userEntity.getUsername());
        if (!user.isPresent()) {
            userService.saveNewUser(userEntity);
        } else {
            log.warn("Username " + userEntity.getUsername() + "already exists");
            throw new UserAlreadyExistsException("User with username " + userEntity.getUsername() + "already exists");
        }
    }
}
