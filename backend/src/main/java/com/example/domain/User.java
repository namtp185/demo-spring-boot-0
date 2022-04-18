package com.example.domain;

import java.util.UUID;

import com.example.application.dto.request.UserRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String occupation;
    private String gender;

    public User(UserRequest userRequest) {
        this.id = userRequest.getId() != null ? userRequest.getId() : UUID.randomUUID().toString();
        this.username = userRequest.getUsername();
        this.password = userRequest.getPassword();
        this.name = userRequest.getName();
        this.age = userRequest.getAge();
        this.occupation = userRequest.getOccupation();
        this.gender = userRequest.getGender();
    }

    public void enrichPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
