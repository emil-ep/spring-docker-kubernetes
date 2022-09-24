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
import java.util.stream.Collectors;


@Component
public class AlbumHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumHelper.class);

    @Autowired
    private AlbumService albumService;

    @Autowired
    private MusicianService musicianService;

    public ResponseEntity<JukeboxResponse> createAlbum(AlbumRequest request) {
        Set<Musician> musicianSet = new HashSet<>();
        if (request.getMusicianId() != null) {
            for (Long id : request.getMusicianId()) {
                Optional<Musician> musicianOptional = musicianService.findById(id);
                musicianOptional.ifPresent(musicianSet::add);
            }
        }
        MusicAlbum album = new MusicAlbum(
                request.getName(),
                request.getGenre(),
                request.getPrice(),
                request.getDescription(),
                request.getDateOfRelease(),
                musicianSet
        );
        MusicAlbum musicAlbum = albumService.save(album);
        return ResponseEntity.ok(new SuccessResponse(musicAlbum));
    }

    public ResponseEntity<JukeboxResponse> updateAlbum(AlbumRequest request) {
        if (request.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Please provide album Id"));
        }
        Optional<MusicAlbum> musicAlbumOptional = albumService.findById(request.getId());
        if (!musicAlbumOptional.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Music Album with id "
                    + request.getId() + " not found"));
        else {
            MusicAlbum musicAlbum = musicAlbumOptional.get();
            if (request.getDateOfRelease() != null)
                musicAlbum.setDateOfRelease(request.getDateOfRelease());
            if (request.getGenre() != null)
                musicAlbum.setGenre(request.getGenre());
            if (request.getPrice() != null)
                musicAlbum.setPrice(request.getPrice());
            if (request.getDescription() != null)
                musicAlbum.setDescription(request.getDescription());
            if (request.getMusicianId() != null) {
                Set<Musician> musicians = request.getMusicianId().stream().map(id -> {
                            Optional<Musician> musician = musicianService.findById(id);
                            return musician.orElse(null);
                        }
                ).collect(Collectors.toSet());
                musicAlbum.setMusician(musicians);
            }
            if (request.getName() != null)
                musicAlbum.setName(request.getName());
            MusicAlbum savedAlbum = albumService.save(musicAlbum);
            return ResponseEntity.ok(new SuccessResponse(savedAlbum));
        }
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
