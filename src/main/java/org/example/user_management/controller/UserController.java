package org.example.user_management.controller;

import org.example.user_management.dto.UserResponseDto;
import org.example.user_management.dto.UserResponseWithDetailsDto;
import org.example.user_management.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user-management/user")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping(value="/user-details/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseWithDetailsDto> getUserDetails(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserWithDetails(userId));
    }
}
