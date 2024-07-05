package com.company.dto.request;

import com.company.entity.User;

public record UserRequest(String username,
                          String name,
                          String surname,
                          String email) {

    public static User toUser(UserRequest userRequest) {
        return User.builder().username(userRequest.username()).
                name(userRequest.name()).
                surname(userRequest.surname()).
                email(userRequest.email()).build();
    }
}
