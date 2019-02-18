package com.socnetwork.service.impl;


import com.socnetwork.entities.UserEntity;
import com.socnetwork.repositories.UserRepository;
import com.socnetwork.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }
}
