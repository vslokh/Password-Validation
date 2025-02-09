package com.beroe.passwordValidation.rules;

import org.springframework.stereotype.Component;

@Component
public class LowercaseAndDigitRule implements PasswordRule {
    @Override
    public boolean validate(String password) {
        return password.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]+$");
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least one lowercase letter and one digit.";
    }
}
