package com.hostal.hostal.service;

import com.hostal.hostal.entity.UsersEntity;
import com.hostal.hostal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UsersEntity> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public UsersEntity createUser(UsersEntity user) {
        return userRepository.save(user);
    }

    public UsersEntity updateUser(UsersEntity user) {
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}
