package com.socnetwork.service;

import com.socnetwork.entities.UserEntity;
import com.socnetwork.exceptions.UserNotFoundException;

public interface UserDetails {

    public UserEntity loadUserByUsername(String username) throws UserNotFoundException;
}
