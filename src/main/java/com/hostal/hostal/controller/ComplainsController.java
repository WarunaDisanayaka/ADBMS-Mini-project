package com.hostal.hostal.controller;

import com.hostal.hostal.entity.ComplainsEntity;
import com.hostal.hostal.service.ComplainsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Optional<ComplainsEntity>> updateComplainStatus(
            @PathVariable int complainId,
            @RequestBody Map<String, String> request) {
        Optional<ComplainsEntity> existingComplain = complainsService.getComplainById(complainId);

        if (existingComplain.isPresent()) {
            ComplainsEntity complain = existingComplain.get();
            String newStatus = request.get("status");

            if (newStatus != null) {
                // Update the "status" field
                complain.setStatus(newStatus);

                // Save the updated complain
                Optional<ComplainsEntity> updatedComplain = complainsService.updateComplain(complainId, complain);

                return ResponseEntity.ok(updatedComplain);
            } else {
                return ResponseEntity.badRequest().build(); // Return a bad request if "status" is not provided in the request
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{complainId}")
    public ResponseEntity<Void> deleteComplain(@PathVariable int complainId) {
        complainsService.deleteComplain(complainId);
        return ResponseEntity.noContent().build();
    }
}
