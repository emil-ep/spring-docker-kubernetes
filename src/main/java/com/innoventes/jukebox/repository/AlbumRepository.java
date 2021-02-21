package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.MusicAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<MusicAlbum, Long> {


}
