package com.fai.study.webapplication.mapper;

import com.fai.study.webapplication.dto.request.user.UserRequest;
import com.fai.study.webapplication.dto.request.user.UserUpdate;
import com.fai.study.webapplication.dto.response.user.UserResponse;
import com.fai.study.webapplication.entities.Profile;
import com.fai.study.webapplication.entities.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class})
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "profile", ignore = true)
    User toUser(UserRequest request);

    @Mapping(target = "id", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdate update);

    UserResponse toUserResponse(User user);

    @AfterMapping
    default void setDefaultProfile(@MappingTarget User user, UserRequest request, ProfileMapper profileMapper) {
        if (user.getProfile() == null) {
            Profile profile = profileMapper.toProfile(request.getProfile());
            profile.setUser(user);
            user.setProfile(profile);
        }
    }
}
