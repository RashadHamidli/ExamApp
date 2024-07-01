package com.company.service;

import com.company.dto.request.UserRequestDTO;
import com.company.dto.response.UserResponseDTO;
import com.company.entity.User;
import com.company.exception.CustomException;
import com.company.exception.UserNotFoundException;
import com.company.exception.ValidationException;
import com.company.repository.UserRepository;
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

    public List<UserResponseDTO> getAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                throw new UserNotFoundException("no users found");
            }
            logger.info("Found users: {}", users);
            return users.stream().map(UserResponseDTO::fromUser).toList();
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public UserResponseDTO getUserById(Long id) {
        try {
            User user = findById(id);
            getLoggerInfo("found user", user);
            return UserResponseDTO.fromUser(user);
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public UserResponseDTO getUserByUsername(String username) {
        try {
            User user = getActiveUserByUsername(username);
            getLoggerInfo("found user", user);
            return UserResponseDTO.fromUser(user);
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        try {
            if (userRepository.existsByUsernameOrEmail(userRequestDTO.username(), userRequestDTO.email())) {
                throw new ValidationException("Username Or Email already exists");
            }
            User user = UserRequestDTO.toUser(userRequestDTO);
            userRepository.save(user);
            getLoggerInfo("User saved successfully", user);
            return UserResponseDTO.fromUser(user);
        } catch (ConstraintViolationException | UserNotFoundException | ValidationException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    public UserResponseDTO updateUser(String username, UserRequestDTO userRequestDTO) {
        try {
            User userRequest = UserRequestDTO.toUser(userRequestDTO);
            User existingUser = getActiveUserByUsername(username);
            User updatedUser = UserServiceUtil.updateUser(existingUser, userRequest);
            userRepository.saveAndFlush(updatedUser);
            getLoggerInfo("User update successfully ", updatedUser);
            return UserResponseDTO.fromUser(updatedUser);
        } catch (ConstraintViolationException |ValidationException | UserNotFoundException e) {
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
            getLoggerInfo("User delete successfully: ");
        } catch (UserNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
    }

    private User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(STR."user '\{username}' not found"));
    }

    private User getActiveUserByUsername(String username) {
        return userRepository.findByUsernameAndStatus(username, "ACTIVE")
                .orElseThrow(() -> new UserNotFoundException(STR."user '\{username}' not found"));
    }

    private User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(STR."user id '\{id}' not found"));
    }

    private void getLoggerInfo(String msg, User user) {
        logger.info(STR."\u001B[32m\{msg}{}\u001B[0m", user);
    }

    private void getLoggerInfo(String msg) {
        logger.info(STR."\u001B[33m\{msg}{}\u001B[0m");
    }
}
