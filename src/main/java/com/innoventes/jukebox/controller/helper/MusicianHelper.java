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

import java.util.Optional;

@Component
public class MusicianHelper {

    @Autowired
    private MusicianService musicianService;

    public ResponseEntity<JukeboxResponse> createMusician(MusicianRequest request) {
        if (musicianService.findByName(request.getName()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("Musician with name " +
                    request.getName() + " already exists"));
        else {
            Musician musician = new Musician(request.getType(), request.getName());
            return ResponseEntity.ok(new SuccessResponse(musicianService.createMusician(musician)));
        }
    }

    public ResponseEntity<JukeboxResponse> updateMusician(MusicianRequest request) {
        Optional<Musician> musicianOptional = musicianService.findById(request.getId());
        if (musicianOptional.isPresent()) {
            Musician musician = musicianOptional.get();
            musician.setName(request.getName());
            musician.setType(request.getType());
            return ResponseEntity.ok(new SuccessResponse(musicianService.updateMusician(musician)));

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Musician with id " +
                    request.getId() + " doesn't exists"));
        }
    }
}
