package com.socNetwork.service.serviceImpl;


import com.socNetwork.entities.UserEntity;
import com.socNetwork.repositories.UserRepository;
import com.socNetwork.service.UserService;
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
