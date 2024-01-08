package com.example.RegisterUser.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDto {

    private String id;

    @NotEmpty(message = "Username cannot be Null")
    private String username;

    @NotNull(message = "Password cannot be Null")
    private String password;

    @NotEmpty(message = "IPAddress cannot be Null")
    private String ipaddress;

    public UserDto(String username, String password, String ipaddress) {
        this.username = username;
        this.password = password;
        this.ipaddress = ipaddress;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid=" + id +
                ", email='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }
}
