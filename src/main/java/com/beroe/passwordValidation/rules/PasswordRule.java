package com.beroe.passwordValidation.rules;

public interface PasswordRule {
    boolean validate(String password);
    String getErrorMessage();
}
