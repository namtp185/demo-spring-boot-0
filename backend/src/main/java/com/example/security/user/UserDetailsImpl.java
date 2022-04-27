package com.example.security.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.domain.Role;
import com.example.domain.User;
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

    boolean isEnabled;
    List<Role> roles;


    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.isEnabled = user.isEnabled();
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(user);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	for (Role role: roles) {
    		authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    		// authorities.addAll(role.getPrivileges()
    		// 		.stream()
    		// 		.map(p -> new SimpleGrantedAuthority(p.getName()))
    		// 		.collect(Collectors.toList()));
    	}
        return authorities;
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
        return isEnabled;
    }
    
}
