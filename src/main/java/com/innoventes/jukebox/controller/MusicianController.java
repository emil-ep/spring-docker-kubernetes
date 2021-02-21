package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.MusicianHelper;
import com.innoventes.jukebox.models.request.MusicianRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/musician")
public class MusicianController {

    @Autowired
    private MusicianHelper musicianHelper;


    public ResponseEntity<JukeboxResponse> addMusician(@Valid @RequestBody MusicianRequest request){
        return musicianHelper.createMusician(request);
    }
}
