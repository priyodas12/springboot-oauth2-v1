package io.springboot.springbootoauth2v1.service;

import io.springboot.springbootoauth2v1.entity.User;
import io.springboot.springbootoauth2v1.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User dbUser=userRepository.findByName(username);
        return new org.springframework.security.core.userdetails.User(dbUser.getName(),
                                                                      dbUser.getPassword(),
                                                                      dbUser.getRoles());
    }
}
