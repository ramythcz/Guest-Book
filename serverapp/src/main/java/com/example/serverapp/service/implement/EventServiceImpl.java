package com.example.serverapp.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.serverapp.models.entity.Event;
import com.example.serverapp.repository.EventRepository;
import com.example.serverapp.service.GenericService;

@Service
public class EventServiceImpl implements GenericService<Event, Integer> {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event getById(Integer id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event tidak ditemukan"));
    }

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Integer id, Event event) {
        getById(id);
        event.setId(id);
        return eventRepository.save(event);
    }

    @Override
    public Event delete(Integer id) {
        Event event = getById(id);
        eventRepository.delete(event);
        return event;
    }

}
