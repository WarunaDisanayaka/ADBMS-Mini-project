package com.hostal.hostal.controller;

import com.hostal.hostal.request.LoginRequest;
import com.hostal.hostal.response.LoginResponse;
import com.hostal.hostal.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/login")
public class LoginController {

    private final UsersService usersService;

    @Autowired
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/user")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = usersService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        String userRole = null;
        Long userId = null;


        if (isAuthenticated) {
            userRole = String.valueOf(usersService.getUserRole(loginRequest.getUsername()));
            userId = Long.valueOf(usersService.getUserIdByUsername(loginRequest.getUsername())); // Use the appropriate method to get the user's ID

        }

        return new LoginResponse(isAuthenticated, userRole, userId);
    }
}
