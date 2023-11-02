package com.hostal.hostal.controller;

import com.hostal.hostal.request.LoginRequest;
import com.hostal.hostal.response.LoginResponse;
import com.hostal.hostal.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UsersService usersService;

    @Autowired
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = usersService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        String userRole = null;

        if (isAuthenticated) {
            userRole = String.valueOf(usersService.getUserRole(loginRequest.getUsername()));
        }

        return new LoginResponse(isAuthenticated, userRole);
    }
}
