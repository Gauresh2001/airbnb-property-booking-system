package com.airbnb.controller;


import com.airbnb.dto.UserRequest;
import com.airbnb.entity.User;
import com.airbnb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User registerUser(@Valid @RequestBody UserRequest request) {
        return userService.registerUser(request);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
