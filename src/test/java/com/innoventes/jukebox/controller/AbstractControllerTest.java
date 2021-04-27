package com.innoventes.jukebox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
public class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
}
