package com.example.RegisterUser.service.impl;

import com.example.RegisterUser.dto.UserDto;
import com.example.RegisterUser.entity.User;
import com.example.RegisterUser.repository.UserRepository;
import com.example.RegisterUser.service.UserService;

import java.util.UUID;

public class UserIMPL implements UserService {

    private UserRepository userRepository;
    @Override
    public User addUser(UserDto userDto) {
        userDto.setId(UUID.randomUUID().toString());
        User user = new User(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getIpaddress()
        );
        return userRepository.save(user);
    }

}
