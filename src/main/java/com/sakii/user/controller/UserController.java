package com.sakii.user.controller;

import com.sakii.common.utils.JwtUtil;
import com.sakii.user.dto.UserRegistrationRequest;
import com.sakii.user.dto.UserLoginRequest;
import com.sakii.user.dto.UserResponse;
import com.sakii.user.model.User;
import com.sakii.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegistrationRequest req) {
        User user = User.builder()
                .email(req.getEmail())
                .phone(req.getPhone())
                .passwordHash(req.getPassword())
                .name(req.getName())
                .gender(req.getGender())
                .dob(req.getDob() != null ? java.time.LocalDate.parse(req.getDob()) : null)
                .build();
        User saved = userService.registerUser(user, Set.of()); // TODO: handle interests
        return ResponseEntity.ok(toResponse(saved));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginRequest req) {
        Optional<User> userOpt = userService.login(req.getEmailOrPhone(), req.getPassword());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String token = jwtUtil.generateToken(user.getEmail() != null ? user.getEmail() : user.getPhone());
            Map<String, Object> resp = new HashMap<>();
            resp.put("token", token);
            resp.put("user", toResponse(user));
            return ResponseEntity.ok(resp);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(toResponse(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    private UserResponse toResponse(User user) {
        UserResponse resp = new UserResponse();
        resp.setUserId(user.getUserId());
        resp.setEmail(user.getEmail());
        resp.setPhone(user.getPhone());
        resp.setName(user.getName());
        resp.setGender(user.getGender());
        resp.setDob(user.getDob());
        resp.setVerified(user.isVerified());
        resp.setProfilePhotoUrl(user.getProfilePhotoUrl());
        if (user.getInterests() != null) {
            resp.setInterests(user.getInterests().stream().map(i -> i.getInterestName()).collect(Collectors.toSet()));
        }
        return resp;
    }
} 