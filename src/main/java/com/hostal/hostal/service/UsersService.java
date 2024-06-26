package com.hostal.hostal.service;

import com.hostal.hostal.entity.UsersEntity;
import com.hostal.hostal.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public UsersEntity updateUser(UsersEntity user) {

        Optional<UsersEntity> existingUser = userRepository.findById(user.getUserId());

        if (existingUser.isPresent()){
            UsersEntity usersEntity = existingUser.get();

            usersEntity.setFullName(user.getFullName());
            usersEntity.setPassword(user.getPassword());
            usersEntity.setUsername(user.getUsername());
            usersEntity.setRegNo(user.getRegNo());

            if (usersEntity.getPassword() !=null){
                String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
                usersEntity.setPassword(hashedPassword);
            }

            return userRepository.save(usersEntity);


        }

        return  null;
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }


    public boolean authenticateUser(String username, String password) {
        Optional<UsersEntity> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            UsersEntity usersEntity = user.get();
            // Check if the provided password matches the stored hashed password
            if (BCrypt.checkpw(password, usersEntity.getPassword())) {
                return true; // Authentication successful
            }
        }

        return false; // Authentication failed
    }

    public Integer getUserRole(String username) {
        Optional<UsersEntity> user = userRepository.findByUsername(username);
        return user.map(UsersEntity::getRoleId).orElse(null);
    }

    public Integer getUserIdByUsername(String username) {
        Optional<UsersEntity> user = userRepository.findByUsername(username);
        return user.map(UsersEntity::getUserId).orElse(null);
    }


}
