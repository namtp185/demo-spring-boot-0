package com.example.domain;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRole {
    private String id;
    private String userId;
    private int roleId;

    public UserRole(String userId, int roleId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.roleId = roleId;
    }
}
