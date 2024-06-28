package com.example.serverapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.serverapp.models.entity.Admin;
import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin findByUsername(String username);
}
