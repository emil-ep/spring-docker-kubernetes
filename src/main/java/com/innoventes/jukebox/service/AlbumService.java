package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import org.springframework.stereotype.Service;

@Service
public interface AlbumService {

    MusicAlbum createAlbum(MusicAlbum album);

    MusicAlbum updateAlbum(MusicAlbum album);
}
