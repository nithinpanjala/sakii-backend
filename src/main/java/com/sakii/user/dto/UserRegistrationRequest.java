package com.sakii.user.dto;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String email;
    private String phone;
    private String password;
    private String name;
    private String gender;
    private String dob;
} 