package com.company.controller.mvc;

import com.company.dto.request.UserRequest;
import com.company.dto.response.UserResponse;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserResponse> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping("/add-user")
    public String addUserForm(Model model) {
        model.addAttribute("userRequest", new UserRequest(null, null, null, null));
        return "add-user";
    }

    @PostMapping
    public String addUser(@ModelAttribute UserRequest userRequest) {
        userService.saveUser(userRequest);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUsersById(@PathVariable("id") String id) {
        UserResponse usersById = userService.getUserById(id);
        return ResponseEntity.ok(usersById);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable("username") String username) {
        UserResponse userByName = userService.getUserByUsername(username);
        return ResponseEntity.ok(userByName);
    }

    @GetMapping("/update-user/{username}")
    public String updateUserForm(@PathVariable("username") String username, Model model) {
        UserResponse userResponse = userService.getUserByUsername(username);
        model.addAttribute("userRequest", new UserRequest(userResponse.username(), userResponse.name(), userResponse.surname(), userResponse.email()));
        return "update-user";
    }

    @PostMapping("/{username}")
    public String updateUser(@PathVariable("username") String username, @ModelAttribute UserRequest userRequest) {
        userService.updateUser(username, userRequest);
        return "redirect:/users";
    }

    @GetMapping("/delete-user/{username}")
    public String deleteUserForm(@PathVariable("username") String username, Model model) {
        model.addAttribute("username", username);
        return "delete-user";
    }

    @PostMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return "redirect:/users";
    }
}
