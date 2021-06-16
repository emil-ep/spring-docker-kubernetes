package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.exceptions.JukeboxNotFoundException;
import com.innoventes.jukebox.models.request.LoginRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.JwtResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.security.UserDetailsImpl;
import com.innoventes.jukebox.security.UserDetailsServiceImpl;
import com.innoventes.jukebox.security.jwt.JwtUtils;
import com.innoventes.jukebox.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class PublicHelper {

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StorageService storageService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicHelper.class);

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

    public ResponseEntity<Resource> downloadFile(String fileName, HttpServletRequest request) {
        Resource resource = null;
        if (fileName != null && !fileName.isEmpty()){
            try{
                resource = storageService.loadFileAsResource(fileName);
            }catch (Exception ex){
                LOGGER.error(ex.getMessage());
                throw new JukeboxNotFoundException("File named " + fileName + " not found");
            }
            String contentType = null;
            try{
                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            }catch (IOException ex){
                LOGGER.error("Could not determine the file type");
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
