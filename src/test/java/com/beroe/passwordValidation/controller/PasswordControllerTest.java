package com.beroe.passwordValidation.controller;

import com.beroe.passwordValidation.dto.PasswordRequest;
import com.beroe.passwordValidation.service.PasswordValidatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PasswordController.class)
public class PasswordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordValidatorService validatorService;

    @Test
    public void testValidPassword() throws Exception {
        PasswordRequest request = new PasswordRequest();
        request.setPassword("abc123");

        when(validatorService.validate("abc123")).thenReturn(true);

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\":\"abc123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Password is valid."));
    }

    @Test
    public void testInvalidPassword() throws Exception {
        PasswordRequest request = new PasswordRequest();
        request.setPassword("ABC123");

        when(validatorService.validate("ABC123")).thenReturn(false);

        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\":\"ABC123\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Password is invalid."));
    }

    @Test
    public void testEmptyPassword() throws Exception {
        mockMvc.perform(post("/api/password/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"password\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Password is invalid."));
    }
}
