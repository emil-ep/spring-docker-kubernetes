package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.AlbumHelper;
import com.innoventes.jukebox.models.request.AlbumRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {


    @Autowired
    private AlbumHelper albumHelper;

    @PutMapping("/")
    public ResponseEntity<JukeboxResponse> createNewAlbum(@Valid @RequestBody AlbumRequest request){
        return albumHelper.createAlbum(request);
    }
}
