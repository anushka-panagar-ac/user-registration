package com.example.RegisterUser.service;

import com.example.RegisterUser.dto.UserDto;
import com.example.RegisterUser.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User addUser(UserDto userDto);
}
