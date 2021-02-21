package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    public ResponseEntity<JukeboxResponse> signInUser(@RequestBody LoginRequest request){
        return null;
    }
}
