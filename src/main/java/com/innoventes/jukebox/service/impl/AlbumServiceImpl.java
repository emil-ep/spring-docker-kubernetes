package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import com.innoventes.jukebox.repository.AlbumRepository;
import com.innoventes.jukebox.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public MusicAlbum createAlbum(MusicAlbum album) {
        return albumRepository.save(album);
    }

    @Override
    public MusicAlbum updateAlbum(MusicAlbum album) {
        return null;
    }

    @Override
    public Page<MusicAlbum> fetchMusicAlbumsByMusician(Musician musician, Pageable pageable) {
        return albumRepository.fetchMusicAlbumsByMusician(pageable, musician.getId());
    }

    @Override
    public List<MusicAlbum> sortAllAlbumsWithDate() {
        List<MusicAlbum> musicAlbums = albumRepository.findAll();
        return musicAlbums.stream().sorted((o1, o2) -> {
            if (o1.getDateOfRelease() == null || o2.getDateOfRelease() == null)
                return 0;
            return o1.getDateOfRelease().compareTo(o2.getDateOfRelease());
        }).collect(Collectors.toList());
    }
}
