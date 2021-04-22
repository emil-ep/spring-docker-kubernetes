package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.AuthHelper;
import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.innoventes.jukebox.constants.ApiConstants.AUTHENTICATION_BASE_PATH;

@RestController
@RequestMapping(AUTHENTICATION_BASE_PATH)
public class AuthController {

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping("/signIn")
    public ResponseEntity<JukeboxResponse> signInUser(@RequestBody LoginRequest request) {
        return authHelper.signInUser(request);
    }

    @GetMapping("/encrypt/{var}")
    public ResponseEntity<JukeboxResponse> encrypt(@PathVariable String var){
        return ResponseEntity.ok(new SuccessResponse(encoder.encode(var)));
    }
}
