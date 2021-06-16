package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.ApiConstants;
import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.util.CommonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class PublicControllerTest extends AbstractControllerTest{


    @Test
    public void callAuthenticationApiWithValidUser() throws Exception {
        LoginRequest loginRequest = new LoginRequest("admin@jukebox.com", "password");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(ApiConstants.API_SIGN_IN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(loginRequest)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void callAuthenticationApiWithInvalidUser() throws Exception {
        LoginRequest loginRequest = new LoginRequest("invalid@invalid.com", "password");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(ApiConstants.API_SIGN_IN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(loginRequest)))
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andDo(print()).andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void callEncrypt() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(ApiConstants.API_ENCRYPT, "password")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc
                .perform(requestBuilder)
                .andDo(print())
                .andExpect(MockMvcResultMatchers
                        .status()
                .isOk());
    }
}
