package com.sakii.admin.dto;

import lombok.Data;

@Data
public class AdminLoginRequest {
    private String email;
    private String password;
} 