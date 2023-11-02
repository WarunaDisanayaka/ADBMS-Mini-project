package com.hostal.hostal.repository;

import com.hostal.hostal.entity.RoomsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<RoomsEntity,Integer> {
}
