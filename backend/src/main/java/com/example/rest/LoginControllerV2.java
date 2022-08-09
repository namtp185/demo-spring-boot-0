package com.example.rest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.example.application.dto.request.LoginRequest;
import com.example.application.dto.response.JwtResponse;
import com.example.security.jwt.JwtTokenProvider;
import com.example.security.user.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v2/login", consumes = MediaType.APPLICATION_JSON_VALUE)
public class LoginControllerV2 {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping()
    public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        System.out.println("passs " + password + ", " + username);
        // UserDetailsImpl userDetailsImpl = (UserDetailsImpl)userDetailsService.loadUserByUsername(username);
        
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), 
                    loginRequest.getPassword()
                    // userDetailsImpl.getAuthorities()
                )
            );

        // if no expections are thrown, it indicates that information is legal
        // set authentication info for Security Context

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // return jwt for user
        String jwt = jwtTokenProvider.generateToken((UserDetailsImpl) authentication.getPrincipal());
        // convert expiredTime from milliseconds to LocalDateTime.
        Long expiredTimeMs = jwtTokenProvider.getExpiredTimeMs(jwt);
        LocalDateTime expired = Instant.ofEpochMilli(expiredTimeMs).atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        return new JwtResponse(jwt, expired);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
