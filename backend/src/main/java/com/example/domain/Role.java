package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Role {
    @JsonIgnore
    private int id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
