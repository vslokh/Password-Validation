package com.beroe.passwordValidation.controller;

import com.beroe.passwordValidation.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate")
    public boolean validatePassword(@RequestBody PasswordRequest request) {
        return passwordService.validatePassword(request.getPassword());
    }

    // Inner class to represent the request body
    static class PasswordRequest {
        private String password;

        // Getter and setter
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
