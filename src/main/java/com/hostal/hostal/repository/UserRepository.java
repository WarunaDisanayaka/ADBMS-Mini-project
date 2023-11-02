package com.hostal.hostal.repository;

import com.hostal.hostal.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersEntity,Integer> {
}
