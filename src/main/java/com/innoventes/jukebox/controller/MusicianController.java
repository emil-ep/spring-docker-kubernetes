package com.innoventes.jukebox.controller;

import com.innoventes.jukebox.constants.SwaggerConstants;
import com.innoventes.jukebox.controller.helper.MusicianHelper;
import com.innoventes.jukebox.models.request.MusicianRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.innoventes.jukebox.constants.ApiConstants.MUSICIAN_BASE_PATH;
import static com.innoventes.jukebox.constants.ApiConstants.MUSICIAN_SORT_BY_NAME;

@RestController
@Api(tags = {SwaggerConstants.MUSICIAN_MANAGEMENT})
public class MusicianController {

    @Autowired
    private MusicianHelper musicianHelper;


    @PostMapping(MUSICIAN_BASE_PATH)
    public ResponseEntity<JukeboxResponse> addMusician(@Valid @RequestBody MusicianRequest request,
                                                       @RequestHeader("Authorization") String authHeader) {
        return musicianHelper.createMusician(request);
    }

    @PatchMapping(MUSICIAN_BASE_PATH)
    public ResponseEntity<JukeboxResponse> updateMusician(@Valid @RequestBody MusicianRequest request,
                                                          @RequestHeader("Authorization") String authHeader) {
        return musicianHelper.updateMusician(request);
    }

    @GetMapping(MUSICIAN_SORT_BY_NAME)
    public ResponseEntity<JukeboxResponse> fetchMusicianList(@RequestParam Integer albumId, @RequestParam Integer pageNo,
                                                             @RequestParam Integer size,
                                                             @RequestHeader("Authorization") String authHeader){
        return musicianHelper.fetchMusicianWithPagination(albumId, pageNo, size);
    }
}
