package com.example.serverapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.serverapp.models.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    public List<Guest> findByNama (String nama);
}
