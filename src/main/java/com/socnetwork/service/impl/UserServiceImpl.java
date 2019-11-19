package com.socnetwork.service.impl;


import com.socnetwork.entities.UserEntity;
import com.socnetwork.exceptions.UserAlreadyExistsException;
import com.socnetwork.exceptions.UserNotFoundException;
import com.socnetwork.repositories.UserRepository;
import com.socnetwork.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    @Override
    public UserEntity saveNewUser(UserEntity userEntity) {
        if (userRepository.findByUsername(userEntity.getUsername()).isPresent()) {
            return userRepository.save(userEntity);
        }
        throw new UserAlreadyExistsException("User with username " + userEntity.getUsername() + " already exists");
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.get()==null){
            throw new UserNotFoundException("User with given username - "+username+"not found.");
        }
        return user;
    }

    @Transactional
    public List<UserEntity> asd() {
        log.trace("First invoke");
        return dsa();
    }

    @Transactional
    public List<UserEntity> dsa() {
        log.trace("Second invoke");
        return userRepository.findAll();
    }

}
