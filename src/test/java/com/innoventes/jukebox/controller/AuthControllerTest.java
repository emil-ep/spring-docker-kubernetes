package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.ApiConstants;
import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.security.jwt.JwtUtils;
import com.innoventes.jukebox.util.CommonUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Mock
    private JwtUtils jwtUtils;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PasswordEncoder passwordEncoder;


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

//    @Test
//    public void callEncrypt() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(ApiConstants.API_ENCRYPT)
//                .param("var", "password")
//                .accept(MediaType.APPLICATION_JSON);
//        SuccessResponse response = new SuccessResponse(passwordEncoder.encode("password"));
//        mockMvc
//                .perform(requestBuilder)
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers
//                        .content()
//                        .json(Objects.requireNonNull(CommonUtils.convertToJson(response))));
//    }
}
