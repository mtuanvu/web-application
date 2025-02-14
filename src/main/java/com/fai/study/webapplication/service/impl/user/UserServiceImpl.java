package com.fai.study.webapplication.service.impl.user;

import com.fai.study.webapplication.dto.request.user.UserRequest;
import com.fai.study.webapplication.dto.request.user.UserUpdate;
import com.fai.study.webapplication.dto.response.user.UserResponse;
import com.fai.study.webapplication.entities.Profile;
import com.fai.study.webapplication.entities.User;
import com.fai.study.webapplication.mapper.ProfileMapper;
import com.fai.study.webapplication.mapper.UserMapper;
import com.fai.study.webapplication.repository.UserRepository;
import com.fai.study.webapplication.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toUser(request);

        if (user.getProfile() == null) {
            Profile profile = new Profile("Mặc định", "https://default-avatar.com/avatar.png", "Bio mặc định", user);
            user.setProfile(profile);
        }

        User savedUser = userRepository.saveAndFlush(user);
        return userMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(UUID id, UserUpdate update) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));

        userMapper.updateUser(user, update);
        User save = userRepository.save(user);
        return userMapper.toUserResponse(save);
    }

    @Override
    public UserResponse getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));

        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().
                map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public void deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}
