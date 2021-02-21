package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.models.request.MusicianRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MusicianHelper {

    @Autowired
    private MusicianService musicianService;

    public ResponseEntity<JukeboxResponse> createMusician(MusicianRequest request){
        if (musicianService.findByName(request.getName()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("Musician with name " + request.getName() + " already exists"));
        else{
            Musician musician = new Musician(request.getType(), request.getName());
            return ResponseEntity.ok(new SuccessResponse(musicianService.createMusician(musician)));
        }
    }
}
