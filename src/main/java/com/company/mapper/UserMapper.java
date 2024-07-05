package com.company.mapper;

import com.company.dto.request.UserRequest;
import com.company.dto.response.UserResponse;
import com.company.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);

    UserRequest convertUserToUserRequest(User user);
    User convertUserRequestToUser(UserRequest userRequest);
    UserResponse convertUserToUserResponse(User user);
    User convertUserResponseToUser(UserResponse userResponse);
}
