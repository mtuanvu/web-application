package com.fai.study.webapplication.service.user;

import com.fai.study.webapplication.dto.request.user.UserRequest;
import com.fai.study.webapplication.dto.request.user.UserUpdate;
import com.fai.study.webapplication.dto.response.user.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse updateUser(UUID id, UserUpdate update);
    UserResponse getUserById(UUID id);
    List<UserResponse> getAllUsers();
    void deleteUser(UUID id);
}
