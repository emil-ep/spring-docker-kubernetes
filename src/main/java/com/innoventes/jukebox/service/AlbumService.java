package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AlbumService {

    MusicAlbum save(MusicAlbum album);

    Optional<MusicAlbum> findById(Long id);

    MusicAlbum updateAlbum(MusicAlbum album);

    Page<MusicAlbum> fetchMusicAlbumsByMusician(Musician musician, Pageable pageable);

    List<MusicAlbum> sortAllAlbumsWithDate();
}
