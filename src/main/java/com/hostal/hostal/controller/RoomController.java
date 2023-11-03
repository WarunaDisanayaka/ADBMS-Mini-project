package com.hostal.hostal.controller;

import com.hostal.hostal.entity.RoomsEntity;
import com.hostal.hostal.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomsService roomsService;

    @PostMapping("/create-room")
    public RoomsEntity createRoom(@RequestBody RoomsEntity room){
        return roomsService.saveRoom(room);
    }
    @GetMapping("/get-room")
    public String getRoom(){
        return "room is working";
    }
}