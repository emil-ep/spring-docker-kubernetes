package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.JukeboxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JukeboxUser, Long> {

    Optional<JukeboxUser> findUserByEmail(String email);
}
