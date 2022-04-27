package com.example.application.service;

import java.util.List;

import com.example.application.dto.request.UserRequest;
import com.example.domain.User;

public interface UserService {
    List<User> getListUser();

    List<User> searchUserByGenderAndName(String gender, String name);

    User getUserByID(String id);

    User getUserByUsername(String username);

    User addUser(UserRequest userRequest);

    User updateUser(UserRequest userRequest, String userID);

    void removeUser(String id);
}
