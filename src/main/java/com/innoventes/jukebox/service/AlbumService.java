package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AlbumService {

    MusicAlbum createAlbum(MusicAlbum album);

    MusicAlbum updateAlbum(MusicAlbum album);

    Page<MusicAlbum> fetchMusicAlbums(Pageable pageable);
}
