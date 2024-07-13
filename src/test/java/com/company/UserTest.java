package com.company;


import com.company.controller.UserController;
import com.company.dto.response.UserResponse;
import com.company.exception.UserNotFoundException;
import com.company.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {


    @Test
    public void test_retrieve_user_by_username_successfully() {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        String username = "testuser";
        UserResponse expectedResponse = new UserResponse("1", username, "Test", "User", "testuser@example.com");

        when(userService.getUserByUsername(username)).thenReturn(expectedResponse);

        ResponseEntity<UserResponse> response = userController.getUserByUsername(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    // Username does not exist in the database
    @Test
    public void test_username_does_not_exist_in_database() {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        String username = "nonexistentuser";

        when(userService.getUserByUsername(username)).thenThrow(new UserNotFoundException("User not found"));

        assertThrows(UserNotFoundException.class, () -> {
            userController.getUserByUsername(username);
        });
    }

}