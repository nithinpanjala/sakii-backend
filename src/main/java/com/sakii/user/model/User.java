package com.sakii.user.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String phone;
    private String passwordHash;
    private String name;
    private LocalDate dob;
    private String gender;
    private boolean verified;
    private String profilePhotoUrl;
    private String governmentIdUrl;
    private String selfieUrl;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @ManyToMany
    @JoinTable(
        name = "user_interests",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests;
} 