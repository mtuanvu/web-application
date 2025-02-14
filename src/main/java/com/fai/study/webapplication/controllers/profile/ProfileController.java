package com.fai.study.webapplication.controllers.profile;

import com.fai.study.webapplication.dto.request.profile.ProfileRequest;
import com.fai.study.webapplication.dto.response.api.ApiResponse;
import com.fai.study.webapplication.dto.response.profile.ProfileResponse;
import com.fai.study.webapplication.service.impl.profile.ProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileServiceImpl profileService;

    @PutMapping("/{id}")
    public ApiResponse<ProfileResponse> updateProfile(@PathVariable UUID id, @RequestBody ProfileRequest request) {
        ProfileResponse result = profileService.updateProfile(id, request);
        return ApiResponse.<ProfileResponse>builder()
                .code(200)
                .data(result)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProfileResponse>  getProfileById(@PathVariable UUID id) {
        ProfileResponse result = profileService.getProfile(id);
        return ApiResponse.<ProfileResponse>builder()
                .code(200)
                .data(result)
                .build();
    }


    @GetMapping
    public ApiResponse<List<ProfileResponse>> getAllProfiles() {
        List<ProfileResponse> allProfiles = profileService.getAllProfiles();
        return ApiResponse.<List<ProfileResponse>>builder()
                .code(200)
                .data(allProfiles)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProfile(@PathVariable UUID id) {
        profileService.deleteProfile(id);

        ApiResponse<String> response = new ApiResponse<>();
        response.setCode(200);
        response.setData("Deleted");
        return ResponseEntity.status(203).body(response);
    }
}
