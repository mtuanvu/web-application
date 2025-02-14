package com.fai.study.webapplication.controllers.user;

import com.fai.study.webapplication.dto.request.user.UserRequest;
import com.fai.study.webapplication.dto.request.user.UserUpdate;
import com.fai.study.webapplication.dto.response.api.ApiResponse;
import com.fai.study.webapplication.dto.response.user.UserResponse;
import com.fai.study.webapplication.service.impl.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse result = userService.createUser(request);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .data(result)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable UUID id, @RequestBody UserUpdate update) {
        UserResponse result = userService.updateUser(id, update);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .data(result)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable UUID id) {
        UserResponse result = userService.getUserById(id);
        return ApiResponse.<UserResponse>builder()
                .code(200)
                .data(result)
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {
        List<UserResponse> allUsers = userService.getAllUsers();
        return ApiResponse.<List<UserResponse>>builder()
                .code(200)
                .data(allUsers)
                .build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);

        ApiResponse response = new ApiResponse<>();
        response.setCode(200);
        response.setData("Deleted");
        return ResponseEntity.status(203).body(response);
    }
}
