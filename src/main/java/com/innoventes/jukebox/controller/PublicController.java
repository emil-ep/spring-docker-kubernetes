package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.SwaggerConstants;
import com.innoventes.jukebox.controller.helper.PublicHelper;
import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.innoventes.jukebox.constants.ApiConstants.*;

@RestController
@Api(tags = {SwaggerConstants.AUTHENTICATION_MANAGEMENT})
public class PublicController {

    @Autowired
    private PublicHelper publicHelper;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping(API_SIGN_IN)
    public ResponseEntity<JukeboxResponse> signInUser(@RequestBody LoginRequest request) {
        return publicHelper.signInUser(request);
    }

    @GetMapping(API_ENCRYPT)
    public ResponseEntity<JukeboxResponse> encrypt(@PathVariable String var){
        return ResponseEntity.ok(new SuccessResponse(encoder.encode(var)));
    }

    @GetMapping(API_DOWNLOAD_FILE)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        return publicHelper.downloadFile(fileName, request);
    }
}
