package com.company.util;

import com.company.entity.User;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserServiceUtil {

    public static User updateUser(User foundUser, User userRequest) {
            Optional.ofNullable(userRequest.getUsername()).ifPresent(foundUser::setUsername);
            Optional.ofNullable(userRequest.getName()).ifPresent(foundUser::setName);
            Optional.ofNullable(userRequest.getSurname()).ifPresent(foundUser::setSurname);
            Optional.ofNullable(userRequest.getEmail()).ifPresent(foundUser::setEmail);
            return foundUser;
    }
}
