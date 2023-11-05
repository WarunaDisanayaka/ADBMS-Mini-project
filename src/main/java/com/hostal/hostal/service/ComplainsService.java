package com.hostal.hostal.service;

import com.hostal.hostal.entity.ComplainsEntity;
import com.hostal.hostal.repository.ComplainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ComplainsService {

    private final ComplainsRepository complainsRepository;

    @Autowired
    public ComplainsService(ComplainsRepository complainsRepository) {
        this.complainsRepository = complainsRepository;
    }

    public List<ComplainsEntity> getAllComplains() {
        return complainsRepository.findAll();
    }

    public Optional<ComplainsEntity> getComplainById(int complainId) {
        return complainsRepository.findById(complainId);
    }

    public ComplainsEntity createComplain(ComplainsEntity complain) {
        return complainsRepository.save(complain);
    }

    public Optional<ComplainsEntity> updateComplain(int complainId, ComplainsEntity updatedComplain) {
        if (!complainsRepository.existsById(complainId)) {
            return Optional.empty();
        }
        updatedComplain.setComplainId(complainId);
        return Optional.of(complainsRepository.save(updatedComplain));
    }

    public void deleteComplain(int complainId) {
        complainsRepository.deleteById(complainId);
    }
}
