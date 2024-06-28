package com.example.serverapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.serverapp.models.entity.Event;

@Repository
public interface EventRepository extends JpaRepository <Event, Integer> {
    public List<Event> findByNama (String nama);
}
