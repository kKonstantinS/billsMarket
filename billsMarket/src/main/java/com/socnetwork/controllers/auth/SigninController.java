package com.socnetwork.controllers.auth;

import com.socnetwork.controllers.auth.domain.AuthenticationRequest;
import com.socnetwork.entities.UserEntity;
import com.socnetwork.exceptions.UserAlreadyExistsException;
import com.socnetwork.security.JwtTokenProvider;
import com.socnetwork.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class SigninController {

    private static final Logger log = LoggerFactory.getLogger(SigninController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

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

        return ok(SecurityContextHolder.getContext().getAuthentication().getDetails());
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

    @GetMapping(path = "/clear-session")
    public void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        if(session != null) {
            session.invalidate();
        }
    }

    @GetMapping("/is-authenticated")
    public boolean isAuthenticated(HttpServletRequest request) {
       //HttpSession session = request.getSession(false);
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
}
