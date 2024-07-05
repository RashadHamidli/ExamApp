package com.company.controller;


import com.company.dto.request.UserRequest;
import com.company.dto.response.UserResponse;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUsersById(@PathVariable("id") Long id) {
        UserResponse usersById = userService.getUserById(id);
        return ResponseEntity.ok(usersById);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable("username") String username) {
        UserResponse userByName = userService.getUserByUsername(username);
        return ResponseEntity.ok(userByName);
    }


    @PutMapping("/{username}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("username") String username, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updateUser(username, userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PatchMapping("/delete/{username}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User deleted successfully");
        return ResponseEntity.ok(response);
    }


}
