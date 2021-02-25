package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.MusicianHelper;
import com.innoventes.jukebox.models.request.MusicianRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/musician")
public class MusicianController {

    @Autowired
    private MusicianHelper musicianHelper;


    @PutMapping
    public ResponseEntity<JukeboxResponse> addMusician(@Valid @RequestBody MusicianRequest request) {
        return musicianHelper.createMusician(request);
    }

    @PatchMapping
    public ResponseEntity<JukeboxResponse> updateMusician(@Valid @RequestBody MusicianRequest request) {
        return musicianHelper.updateMusician(request);
    }

    @GetMapping("/sort/name")
    public ResponseEntity<JukeboxResponse> fetchMusicianList(@RequestParam Integer albumId, @RequestParam int pageNo, @RequestParam int size){
        return musicianHelper.fetchMusicianWithPagination(albumId, pageNo, size);
    }
}
