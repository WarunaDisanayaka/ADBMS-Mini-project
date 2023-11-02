package com.hostal.hostal.controller;

import com.hostal.hostal.entity.RolesEntity;
import com.hostal.hostal.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;


    @GetMapping("/get-roles")
    public List<RolesEntity> getAllRoles(){
        return rolesService.getAllRoles();
    }

    @PostMapping ("/create-role")
    public RolesEntity createRole(@RequestBody RolesEntity role){
        return rolesService.saveRole(role);
    }

    @GetMapping("/{roleId}")
    public RolesEntity getRoleById(@PathVariable int roleId){
        return rolesService.getRoleById(roleId);
    }

    @PutMapping("/{roleId}")
    public RolesEntity updateRole(@PathVariable int roleId,@RequestBody RolesEntity role){
        role.setRoleId(roleId);
        return rolesService.saveRole(role);
    }

    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable int roleId){
        rolesService.deleteRole(roleId);
    }
}
