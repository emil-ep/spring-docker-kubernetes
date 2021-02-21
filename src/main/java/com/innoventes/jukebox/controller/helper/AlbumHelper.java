package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.request.AlbumRequest;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AlbumHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumHelper.class);

    @Autowired
    private AlbumService albumService;

    public ResponseEntity<JukeboxResponse> createAlbum(AlbumRequest request) {
        MusicAlbum album = new MusicAlbum(
                request.getName(),
                request.getGenre(),
                request.getPrice(),
                request.getDescription()
        );
        MusicAlbum musicAlbum = albumService.createAlbum(album);
        return ResponseEntity.ok(new SuccessResponse(musicAlbum));
    }
}
