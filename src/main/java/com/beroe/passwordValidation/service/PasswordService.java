package com.beroe.passwordValidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    private final List<ValidationRule> validationRules;

    @Autowired
    public PasswordService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public boolean validatePassword(String password) {
        return validationRules.stream().allMatch(rule -> rule.validate(password));
    }
}
