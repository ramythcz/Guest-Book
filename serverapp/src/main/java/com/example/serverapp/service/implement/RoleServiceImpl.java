package com.example.serverapp.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.serverapp.models.entity.Role;
import com.example.serverapp.repository.RoleRepository;
import com.example.serverapp.service.GenericService;

@Service
public class RoleServiceImpl implements GenericService <Role, Integer> {
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role tidak ditemukan"));
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Integer id, Role role) {
        getById(id);
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public Role delete(Integer id) {
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }

}
