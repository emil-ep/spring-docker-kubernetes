package com.innoventes.jukebox.service;

import com.innoventes.jukebox.models.entity.AbstractUser;
import com.innoventes.jukebox.models.request.UpdateProfileRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<AbstractUser> findUserById(Integer id);

    Optional<AbstractUser> findUserByEmail(String email);

    AbstractUser updateUser(UpdateProfileRequest updateProfileRequest);
}
