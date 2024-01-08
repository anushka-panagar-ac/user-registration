package com.example.RegisterUser.controller;

import com.example.RegisterUser.dto.UserDto;
import com.example.RegisterUser.entity.IPAddressInfo;
import com.example.RegisterUser.entity.User;
import com.example.RegisterUser.exceptions.ErrorDetails;
import com.example.RegisterUser.service.IPAddressService;
import com.example.RegisterUser.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/v1/user")
@RestController
@CrossOrigin
public class UserController {


    private final UserService userService;
    private final IPAddressService ipAddressService;

    public UserController(UserService userService, IPAddressService ipAddressService) {
        this.userService = userService;
        this.ipAddressService = ipAddressService;
    }


    @Operation(summary = "/register", description = "To register user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User saved successfully")})
    @PostMapping(value = "/register")
    public ResponseEntity<?> saveEmployeeData(@Valid @RequestBody UserDto userDTO) {

        // This could go into service layer
        IPAddressInfo ipInfo = ipAddressService.getIPAddressInfo(userDTO.getIpaddress());
        if (ipInfo == null || !"Canada".equalsIgnoreCase(ipInfo.getCountry())) {
            ErrorDetails errorDetails =
                    new ErrorDetails(new Date(), "Sorry you cannot register your data. Access from outside Canada is not allowed",
                            "Your IP shows you are accessing the website from " + ipInfo.getCountry());
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
        User savedUser = userService.addUser(userDTO);

        // Constructing response with required data - could specify a type and pass all details incase of doing dynamic construction
        String name = savedUser.getUsername();
        String uuid = savedUser.getId().toString();
        String message = "Welcome " + name + " from " + ipInfo.getCity();

        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("uuid", uuid);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
