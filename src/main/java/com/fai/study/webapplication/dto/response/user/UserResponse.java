package com.fai.study.webapplication.dto.response.user;

import com.fai.study.webapplication.dto.response.profile.ProfileResponse;
import com.fai.study.webapplication.entities.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String email;
    private ProfileResponse profile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
