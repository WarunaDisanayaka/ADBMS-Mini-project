package com.hostal.hostal.service;

import com.hostal.hostal.entity.RoomsEntity;
import com.hostal.hostal.repository.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<RoomsEntity> getAllRooms(){
        return roomsRepository.findAll();
    }

    public List<String> getAllRoomIds(){
        List<RoomsEntity> rooms = roomsRepository.findAll();
        List<String> roomIds = new ArrayList<>();
        for(RoomsEntity room : rooms){
            roomIds.add(room.getRoomId());
        }
        return roomIds;
    }
    public RoomsEntity getRoomById(String roomId){
        return roomsRepository.findById(roomId).orElse(null);
    }

    public RoomsEntity updateRoom(String roomId, RoomsEntity room){
        if(roomsRepository.existsById(roomId)){
            room.setRoomId(roomId);
            return roomsRepository.save(room);
        }
        return null;
    }

    public void deleteRoom(String roomId){
        roomsRepository.deleteById(roomId);
    }
}