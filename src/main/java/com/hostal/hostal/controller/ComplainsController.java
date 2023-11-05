package com.hostal.hostal.controller;

import com.hostal.hostal.entity.ComplainsEntity;
import com.hostal.hostal.service.ComplainsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/complains")

public class ComplainsController {

    private final ComplainsService complainsService;

    public ComplainsController(ComplainsService complainsService) {
        this.complainsService = complainsService;
    }

    @GetMapping
    public List<ComplainsEntity> getAllComplains() {
        return complainsService.getAllComplains();
    }


    @GetMapping("/{complainId}")
    public ResponseEntity<ComplainsEntity> getComplainById(@PathVariable int complainId) {
        Optional<ComplainsEntity> complain = complainsService.getComplainById(complainId);
        return complain.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComplainsEntity createComplain(@RequestBody ComplainsEntity complain) {
        return complainsService.createComplain(complain);
    }
    @PutMapping("/{complainId}")
    public ResponseEntity<ComplainsEntity> updateComplain(@PathVariable int complainId, @RequestBody ComplainsEntity updatedComplain) {
        Optional<ComplainsEntity> complain = complainsService.updateComplain(complainId, updatedComplain);
        return complain.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{complainId}")
    public ResponseEntity<Void> deleteComplain(@PathVariable int complainId) {
        complainsService.deleteComplain(complainId);
        return ResponseEntity.noContent().build();
    }
}
