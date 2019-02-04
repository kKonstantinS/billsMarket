package com.socNetwork.service;


import com.socNetwork.domain.UserDto;
import com.socNetwork.entities.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();
}
