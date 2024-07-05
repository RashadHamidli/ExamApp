package com.company.service;

import com.company.dto.request.UserRequest;
import com.company.dto.response.UserResponse;
import com.company.entity.User;
import com.company.exception.CustomException;
import com.company.exception.UserNotFoundException;
import com.company.exception.ValidationException;
import com.company.mapper.UserMapper;
import com.company.repository.UserRepository;
import com.company.util.LoggerUtil;
import com.company.util.UserServiceUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<UserResponse> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                throw new UserNotFoundException("no users found");
            }
            LoggerUtil.getLoggerInfo(logger, "Found users: {}", users);
            return users.stream().map(UserMapper.INSTANCE::convertUserToUserResponse).toList();
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public UserResponse getUserById(Long id) {
        try {
            User user = findById(id);
            LoggerUtil.getLoggerInfo(logger, "found user", user);
            return UserMapper.INSTANCE.convertUserToUserResponse(user);
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public UserResponse getUserByUsername(String username) {
        try {
            User user = getActiveUserByUsername(username);
            LoggerUtil.getLoggerInfo(logger, "found user", user);
            return UserMapper.INSTANCE.convertUserToUserResponse(user);
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    public UserResponse saveUser(UserRequest userRequest) {
        try {
            if (userRepository.existsByUsernameOrEmail(userRequest.username(), userRequest.email())) {
                throw new ValidationException("Username Or Email already exists");
            }
            User user = UserMapper.INSTANCE.convertUserRequestToUser(userRequest);
            userRepository.save(user);
            LoggerUtil.getLoggerInfo(logger, "saved user: {}", user);
            return UserMapper.INSTANCE.convertUserToUserResponse(user);
        } catch (ConstraintViolationException | UserNotFoundException | ValidationException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    public UserResponse updateUser(String username, UserRequest userRequestDTO) {
        try {
            User userRequest = UserMapper.INSTANCE.convertUserRequestToUser(userRequestDTO);
            User existingUser = getActiveUserByUsername(username);
            User updatedUser = UserServiceUtil.updateUser(existingUser, userRequest);
            userRepository.saveAndFlush(updatedUser);
            LoggerUtil.getLoggerInfo(logger, "User updated successfully", updatedUser);
            return UserMapper.INSTANCE.convertUserToUserResponse(updatedUser);
        } catch (ConstraintViolationException | ValidationException | UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public void deleteUser(String username) {
        try {
            User user = getActiveUserByUsername(username);
            user.setStatus("inActive");
            userRepository.saveAndFlush(user);
            LoggerUtil.getLoggerInfo(logger, "User deleted successfully");
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
    }

    protected User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(STR."user '\{username}' not found"));
    }

    protected User getActiveUserByUsername(String username) {
        return userRepository.findByUsernameAndStatus(username, "ACTIVE")
                .orElseThrow(() -> new UserNotFoundException(STR."user '\{username}' not found"));
    }

    protected User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(STR."user id '\{id}' not found"));
    }

}
