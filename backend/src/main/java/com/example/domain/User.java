package com.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.application.dto.request.UserRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String id;
    private String username;

    @JsonIgnore
    private String password;
    
    private String name;
    private int age;
    private String occupation;
    private String gender;
    private List<Role> roles;

    private boolean isEnabled;
    private String email;


    public User(UserRequest userRequest) {
        this.id = userRequest.getId() != null ? userRequest.getId() : UUID.randomUUID().toString();
        this.username = userRequest.getUsername();
        this.password = userRequest.getPassword();
        this.name = userRequest.getName();
        this.age = userRequest.getAge();
        this.occupation = userRequest.getOccupation();
        this.gender = userRequest.getGender();
        this.roles = new ArrayList<>();

        this.isEnabled = userRequest.isEnabled();
        this.email = userRequest.getEmail();
    }

    public void enrichPassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
