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

@Component
public class MusicianHelper {

    @Autowired
    private MusicianService musicianService;

    @Autowired
    private AlbumService albumService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MusicianHelper.class);

    public ResponseEntity<JukeboxResponse> createMusician(MusicianRequest request) {
        if (musicianService.findByName(request.getName()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("Musician with name " +
                    request.getName() + " already exists"));
        else {
            Set<MusicAlbum> musicAlbumSet = new HashSet<>();
            if (request.getAlbumIds() != null){
                for (Long id : request.getAlbumIds()){
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
            musician.setName(request.getName());
            musician.setType(request.getType());
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
