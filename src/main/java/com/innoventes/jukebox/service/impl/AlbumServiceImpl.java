package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.repository.AlbumRepository;
import com.innoventes.jukebox.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public MusicAlbum createAlbum(MusicAlbum album) {
        try {
            return albumRepository.save(album);
        } catch (Exception exception) {
            LOGGER.error("Unable to save music album : {} ", exception.getMessage());
            return null;
        }
    }

    @Override
    public MusicAlbum updateAlbum(MusicAlbum album) {
        return null;
    }
}
