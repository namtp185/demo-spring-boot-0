package com.example.application.mapper;

import com.example.domain.User;
import com.example.infrastructure.entity.UserEntity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserEntityMapper extends EntityMapper<User, UserEntity> {
    
}
