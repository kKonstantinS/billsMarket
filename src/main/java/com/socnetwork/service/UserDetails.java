package com.socnetwork.service;

import com.socnetwork.entities.UserEntity;
import com.socnetwork.exceptions.UserNotFoundException;

public interface UserDetails {

    UserEntity loadUserByUsername(String username) throws UserNotFoundException;

    UserEntity saveNewUser(UserEntity userEntity);
}
