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

import com.example.serverapp.models.dto.request.GuestRequest;
import com.example.serverapp.models.dto.response.GuestEventResponse;
import com.example.serverapp.models.entity.Guest;
import com.example.serverapp.service.implement.GuestServiceImpl;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    
    @Autowired
    private GuestServiceImpl guestServiceImpl;

    @GetMapping
    public ResponseEntity<List<Guest>> findAll(){
        return ResponseEntity.ok(guestServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    public Guest findById(@PathVariable Integer id){
        return guestServiceImpl.getById(id);
    }

    @PostMapping
    public ResponseEntity<Guest> create(@RequestBody GuestRequest guestRequest){
        return ResponseEntity.ok(guestServiceImpl.createDTO(guestRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> update(@PathVariable Integer id, @RequestBody GuestRequest guestRequest){
        return ResponseEntity.ok(guestServiceImpl.updateDTO(id, guestRequest));
    }

    // @PutMapping("/{id}")
    // public Guest update(@PathVariable Integer id, @RequestBody Guest guest){
    //     return guestServiceImpl.update(id, guest);
    // }

    // @DeleteMapping("/{id}")
    // public Guest delete(@PathVariable Integer id){
    //     return guestServiceImpl.delete(id);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<GuestEventResponse> delete(@PathVariable Integer id){
        return ResponseEntity.ok(guestServiceImpl.deleteDTO(id));
    }
}
