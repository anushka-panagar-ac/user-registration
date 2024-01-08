# user-registration

User registration app using Spring Boot

Build Springboot app using Springboot Initializer - https://start.spring.io/

Getting Started
1. git clone https://github.com/anushka-panagar/springboot_user_reg_app.git
2. gradle build

Usage
Endpoints API is exposed on - http://localhost:8085/api/v1/user/register
Request Format {   "username": "helloabc@gmail.com",   "password": "YourPassword123#",   "ipaddress": "209.91.91.194" } 
Response Format { "timestamp": "2023-12-22T04:11:44.387+00:00", "message": "Validation Error message : Password need to be greater than 8 characters, containing at least 1 number, 1 Capitalized letter, 1 special character in this set “_ # $ % .", "details": "Validation failed for classes [com.example.UserRegistration.entity.User] during persist time for groups [jakarta.validation.groups.Default, ]\nList of constraint violations:[\n\tConstraintViolationImpl{interpolatedMessage='must match \"^(?=.*[0-9])(?=.*[A-Z])(?=.*[_#$%\\\\.]).{8,}$\"', propertyPath=password, rootBeanClass=class com.example.UserRegistration.entity.User, messageTemplate='{jakarta.validation.constraints.Pattern.message}'}\n]" } Used https://ip-api.com/docs/api:json for IP Address check
 
