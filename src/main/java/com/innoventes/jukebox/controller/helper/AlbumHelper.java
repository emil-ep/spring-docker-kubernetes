package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.models.request.AlbumRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.PageableResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.service.AlbumService;
import com.innoventes.jukebox.service.MusicianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Component
public class AlbumHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumHelper.class);

    @Autowired
    private AlbumService albumService;

    @Autowired
    private MusicianService musicianService;

    public ResponseEntity<JukeboxResponse> createAlbum(AlbumRequest request) {
        Set<Musician> musicianSet = null;
        if (request.getMusicianId() != null) {
            Optional<Musician> musicianOptional = musicianService.findById(request.getMusicianId());
            if (musicianOptional.isPresent()) {
                musicianSet = new HashSet<>();
                musicianSet.add(musicianOptional.get());
            }
        }
        MusicAlbum album = new MusicAlbum(
                request.getName(),
                request.getGenre(),
                request.getPrice(),
                request.getDescription(),
                Date.valueOf(request.getDateOfRelease()),
                musicianSet
        );
        MusicAlbum musicAlbum = albumService.createAlbum(album);
        return ResponseEntity.ok(new SuccessResponse(musicAlbum));
    }

    public ResponseEntity<JukeboxResponse> fetchAlbumWithPagination(int musicianId, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Optional<Musician> musicianOptional = musicianService.findById((long) musicianId);
        if (musicianOptional.isPresent()) {
            Page<MusicAlbum> musicAlbums = albumService.fetchMusicAlbumsByMusician(musicianOptional.get(), pageable);
            return ResponseEntity.ok(new PageableResponse(musicAlbums.getContent(), musicAlbums.getTotalElements()));
        } else {
            LOGGER.error("Musician not found with id : {}", musicianId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Musician with id :" + musicianId + " not found"));
        }
    }

    public ResponseEntity<JukeboxResponse> fetchAlbumsSortedByDate() {
        List<MusicAlbum> sortedAlbums = albumService.sortAllAlbumsWithDate();
        return ResponseEntity.ok(new SuccessResponse(sortedAlbums));
    }
}
