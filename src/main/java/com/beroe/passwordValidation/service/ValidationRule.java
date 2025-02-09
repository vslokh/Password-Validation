package com.beroe.passwordValidation.service;

@FunctionalInterface
public interface ValidationRule {
    boolean validate(String password);
}
