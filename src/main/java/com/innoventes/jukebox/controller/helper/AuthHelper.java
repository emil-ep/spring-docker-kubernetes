package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.JwtResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.security.UserDetailsImpl;
import com.innoventes.jukebox.security.UserDetailsServiceImpl;
import com.innoventes.jukebox.security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthHelper {

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthHelper.class);

    public ResponseEntity<JukeboxResponse> signInUser(LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    ));

            String jwt = jwtUtils.generateWebToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return ResponseEntity.ok(new SuccessResponse(new JwtResponse(userDetails.getId(), jwt, userDetails.getEmail())));

        }catch (Exception ex){
            LOGGER.error("Error while signing in User with email : {}", loginRequest.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("Unable to Login, Please check credentials"));
        }
    }
}
