package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.SwaggerConstants;
import com.innoventes.jukebox.controller.helper.AlbumHelper;
import com.innoventes.jukebox.models.request.AlbumRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.innoventes.jukebox.constants.ApiConstants.*;

@RestController
@Api(tags = {SwaggerConstants.ALBUM_MANAGEMENT})
public class AlbumController {


    @Autowired
    private AlbumHelper albumHelper;

    @PutMapping(ALBUM_BASE_PATH)
    public ResponseEntity<JukeboxResponse> createNewAlbum(@Valid @RequestBody AlbumRequest request) {
        return albumHelper.createAlbum(request);
    }

    @PatchMapping(ALBUM_BASE_PATH)
    public ResponseEntity<JukeboxResponse> updateAlbum(@Valid @RequestBody AlbumRequest request){
        return albumHelper.updateAlbum(request);
    }


    @GetMapping(API_ALBUM_SORT_BY_PRICE)
    public ResponseEntity<JukeboxResponse> fetchMusicAlbumsByPrice(@RequestParam int musicianId,@RequestParam int pageNo, @RequestParam int size) {
        return albumHelper.fetchAlbumWithPagination(musicianId, pageNo, size);
    }

    @GetMapping(API_ALBUM_SORT_BY_DATE)
    public ResponseEntity<JukeboxResponse> fetchMusicAlbumsByDate() {
        return albumHelper.fetchAlbumsSortedByDate();
    }
}
