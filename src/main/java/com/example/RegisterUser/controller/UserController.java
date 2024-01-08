package com.example.RegisterUser.controller;

import com.example.RegisterUser.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/user")
@RestController
@CrossOrigin
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<?> saveEmployeeData(@Valid @RequestBody UserDto userDTO) {}
}
