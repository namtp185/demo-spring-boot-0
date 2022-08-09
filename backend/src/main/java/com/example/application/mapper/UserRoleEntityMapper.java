package com.example.application.mapper;

import com.example.domain.UserRole;
import com.example.infrastructure.entity.UserRoleEntity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserRoleEntityMapper extends EntityMapper<UserRole, UserRoleEntity> {
    
}
