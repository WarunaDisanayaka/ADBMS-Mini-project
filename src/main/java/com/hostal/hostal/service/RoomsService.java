package com.hostal.hostal.service;

import com.hostal.hostal.entity.RoomsEntity;
import com.hostal.hostal.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService{


    private final RoomsRepository roomsRepository;

    @Autowired
    public RoomsService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public RoomsEntity saveRoom(RoomsEntity room){
        return roomsRepository.save(room);
    }
}