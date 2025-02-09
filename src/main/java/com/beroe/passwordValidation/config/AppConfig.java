package com.beroe.passwordValidation.config;

import com.beroe.passwordValidation.service.ValidationRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public ValidationRule lowercaseAndDigitsRule() {
        return password -> password.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]+$");
    }

    @Bean
    public ValidationRule minimumLengthRule() {
        return password -> password.length() >= 8;
    }

    @Bean
    public List<ValidationRule> validationRules() {
        return List.of(lowercaseAndDigitsRule(), minimumLengthRule());
    }
}
