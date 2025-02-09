package com.beroe.passwordValidation.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class PasswordServiceTest {

    @Mock
    private ValidationRule rule1;

    @Mock
    private ValidationRule rule2;

    @Mock
    private List<ValidationRule> validationRules; // Mock the list of rules

    @InjectMocks
    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize the list of rules
        when(validationRules.stream()).thenReturn(List.of(rule1, rule2).stream());
    }

    @Test
    void testValidatePassword_Valid() {
        // Mock the behavior of the rules
        when(rule1.validate("validPass1")).thenReturn(true);
        when(rule2.validate("validPass1")).thenReturn(true);

        // Test the password validation
        assertTrue(passwordService.validatePassword("validPass1"));
    }

    @Test
    void testValidatePassword_Invalid() {
        // Mock the behavior of the rules
        when(rule1.validate("invalid")).thenReturn(false);
        when(rule2.validate("invalid")).thenReturn(true);

        // Test the password validation
        assertFalse(passwordService.validatePassword("invalid"));
    }
}