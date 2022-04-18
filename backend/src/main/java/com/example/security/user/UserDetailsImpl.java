package com.example.security.user;

import java.util.Collection;
import java.util.Collections;

import com.example.infrastructure.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {
    String id;
    String username;

    @JsonIgnore
    String password;


    public UserDetailsImpl(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();

    }

    public static UserDetailsImpl build(UserEntity userEntity) {
        return new UserDetailsImpl(userEntity);
    }

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
