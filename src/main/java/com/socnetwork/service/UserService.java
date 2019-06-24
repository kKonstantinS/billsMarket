package com.socnetwork.service;


import com.socnetwork.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getAllUsers();

    UserEntity saveNewUser(UserEntity userEntity);

    Optional<UserEntity> getUserByUsername(String username);
}
