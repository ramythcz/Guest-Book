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

import com.example.serverapp.models.entity.Event;
import com.example.serverapp.service.implement.EventServiceImpl;

@RestController
@RequestMapping("/api/event")
public class EventController {
    
    @Autowired
    private EventServiceImpl eventServiceImpl;

    @GetMapping
    public ResponseEntity<List<Event>> findAll() {
        return ResponseEntity.ok(eventServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Integer id){
        return eventServiceImpl.getById(id);
    }

    @PostMapping
    public Event create(@RequestBody Event event){
        return eventServiceImpl.create(event);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Integer id, @RequestBody Event event){
        return eventServiceImpl.update(id, event);
    }

    @DeleteMapping("/{id}")
    public Event delete(@PathVariable Integer id){
        return eventServiceImpl.delete(id);
    }
}
