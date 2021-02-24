package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

    Optional<Musician> findByName(String name);
}
