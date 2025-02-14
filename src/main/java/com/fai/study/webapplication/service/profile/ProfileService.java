package com.fai.study.webapplication.service.profile;

import com.fai.study.webapplication.dto.request.profile.ProfileRequest;
import com.fai.study.webapplication.dto.response.profile.ProfileResponse;

import java.util.List;
import java.util.UUID;

public interface ProfileService {
    ProfileResponse updateProfile(UUID id, ProfileRequest request);
    ProfileResponse getProfile(UUID id);
    List<ProfileResponse> getAllProfiles();
    void deleteProfile(UUID id);
}
