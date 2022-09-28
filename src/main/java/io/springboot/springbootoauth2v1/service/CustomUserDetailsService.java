package io.springboot.springbootoauth2v1.service;

import io.springboot.springbootoauth2v1.entity.User;
import io.springboot.springbootoauth2v1.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> dbUser= Optional.ofNullable(userRepository.findByEmail(username));
        User foundUser= dbUser.orElseGet(dbUser::orElseThrow);
        return new org.springframework.security.core.userdetails.User(
                foundUser.getFirstName(),
                foundUser.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(List.of(foundUser.getRole())));

    }
    private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles){
        List<GrantedAuthority> listAuthorities=new ArrayList<>();
        roles.forEach(role->{
            listAuthorities.add(new SimpleGrantedAuthority(role));
        });
        return listAuthorities;
    }


}
