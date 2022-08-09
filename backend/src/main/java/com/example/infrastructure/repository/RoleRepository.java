package com.example.infrastructure.repository;

import com.example.infrastructure.entity.RoleEntity;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    public RoleEntity findByRoleName(String roleName);
}
