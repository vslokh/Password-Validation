package com.beroe.passwordValidation.service;


import com.beroe.passwordValidation.rules.LowercaseAndDigitRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class PasswordValidatorServiceTest {
    @Test
    public void testValidPassword() {
        PasswordValidatorService service = new PasswordValidatorService(Collections.singletonList(new LowercaseAndDigitRule()));
        Assertions.assertTrue(service.validate("abc123"));
    }

    @Test
    public void testInvalidPassword() {
        PasswordValidatorService service = new PasswordValidatorService(Collections.singletonList(new LowercaseAndDigitRule()));
        Assertions.assertFalse(service.validate("ABC123"));
    }
}
