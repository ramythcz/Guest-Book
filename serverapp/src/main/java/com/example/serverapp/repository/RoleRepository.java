package com.example.serverapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.serverapp.models.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer> {}
