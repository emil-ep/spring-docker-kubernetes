package com.innoventes.jukebox.service.impl;

import com.innoventes.jukebox.constants.UserType;
import com.innoventes.jukebox.exceptions.JukeBoxInternalServerException;
import com.innoventes.jukebox.exceptions.JukeboxNotFoundException;
import com.innoventes.jukebox.models.entity.AbstractUser;
import com.innoventes.jukebox.models.entity.FileStore;
import com.innoventes.jukebox.models.entity.JukeboxAdmin;
import com.innoventes.jukebox.models.request.UpdateProfileRequest;
import com.innoventes.jukebox.repository.AbstractUserRepository;
import com.innoventes.jukebox.repository.JukeboxAdminRepository;
import com.innoventes.jukebox.service.StorageService;
import com.innoventes.jukebox.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AbstractUserRepository<AbstractUser> abstractUserRepository;

    @Autowired
    private JukeboxAdminRepository adminRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private StorageService storageService;

    @Override
    public Optional<AbstractUser> findUserById(Integer id) {
        return abstractUserRepository.findById(id);
    }

    @Override
    public AbstractUser findUserByEmail(String email) {
        Optional<AbstractUser> abstractUserOptional = abstractUserRepository.findUserByEmail(email);
        if (abstractUserOptional.isPresent()){
            AbstractUser user = abstractUserOptional.get();
            if (user.getProfilePic() != null){
                String profilePicDownloadUrl = storageService.getDownloadUrl(user.getProfilePic());
                user.getProfilePic().setDownloadUri(profilePicDownloadUrl);
            }
            return user;
        }else{
            throw new JukeboxNotFoundException("User with email " + email + " not found");
        }
    }

    @Override
    public AbstractUser updateUser(UpdateProfileRequest updateProfileRequest) {
        UserType userType = UserType.valueOf(updateProfileRequest.getUserType());
        switch (userType){
            case JUKEBOX_ADMIN:
                Optional<JukeboxAdmin> adminOptional = adminRepository.findById(updateProfileRequest.getId());
                JukeboxAdmin admin;
                if (adminOptional.isPresent()){
                    admin = adminOptional.get();
                    admin.setFirstName(updateProfileRequest.getFirstName());
                    admin.setLastName(updateProfileRequest.getLastName());
                }else{
                    throw new JukeboxNotFoundException("User with id " + updateProfileRequest.getId() + " not found");
                }
                adminRepository.save(admin);
                return admin;
            case JUKEBOX_USER:
                throw new JukeBoxInternalServerException("Jukebox user type is not handled for transaction");
            default:
                throw new JukeBoxInternalServerException("Usertype not handled for saving in database");
        }
    }

    @Override
    public Boolean updateProfilePic(MultipartFile multipartFile, AbstractUser user) {
        FileStore fileStore = storageService.store(multipartFile);
        user.setProfilePic(fileStore);
        abstractUserRepository.save(user);
        return true;
    }

}
