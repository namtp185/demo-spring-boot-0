package com.example.application.service.impl;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.application.dto.request.UserRequest;
import com.example.application.mapper.RoleEntityMapper;
import com.example.application.mapper.UserEntityMapper;
import com.example.application.mapper.UserRoleEntityMapper;
import com.example.application.service.UserService;
import com.example.domain.Role;
import com.example.domain.User;
import com.example.domain.UserRole;
import com.example.infrastructure.entity.RoleEntity;
import com.example.infrastructure.entity.UserEntity;
import com.example.infrastructure.entity.UserRoleEntity;
import com.example.infrastructure.repository.RoleRepository;
import com.example.infrastructure.repository.UserRepository;
import com.example.infrastructure.repository.UserRoleRepository;
import com.google.common.collect.Streams;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserEntityMapper userEntityMapper;
    RoleRepository roleRepository;
    RoleEntityMapper roleEntityMapper;
    UserRoleRepository userRoleRepository;
    UserRoleEntityMapper userRoleEntityMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> getListUser() {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        List<User> users =  Streams.stream(userEntities).map(userEntityMapper::toDomain).collect(Collectors.toList());
        users.forEach(user -> {
            enrichUser(user);
        });
        return users;
    }

    public User getUserByUsername(String username) {
        // use functional interface
        return findUserByOneField(userRepository::findByUsername, username);
    }

    private void enrichUser(User user) {
        List<UserRoleEntity> userRoleEntities = userRoleRepository.findByUserId(user.getId());
        List<Role> roles = userRoleEntities.stream()
            .map(userRoleEntityMapper::toDomain)
            .map(userRole -> userRole.getRoleId())
            .map(roleId -> roleRepository.findById(roleId))
            .filter(optionalRoleEntity -> optionalRoleEntity.isPresent())
            .map(optionalRoleEntity -> optionalRoleEntity.get())
            .map(roleEntityMapper::toDomain)
            .collect(Collectors.toList())
            ;
        user.setRoles(roles);
    }

    
    private void assignUserRoleToUser(User user) {
        // prepare domain model 
        RoleEntity defaultRoleEntity = roleRepository.findByRoleName("User");
        Role defaultRole = roleEntityMapper.toDomain(defaultRoleEntity);
        user.addRole(defaultRole);

        // and persist data
        UserRole newUserRole = new UserRole(user.getId(), defaultRole.getId());
        UserRoleEntity newUserRoleEntity = userRoleEntityMapper.toEntity(newUserRole);
        userRoleRepository.save(newUserRoleEntity);
    }

    @Override
    public User getUserByID(String id) {
        // normal use
        UserEntity userEntity = userRepository.findById(id);
        return mapUserEntityToUser(userEntity);
        // // use functional interface
        // return findUserByOneField(userRepository::findById, id);
    }

    @Override
    public User addUser(UserRequest userRequest) {
        User user = new User(userRequest);
        user.enrichPassword(passwordEncoder.encode(user.getPassword()));

        assignUserRoleToUser(user);


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
        // Iterable<UserEntity> userEntities = userRepository.findByGenderAndName(gender, name);
        // return mapUserEntitiesToUsers(userEntities);
        return findUsersByTwoField(userRepository::findByGenderAndName, gender, name);
    }

    // private List<User> mapUserEntitiesToUsers(Iterable<UserEntity> userEntities) {
    //     List<User> users =  Streams.stream(userEntities).map(userEntityMapper::toDomain).collect(Collectors.toList());
    //     users.forEach(user -> {
    //         enrichUser(user);
    //     });
    //     return users;
    // }


    private User findUserByOneField(Function<String, UserEntity> userRepositoryFn, String keyword) {
        UserEntity userEntity = userRepositoryFn.apply(keyword);
        return mapUserEntityToUser(userEntity);
    }

    private List<User> findUsersByTwoField(BiFunction<String, String, List<UserEntity>> userRepositoryFn, String keyword1, String keyword2) {
        Iterable<UserEntity> userEntities = userRepositoryFn.apply(keyword1, keyword2);
        return mapUserEntitiesToUsers(userEntities);
    }

    private List<User> mapUserEntitiesToUsers(Iterable<UserEntity> userEntities) {
        List<User> users =  Streams.stream(userEntities).map(this::mapUserEntityToUser).collect(Collectors.toList());
        return users;
    }

    private User mapUserEntityToUser(UserEntity userEntity) {
        User user = userEntityMapper.toDomain(userEntity);
        enrichUser(user);
        return user;
    }
    
}
