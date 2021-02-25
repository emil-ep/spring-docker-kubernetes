package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.repository.MusicianRepository;
import com.innoventes.jukebox.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicianServiceImpl implements MusicianService {


    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public Musician createMusician(Musician musician) {
        return musicianRepository.save(musician);
    }

    @Override
    public Optional<Musician> findByName(String name) {
        return musicianRepository.findByName(name);
    }

    @Override
    public Optional<Musician> findById(Long id) {
        return musicianRepository.findById(id);
    }

    @Override
    public Musician updateMusician(Musician musician) {
        return musicianRepository.save(musician);
    }

    @Override
    public Page<Musician> fetchMusiciansByAlbum(MusicAlbum album, Pageable pageable) {
        return musicianRepository.fetchMusiciansByAlbumSortedByName(album.getId(), pageable);
    }


}
