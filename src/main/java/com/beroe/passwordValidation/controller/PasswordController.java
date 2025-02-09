package com.beroe.passwordValidation.controller;


import com.beroe.passwordValidation.dto.PasswordRequest;
import com.beroe.passwordValidation.service.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private final PasswordValidatorService validatorService;

    @Autowired
    public PasswordController(PasswordValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validatePassword(@RequestBody PasswordRequest passwordRequest) {
        boolean isValid = validatorService.validate(passwordRequest.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Password is valid.");
        } else {
            return ResponseEntity.badRequest().body("Password is invalid.");
        }
    }
}
