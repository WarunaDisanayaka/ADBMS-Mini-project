package com.hostal.hostal.controller;

import com.hostal.hostal.request.LoginRequest;
import com.hostal.hostal.response.LoginResponse;
import com.hostal.hostal.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;


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


            // Convert the long value to a Timestamp
            Timestamp loginTimestamp = new Timestamp(System.currentTimeMillis());


            // Call the stored procedure
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://hostal.cut49epaxhw7.us-east-1.rds.amazonaws.com:3306/hostal", "admin", "waruna99")) {
                CallableStatement callableStatement = connection.prepareCall("{call LogUserLogin(?, ?)}");
                callableStatement.setString(1, loginRequest.getUsername());
                callableStatement.setTimestamp(2, loginTimestamp);
                callableStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
                // Handle any exceptions that might occur during database interaction
            }

        }

        return new LoginResponse(isAuthenticated, userRole, userId);
    }
}
