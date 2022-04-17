package com.example.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.application.dto.request.UserRequest;
import com.example.application.mapper.UserEntityMapper;
import com.example.application.service.UserService;
import com.example.domain.User;
import com.example.infrastructure.entity.UserEntity;
import com.example.infrastructure.repository.UserRepository;
import com.google.common.collect.Streams;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserEntityMapper userEntityMapper;

    @Override
    public List<User> getListUser() {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        return Streams.stream(userEntities).map(userEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public User getUserByID(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User addUser(UserRequest userRequest) {
        User user = new User(userRequest);
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public User updateUser(UserRequest userRequest, String userID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeUser(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<User> searchUserByGenderAndName(String gender, String name) {
        Iterable<UserEntity> userEntities = userRepository.findByGenderAndName(gender, name);
        return Streams.stream(userEntities).map(userEntityMapper::toDomain).collect(Collectors.toList());
    }
    
}
