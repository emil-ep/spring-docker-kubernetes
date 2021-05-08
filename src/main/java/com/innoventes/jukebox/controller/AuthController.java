package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.SwaggerConstants;
import com.innoventes.jukebox.controller.helper.AuthHelper;
import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.innoventes.jukebox.constants.ApiConstants.*;

@RestController
@Api(tags = {SwaggerConstants.AUTHENTICATION_MANAGEMENT})
public class AuthController {

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping(API_SIGN_IN)
    public ResponseEntity<JukeboxResponse> signInUser(@RequestBody LoginRequest request) {
        return authHelper.signInUser(request);
    }

    @GetMapping(API_ENCRYPT)
    public ResponseEntity<JukeboxResponse> encrypt(@PathVariable String var){
        return ResponseEntity.ok(new SuccessResponse(encoder.encode(var)));
    }
}
