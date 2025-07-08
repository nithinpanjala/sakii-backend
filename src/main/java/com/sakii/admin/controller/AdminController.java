package com.sakii.admin.controller;

import com.sakii.admin.dto.AdminLoginRequest;
import com.sakii.admin.dto.AdminResponse;
import com.sakii.admin.model.Admin;
import com.sakii.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<AdminResponse> login(@RequestBody AdminLoginRequest req) {
        Optional<Admin> adminOpt = adminService.login(req.getEmail(), req.getPassword());
        return adminOpt.map(admin -> ResponseEntity.ok(toResponse(admin)))
                .orElse(ResponseEntity.status(401).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getAdmin(@PathVariable Long id) {
        return adminService.getAdminById(id)
                .map(admin -> ResponseEntity.ok(toResponse(admin)))
                .orElse(ResponseEntity.notFound().build());
    }

    private AdminResponse toResponse(Admin admin) {
        AdminResponse resp = new AdminResponse();
        resp.setAdminId(admin.getAdminId());
        resp.setEmail(admin.getEmail());
        return resp;
    }
} 