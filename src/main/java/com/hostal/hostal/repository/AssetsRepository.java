package com.hostal.hostal.repository;

import com.hostal.hostal.entity.AssetsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssetsRepository extends JpaRepository<AssetsEntity, String> {
}
