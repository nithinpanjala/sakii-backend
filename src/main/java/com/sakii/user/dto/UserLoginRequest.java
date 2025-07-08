package com.sakii.user.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String emailOrPhone;
    private String password;
} 