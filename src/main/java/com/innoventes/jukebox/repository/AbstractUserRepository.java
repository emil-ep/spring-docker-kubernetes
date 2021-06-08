package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbstractUserRepository<T extends AbstractUser> extends JpaRepository<T, Integer> {

    Optional<T> findUserByEmail(String email);
}
