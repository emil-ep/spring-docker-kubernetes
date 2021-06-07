package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.constants.UserType;
import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.models.entity.AbstractUser;
import com.innoventes.jukebox.models.factory.UserFactory;
import com.innoventes.jukebox.models.request.UpdateProfileRequest;
import com.innoventes.jukebox.repository.UserRepository;
import com.innoventes.jukebox.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<AbstractUser> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public AbstractUser updateUser(AbstractUser user, UpdateProfileRequest updateProfileRequest) {
        UserType userType = UserType.valueOf(user.getUserType());
        if (updateProfileRequest.getPassword() != null && !updateProfileRequest.getPassword().isEmpty())
            updateProfileRequest.setPassword(encoder.encode(updateProfileRequest.getPassword()));
        else
            updateProfileRequest.setPassword(user.getPassword());
        AbstractUser updateUser = UserFactory.generateUser(userType, updateProfileRequest);
        try {
            userRepository.save(updateUser);
            return updateUser;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw new JukeBoxInternalServerException(ex.getMessage());
        }
    }
}
