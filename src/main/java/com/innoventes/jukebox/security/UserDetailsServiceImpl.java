package com.innoventes.jukebox.security;

import com.innoventes.jukebox.models.entity.JukeboxUser;
import com.innoventes.jukebox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JukeboxUser user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Jukebox user not found with the given email address : " + email));
        return UserDetailsImpl.build(user);
    }
}
