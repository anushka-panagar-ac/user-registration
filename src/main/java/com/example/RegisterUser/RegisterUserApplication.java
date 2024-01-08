package com.example.RegisterUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.RegisterUser.service", "com.example.RegisterUser.entity"})
public class RegisterUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterUserApplication.class, args);
	}

}
