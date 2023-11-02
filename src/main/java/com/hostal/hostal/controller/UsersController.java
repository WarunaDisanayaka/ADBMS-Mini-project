package com.hostal.hostal.controller;

import com.hostal.hostal.entity.UsersEntity;
import com.hostal.hostal.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private  UsersService usersService;
    @GetMapping("/")
    public List<UsersEntity> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<UsersEntity> getUserById(@PathVariable int userId) {
        return usersService.getUserById(userId);
    }

    @PostMapping("/")
    public UsersEntity createUser(@RequestBody UsersEntity user) {
        return usersService.createUser(user);
    }
    @PutMapping("/{userId}")
    public UsersEntity updateUser(@PathVariable int userId, @RequestBody UsersEntity updatedUser) {
        // Ensure the provided userId matches the path variable
        if (updatedUser.getUserId() != userId) {
            // Handle the mismatched userId and return an appropriate response or error.
            // You may want to throw an exception or return an error message.
            return null;
        }

        return usersService.updateUser(updatedUser);
    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        usersService.deleteUser(userId);
    }
}
