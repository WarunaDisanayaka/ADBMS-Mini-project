package com.hostal.hostal.service;

import com.hostal.hostal.entity.MaintainanceEntity;
import com.hostal.hostal.repository.MaintainanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MaintainanceService {

    private final MaintainanceRepository maintainanceRepository;

    @Autowired
    public MaintainanceService(MaintainanceRepository maintainanceRepository) {
        this.maintainanceRepository = maintainanceRepository;
    }

    public List<MaintainanceEntity> getAllMaintainanceEntities() {
        return maintainanceRepository.findAll();
    }

    public Optional<MaintainanceEntity> getMaintainanceEntityById(int id) {
        return maintainanceRepository.findById(id);
    }

    public MaintainanceEntity createMaintainanceEntity(MaintainanceEntity entity) {
        return maintainanceRepository.save(entity);
    }

    public MaintainanceEntity updateMaintainanceEntity(MaintainanceEntity entity) {
        return maintainanceRepository.save(entity);
    }

    public void deleteMaintainanceEntity(int id) {
        maintainanceRepository.deleteById(id);
    }
}
