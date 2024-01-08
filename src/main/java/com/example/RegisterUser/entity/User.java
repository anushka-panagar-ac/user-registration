package com.example.RegisterUser.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "binary(32)")
    private UUID id;

    @Column(name="username", length = 255, unique = true, nullable = false)
    private String username;

    @Column(name="password", length = 255, nullable = false)
    private String password;


    @Column(name="ipaddress", length = 255, nullable = false)
    private String ipaddress;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public User(String username, String password, String ipaddress) {
        this.username = username;
        this.password = password;
        this.ipaddress = ipaddress;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + id +
                ", email='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }

}
