package com.hostal.hostal.controller;

import com.hostal.hostal.entity.RoomsEntity;
import com.hostal.hostal.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomsService roomsService;

//    endpoint for create room
    @PostMapping("/create-room")
    public RoomsEntity createRoom(@RequestBody RoomsEntity room){
        return roomsService.saveRoom(room);
    }

    //    endpoint for get all rooms list
    @GetMapping("/get-all-rooms")
    public List<RoomsEntity> getAllRooms(){
        return roomsService.getAllRooms();
    }

    //endpoint for get all room ids list
    @GetMapping("/get-all-room-ids")
    public List<String> getAllRoomIds(){
        return roomsService.getAllRoomIds();
    }

    //endpoint for get room by id
    @GetMapping("/get-room-by-id/{roomId}")
    public RoomsEntity getRoomById(@PathVariable String roomId){
        return roomsService.getRoomById(roomId);
    }

    //endpoint for update room data using id
    @PutMapping("/update-room/{roomId}")
    public RoomsEntity updateRoom(@PathVariable String roomId, @RequestBody RoomsEntity room){
        return roomsService.updateRoom(roomId, room);
    }

    @DeleteMapping("/delete-room/{roomId}")
    public void deleteRoom(@PathVariable String roomId){
        roomsService.deleteRoom(roomId);
    }
}