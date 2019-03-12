package com.socnetwork.security;

import com.socnetwork.entities.UserEntity;

import java.util.Optional;

public interface UserAuthenticationService {

    Optional<String> login(String username, String password);

    Optional<UserEntity> findByToken(String token);

    void logout(UserEntity user);
}
