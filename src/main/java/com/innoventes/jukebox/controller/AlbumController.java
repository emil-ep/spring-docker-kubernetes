package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.controller.helper.AlbumHelper;
import com.innoventes.jukebox.models.request.AlbumRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumController {


    @Autowired
    private AlbumHelper albumHelper;

    @PutMapping("/")
    public ResponseEntity<JukeboxResponse> createNewAlbum(@Valid @RequestBody AlbumRequest request) {
        return albumHelper.createAlbum(request);
    }

    @PatchMapping("/")
    public ResponseEntity<JukeboxResponse> updateAlbum(@Valid @RequestBody AlbumRequest request){
        return albumHelper.updateAlbum(request);
    }


    @GetMapping("/sort/price")
    public ResponseEntity<JukeboxResponse> fetchMusicAlbumsByPrice(@RequestParam int musicianId,@RequestParam int pageNo, @RequestParam int size) {
        return albumHelper.fetchAlbumWithPagination(musicianId, pageNo, size);
    }

    @GetMapping("/sort/date")
    public ResponseEntity<JukeboxResponse> fetchMusicAlbumsByDate() {
        return albumHelper.fetchAlbumsSortedByDate();
    }
}
