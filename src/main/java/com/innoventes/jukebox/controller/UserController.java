package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.ApiConstants;
import com.innoventes.jukebox.constants.SwaggerConstants;
import com.innoventes.jukebox.controller.helper.UserHelper;
import com.innoventes.jukebox.models.request.UpdateProfileRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@Api(tags = {SwaggerConstants.USER_MANAGEMENT})
public class UserController {

    @Autowired
    private UserHelper userHelper;

    @PatchMapping(ApiConstants.UPDATE_PROFILE_DETAILS)
    public ResponseEntity<JukeboxResponse> updateProfile(@RequestBody UpdateProfileRequest request) {
        return userHelper.updateProfileDetails(request);
    }

    @GetMapping(ApiConstants.GET_PROFILE_DETAILS)
    public ResponseEntity<JukeboxResponse> getProfile(@RequestHeader("Authorization") String authHeader) {
        return userHelper.fetchProfileDetails(authHeader);
    }

    @PostMapping(ApiConstants.UPDATE_PROFILE_PICTURE)
    public ResponseEntity<JukeboxResponse> updateProfilePic(@RequestParam("file") MultipartFile file,
                                                            @RequestHeader("Authorization") String authHeader){
        return userHelper.updateProfilePic(file, authHeader);
    }

    @GetMapping(ApiConstants.GET_PROFILE_PICTURE)
    public ResponseEntity<JukeboxResponse> getProfilePic(@RequestHeader("Authorization") String authHeader){
        return userHelper.getProfilePic(authHeader);
    }
}
