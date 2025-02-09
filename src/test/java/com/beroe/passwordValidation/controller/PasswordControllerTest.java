package com.beroe.passwordValidation.controller;

import com.beroe.passwordValidation.service.PasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class PasswordControllerTest {

    @Mock
    private PasswordService passwordService;

    @InjectMocks
    private PasswordController passwordController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidatePassword_Valid() {
        PasswordController.PasswordRequest request = new PasswordController.PasswordRequest();
        request.setPassword("validPass1");

        when(passwordService.validatePassword("validPass1")).thenReturn(true);

        boolean response = passwordController.validatePassword(request);
        assertTrue(response);
    }
}
