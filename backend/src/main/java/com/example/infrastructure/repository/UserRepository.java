package com.example.infrastructure.repository;

import java.util.List;

import com.example.infrastructure.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    List<UserEntity> findByGenderAndName(String gender, String name);
    UserEntity findByUsername(String username);
    UserEntity findById(String userId);
}
