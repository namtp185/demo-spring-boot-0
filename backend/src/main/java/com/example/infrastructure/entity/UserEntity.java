package com.example.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserEntity {
    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(length = 30)
    private String username;

    @Column(length = 80)
    @JsonIgnore
    private String password;

    @Column(length = 30)
    private String name;

    private int age;

    @Column(length = 30)
    private String occupation;
    
    @Column(length = 30)
    private String gender;
}
