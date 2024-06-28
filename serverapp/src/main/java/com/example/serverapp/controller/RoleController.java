package com.example.serverapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverapp.models.entity.Role;
import com.example.serverapp.service.implement.RoleServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @GetMapping
    public ResponseEntity<List<Role>> getAll(){
        return ResponseEntity.ok(roleServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Integer id){
        return roleServiceImpl.getById(id);
    }

    @PostMapping
    public Role saveRole(@RequestBody Role role){
        return roleServiceImpl.create(role);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Integer id, @RequestBody Role role){
        return roleServiceImpl.update(id, role);
    }

    @DeleteMapping("/{id}")
    public Role deleteRole(@PathVariable Integer id){
        return roleServiceImpl.delete(id);
    }

}
