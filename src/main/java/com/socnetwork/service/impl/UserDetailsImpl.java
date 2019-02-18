package com.socnetwork.service.impl;

import com.socnetwork.entities.UserEntity;
import com.socnetwork.exceptions.UserNotFoundException;
import com.socnetwork.repositories.UserRepository;
import com.socnetwork.service.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetails {

    private UserRepository userRepository;

    public UserDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity loadUserByUsername(String username) throws UserNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("User " + username + " not found");
    }
}
