package com.example.application.mapper;

import com.example.domain.Role;
import com.example.infrastructure.entity.RoleEntity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoleEntityMapper extends EntityMapper<Role, RoleEntity> {
    
}
