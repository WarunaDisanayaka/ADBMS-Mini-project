package com.hostal.hostal.repository;

import com.hostal.hostal.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
    Optional<UsersEntity> findByUsername(String username);

}
