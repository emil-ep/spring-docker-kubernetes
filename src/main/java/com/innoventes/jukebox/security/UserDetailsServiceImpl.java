package com.innoventes.jukebox.security;

import com.innoventes.jukebox.models.entity.AbstractUser;
import com.innoventes.jukebox.repository.AbstractUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AbstractUserRepository<AbstractUser> abstractUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AbstractUser user = abstractUserRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Jukebox user not found with the given email address : " + email));
        return UserDetailsImpl.build(user);
    }
}
