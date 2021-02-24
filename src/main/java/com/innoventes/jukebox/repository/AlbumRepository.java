package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumRepository extends JpaRepository<MusicAlbum, Long> {

    @Query("SELECT a FROM tbl_music_album a ORDER BY price")
    Page<MusicAlbum> fetchMusicAlbums(Pageable pageable);

    @Query("SELECT a FROM tbl_music_album a join a.musician m where m.id = ?1 ORDER BY a.price")
    Page<MusicAlbum> fetchMusicAlbumsByMusician(Long musicianId, Pageable pageable);

}
