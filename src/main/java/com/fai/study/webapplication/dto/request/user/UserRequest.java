package com.fai.study.webapplication.dto.request.user;

import com.fai.study.webapplication.dto.request.profile.ProfileRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String email;
    private String password;
    private ProfileRequest profile = new ProfileRequest("Mặc định", "https://default-avatar.com/avatar.png", "Bio mặc định");
}
