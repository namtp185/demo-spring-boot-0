package com.example.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(length = 40)
    private String username;

    @Column(length = 80)
    @JsonIgnore
    private String password;

    @Column(length = 40)
    private String name;

    private int age;

    @Column(length = 40)
    private String occupation;
    
    @Column(length = 40)
    private String gender;
}
