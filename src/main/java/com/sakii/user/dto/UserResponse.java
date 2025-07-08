package com.sakii.user.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class UserResponse {
    private Long userId;
    private String email;
    private String phone;
    private String name;
    private String gender;
    private LocalDate dob;
    private boolean verified;
    private String profilePhotoUrl;
    private Set<String> interests;
} 