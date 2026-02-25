package com.neurolearn.controller;

import com.neurolearn.dto.LoginRequest;
import com.neurolearn.dto.RegisterRequest;
import com.neurolearn.entity.User;
import com.neurolearn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // for frontend later
public class AuthController {

    @Autowired
    private UserService userService;

    // ✅ Register API
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody RegisterRequest request) {
        Map<String, Object> result = userService.register(request);
        return ResponseEntity.ok(result);
    }

    // ✅ Login API
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequest request) {
        Map<String, Object> result = userService.login(request);
        return ResponseEntity.ok(result);
    }

    // ✅ Get User by ID (for testing)
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}