package com.hostal.hostal.service;

import com.hostal.hostal.entity.RolesEntity;
import com.hostal.hostal.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;


    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<RolesEntity> getAllRoles() {
        return rolesRepository.findAll();
    }

    public RolesEntity getRoleById(int roleId) {
        return rolesRepository.findById(roleId).orElse(null);
    }

    public RolesEntity saveRole(RolesEntity role) {
        return rolesRepository.save(role);
    }

    public void deleteRole(int roleId) {
        rolesRepository.deleteById(roleId);
    }
}
