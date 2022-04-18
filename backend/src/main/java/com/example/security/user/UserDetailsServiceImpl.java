package com.example.security.user;

import javax.transaction.Transactional;

import com.example.infrastructure.entity.UserEntity;
import com.example.infrastructure.repository.UserRepository;

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

    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username debug " + username);
        UserEntity userEntity = userRepository.findByUsername(username);
        log.info("user entity " + userEntity);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }

        return UserDetailsImpl.build(userEntity);
    }
    
}
