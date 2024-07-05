package com.guestbook.clientApp.controller.user;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guestbook.clientApp.model.dto.request.GuestCreateRequest;
import com.guestbook.clientApp.model.dto.request.GuestRequest;
import com.guestbook.clientApp.model.entity.Event;
import com.guestbook.clientApp.model.entity.Guest;
import com.guestbook.clientApp.services.EventService;
import com.guestbook.clientApp.services.GuestSerivce;

@Controller
@RequestMapping("/pendaftaran")
public class registGuest {
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private GuestSerivce guestSerivce;

    @GetMapping
    public String getPendaftaran(Model model){
        model.addAttribute("title", "pendaftaran user");
        model.addAttribute("guestCreateRequest", new GuestCreateRequest());
        model.addAttribute("events", eventService.getAll());
        return "user/formGuest";
    }

    

    @PostMapping
    public String create(Model model, @ModelAttribute("guestCreateRequest") GuestCreateRequest guestCreateRequest,
                         @RequestParam(name = "eventList") Set<Integer> eventList, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes ){
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("title", "pendaftaran user");
                model.addAttribute("guestCreateRequest", new GuestCreateRequest());
                model.addAttribute("events", eventService.getAll());
                return "user/formGuest";
            }

            GuestRequest guestRequest = convertToGuestRequest(guestCreateRequest, eventList);
            guestSerivce.createDTO(guestRequest);
            redirectAttributes.addFlashAttribute("success", "Tamu baru saja ditambahkan");
            return "redirect:/daftartamu";
        } catch (Exception e) {
           model.addAttribute("errors", "Something wrong");
           
        }
        return "redirect:/user/formGuest";
    }

    // @PostMapping
    // public String create(Guest guest){
    //     guestSerivce.create(guest);
    //     return "redirect/user/daftarTamu";
    // }

    
    // private GuestCreateRequest convertToGuestCreateRequest(Guest guest){
    //     GuestCreateRequest guestCreateRequest = new GuestCreateRequest();
    //     guestCreateRequest.setId(guest.getId());
    //     guestCreateRequest.setNama(guest.getNama());
    //     guestCreateRequest.setAlamat(guest.getAlamat());
    //     guestCreateRequest.setNoTelepon(guest.getNoTelepon());
    //     guestCreateRequest.setKeterangan(guest.getKeterangan());
    //     guestCreateRequest.setWaktuKunjungan(guest.getWaktuKunjungan().toString());
    //     guestCreateRequest.setEvents(guest.getEvents());
    //     return guestCreateRequest;
    // }

    private GuestRequest convertToGuestRequest(GuestCreateRequest guestCreateRequest, Set<Integer> eventList ){
        GuestRequest guestRequest = new GuestRequest();
        guestRequest.setNama(guestCreateRequest.getNama());
        guestRequest.setAlamat(guestCreateRequest.getAlamat());
        guestRequest.setKeterangan(guestCreateRequest.getKeterangan());
        guestRequest.setNoTelepon(guestCreateRequest.getNoTelepon());
        guestRequest.setWaktuKunjungan(guestCreateRequest.getWaktuKunjungan());
        guestRequest.setEventsId(new ArrayList<>(eventList));
        return guestRequest;
    }

}
