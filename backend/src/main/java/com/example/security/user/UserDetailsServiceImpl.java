package com.example.security.user;

import javax.transaction.Transactional;

import com.example.application.service.UserService;
import com.example.domain.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username debug " + username);
        User user = userService.getUserByUsername(username);
        
        log.info("user domain object " + user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return UserDetailsImpl.build(user);
    }
    
}
