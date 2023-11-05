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

    //method for insert room details
    public RoomsEntity saveRoom(RoomsEntity room){
        return roomsRepository.save(room);
    }

    //method for get all room details
    public List<RoomsEntity> getAllRooms(){
        return roomsRepository.findAll();
    }

    //method for get all room ids as a list
    public List<String> getAllRoomIds(){
        List<RoomsEntity> rooms = roomsRepository.findAll();
        List<String> roomIds = new ArrayList<>();
        for(RoomsEntity room : rooms){
            roomIds.add(room.getRoomId());
        }
        return roomIds;
    }

    //method for get rooms using id
    public RoomsEntity getRoomById(String roomId){
        return roomsRepository.findById(roomId).orElse(null);
    }

    //method for update rooms using id
    public RoomsEntity updateRoom(String roomId, RoomsEntity room){
        if(roomsRepository.existsById(roomId)){
            room.setRoomId(roomId);
            return roomsRepository.save(room);
        }
        return null;
    }

    //method for delete rooms using id
    public void deleteRoom(String roomId){
        roomsRepository.deleteById(roomId);
    }
}