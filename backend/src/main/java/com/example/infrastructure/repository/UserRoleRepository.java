package com.example.infrastructure.repository;

import java.util.List;

import com.example.infrastructure.entity.UserRoleEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity, String> {
    public List<UserRoleEntity> findByUserId(String userId);
}
