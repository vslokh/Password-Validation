package com.beroe.passwordValidation.service;

import com.beroe.passwordValidation.rules.PasswordRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordValidatorService {
    private final List<PasswordRule> rules;

    public PasswordValidatorService(List<PasswordRule> rules) {
        this.rules = rules;
    }

    public boolean validate(String password) {
        return rules.stream().allMatch(rule -> rule.validate(password));
    }
}
