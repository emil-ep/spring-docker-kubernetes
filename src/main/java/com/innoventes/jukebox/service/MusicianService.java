package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MusicianService {

    Musician createMusician(Musician musician);

    Optional<Musician> findByName(String name);
}
