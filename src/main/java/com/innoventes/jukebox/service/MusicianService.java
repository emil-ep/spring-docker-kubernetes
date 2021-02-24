package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MusicianService {

    Musician createMusician(Musician musician);

    Optional<Musician> findByName(String name);

    Optional<Musician> findById(Long id);

    Musician updateMusician(Musician musician);

    Page<Musician> fetchMusiciansByAlbum(MusicAlbum album, Pageable pageable);
}
