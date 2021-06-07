package com.innoventes.jukebox.repository;

import com.innoventes.jukebox.models.entity.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AbstractUser, Integer> {

    Optional<AbstractUser> findUserByEmail(String email);
}
