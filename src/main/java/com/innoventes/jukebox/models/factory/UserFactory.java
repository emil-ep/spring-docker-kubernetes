package com.innoventes.jukebox.models.factory;

import com.innoventes.jukebox.constants.UserType;
import com.innoventes.jukebox.models.entity.AbstractUser;
import com.innoventes.jukebox.models.entity.JukeboxAdmin;
import com.innoventes.jukebox.models.request.UpdateProfileRequest;

public class UserFactory {

    public static AbstractUser generateUser(UserType type, UpdateProfileRequest request){
        AbstractUser user = null;
        switch (type){
            case JUKEBOX_ADMIN:
                user = createAdmin(request);
                break;
            case JUKEBOX_USER:
                break;
        }
        return user;
    }

    public static AbstractUser createAdmin(UpdateProfileRequest request){
        return new JukeboxAdmin(
                request.getEmail(),
                request.getPassword(),
                request.getFirstName(),
                request.getLastName()
        );
    }
}
