package com.innoventes.jukebox.controller.helper;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.models.request.MusicianRequest;
import com.innoventes.jukebox.models.response.ErrorResponse;
import com.innoventes.jukebox.models.response.JukeboxResponse;
import com.innoventes.jukebox.models.response.PageableResponse;
import com.innoventes.jukebox.models.response.SuccessResponse;
import com.innoventes.jukebox.service.AlbumService;
import com.innoventes.jukebox.service.MusicianService;
import com.innoventes.jukebox.util.MusicianUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MusicianHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(MusicianHelper.class);
    @Autowired
    private MusicianService musicianService;
    @Autowired
    private AlbumService albumService;

    public ResponseEntity<JukeboxResponse> createMusician(MusicianRequest request) {
        if (musicianService.findByName(request.getName()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("Musician with name " +
                    request.getName() + " already exists"));
        else {
            if (!MusicianUtility.validateMusicianType(request.getType()))
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Musician type is not " +
                        "valid!"));
            Set<MusicAlbum> musicAlbumSet = new HashSet<>();
            if (request.getAlbumIds() != null) {
                for (Long id : request.getAlbumIds()) {
                    Optional<MusicAlbum> musicAlbumOptional = albumService.findById(id);
                    musicAlbumOptional.ifPresent(musicAlbumSet::add);
                }
            }
            Musician musician = new Musician(request.getType(), request.getName(), musicAlbumSet);
            return ResponseEntity.ok(new SuccessResponse(musicianService.createMusician(musician)));
        }
    }

    public ResponseEntity<JukeboxResponse> updateMusician(MusicianRequest request) {
        Optional<Musician> musicianOptional = musicianService.findById(request.getId());
        if (musicianOptional.isPresent()) {
            Musician musician = musicianOptional.get();
            if (request.getName() != null)
                musician.setName(request.getName());
            if (request.getType() != null && !MusicianUtility.validateMusicianType(request.getType()))
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Musician type is not " +
                        "valid!"));
            if (request.getType() != null)
                musician.setType(request.getType());
            if (request.getAlbumIds() != null) {
                Set<MusicAlbum> albums = request.getAlbumIds().stream().map(id -> {
                    Optional<MusicAlbum> musicAlbumOptional = albumService.findById(id);
                    return musicAlbumOptional.orElse(null);
                }).collect(Collectors.toSet());
                musician.setAlbums(albums);
            }
            return ResponseEntity.ok(new SuccessResponse(musicianService.updateMusician(musician)));

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Musician with id " +
                    request.getId() + " doesn't exists"));
        }
    }

    public ResponseEntity<JukeboxResponse> fetchMusicianWithPagination(int albumId, int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Optional<MusicAlbum> albumOptional = albumService.findById((long) albumId);
        if (albumOptional.isPresent()) {
            Page<Musician> musicians = musicianService.fetchMusiciansByAlbum(albumOptional.get(), pageable);
            return ResponseEntity.ok(new PageableResponse(musicians.getContent(), musicians.getTotalElements()));
        } else {
            LOGGER.error("Album not found with id : {}", albumId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Album with id :" + albumId + " not found"));
        }
    }
}
