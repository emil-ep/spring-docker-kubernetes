package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

    Optional<Musician> findByName(String name);

    @Query("SELECT a FROM tbl_musician a join a.albums m where m.id = ?1 ORDER BY a.name")
    Page<Musician> fetchMusiciansByAlbumSortedByName(Long albumId, Pageable pageable);
}
