package com.example.serverapp.service.implement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.serverapp.models.dto.request.GuestRequest;
import com.example.serverapp.models.entity.Event;
import com.example.serverapp.models.entity.Guest;
import com.example.serverapp.repository.EventRepository;
import com.example.serverapp.repository.GuestRepository;
import com.example.serverapp.service.GenericService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GenericService<Guest, Integer> {
    
    private GuestRepository guestRepository;
    private ModelMapper modelMapper;
    private EventRepository eventRepository;

    @Override
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getById(Integer id) {
        return guestRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengunjung tidak ditemukan"));
    }

    @Override
    public Guest create(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest update(Integer id, Guest guest) {
        getById(id);
        guest.setId(id);
        return guestRepository.save(guest);
    }

    @Override
    public Guest delete(Integer id) {
        Guest guest = getById(id);
        guestRepository.delete(guest);
        return guest;
    }

    public Guest create(GuestRequest guestRequest) {
        Guest guest = modelMapper.map(guestRequest, Guest.class);
        LocalDateTime waktuKunjungan = LocalDateTime.parse(guestRequest.getWaktuKunjungan());
        guest.setWaktuKunjungan(waktuKunjungan);
        guest.setEvents(getEventFromRequest(guestRequest.getEventsId()));
        return guestRepository.save(guest);
        
    }

    private List<Event> getEventFromRequest(List<Integer> eventsId){
        List<Event> events = new ArrayList<>();
        for(Integer eventId : eventsId){
           Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "event id not found"));
           events.add(event);
        }
        return events;
   }
    

}
