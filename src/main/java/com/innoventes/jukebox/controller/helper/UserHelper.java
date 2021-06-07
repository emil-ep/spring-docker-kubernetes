package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.models.entity.AbstractUser;
import com.innoventes.jukebox.models.request.UpdateProfileRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserHelper.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<JukeboxResponse> updateProfileDetails(UpdateProfileRequest request) {
        Optional<AbstractUser> userOptional = userService.findUserById(request.getId());
        if (userOptional.isPresent()) {
            AbstractUser user = userOptional.get();
            try {
                return ResponseEntity.ok(new SuccessResponse(userService.updateUser(user, request)));
            } catch (JukeBoxInternalServerException ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ErrorResponse(ex.getMessage()));
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("User with id + " + request.getId() + " not found"));
        }
    }

    public ResponseEntity<JukeboxResponse> fetchProfileDetails(Integer id){
        Optional<AbstractUser> userOptional = userService.findUserById(id);
        return userOptional.<ResponseEntity<JukeboxResponse>>map(
                abstractUser -> ResponseEntity.ok(new SuccessResponse(abstractUser)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("User details not found")));
    }
}
