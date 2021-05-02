package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.LinkedHashMap;
import java.util.Objects;

import static com.innoventes.jukebox.constants.ApiConstants.API_SIGN_IN;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@Component
public class TestAuthHelper {

    public static final String AUTH_BEARER_PREFIX = "Bearer ";

    @Autowired
    private MockMvc mockMvc;

    public String getAuthHeader(String email, String password) throws Exception {
        LoginRequest loginRequest = new LoginRequest(email, password);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(API_SIGN_IN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(CommonUtils.convertToJson(loginRequest)))
                .accept(MediaType.APPLICATION_JSON);
        ResultActions result = mockMvc
                .perform(requestBuilder)
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json"));

        String resultString = result.andReturn().getResponse().getContentAsString();
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        LinkedHashMap<String, String> resultMap = (LinkedHashMap<String, String>)jsonParser.parseMap(resultString).get("body");
        return AUTH_BEARER_PREFIX + resultMap.get("token").toString();
    }
}
