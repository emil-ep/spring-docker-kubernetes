package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<MusicAlbum, Long> {

    @Query("SELECT a FROM tbl_music_album a ORDER BY price")
    Page<MusicAlbum> fetchMusicAlbums(Pageable pageable);


}
