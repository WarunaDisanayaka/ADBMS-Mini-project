package com.hostal.hostal.controller;

import com.hostal.hostal.entity.MaintainanceEntity;
import com.hostal.hostal.service.MaintainanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/maintainance")
public class MaintainanceController {

    private final MaintainanceService maintainanceService;

    @Autowired
    public MaintainanceController(MaintainanceService maintainanceService) {
        this.maintainanceService = maintainanceService;
    }

    @GetMapping
    public List<MaintainanceEntity> getAllMaintainanceEntities() {
        return maintainanceService.getAllMaintainanceEntities();
    }

    @GetMapping("/{id}")
    public Optional<MaintainanceEntity> getMaintainanceEntityById(@PathVariable int id) {
        return maintainanceService.getMaintainanceEntityById(id);
    }

    @PostMapping
    public MaintainanceEntity createMaintainanceEntity(@RequestBody MaintainanceEntity entity) {
        return maintainanceService.createMaintainanceEntity(entity);
    }

    @PutMapping
    public MaintainanceEntity updateMaintainanceEntity(@RequestBody MaintainanceEntity entity) {
        return maintainanceService.updateMaintainanceEntity(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintainanceEntity(@PathVariable int id) {
        maintainanceService.deleteMaintainanceEntity(id);
    }
}
