package com.fai.study.webapplication.service.impl.profile;

import com.fai.study.webapplication.dto.request.profile.ProfileRequest;
import com.fai.study.webapplication.dto.response.profile.ProfileResponse;
import com.fai.study.webapplication.entities.Profile;
import com.fai.study.webapplication.mapper.ProfileMapper;
import com.fai.study.webapplication.repository.ProfileRepository;
import com.fai.study.webapplication.service.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileResponse updateProfile(UUID id, ProfileRequest request) {
        Profile profile = profileRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found"));

        profileMapper.updateProfile(profile, request);
        Profile save = profileRepository.save(profile);
        return profileMapper.toProfileResponse(save);
    }

    @Override
    public ProfileResponse getProfile(UUID id) {
        Profile profile = profileRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found")
        );

        return profileMapper.toProfileResponse(profile);
    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(profileMapper::toProfileResponse)
                .toList();
    }

    @Override
    public void deleteProfile(UUID id) {
        Profile profile = profileRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Profile not found")
        );

        profileRepository.delete(profile);
    }
}
