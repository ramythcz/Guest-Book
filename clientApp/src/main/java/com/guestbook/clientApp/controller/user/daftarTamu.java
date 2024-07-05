package com.guestbook.clientApp.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guestbook.clientApp.services.EventService;
import com.guestbook.clientApp.services.GuestSerivce;

@Controller
@RequestMapping("/daftartamu")
public class daftarTamu {

    @Autowired
    private GuestSerivce guestSerivce;

    
    @GetMapping
    public String getDaftartamu(Model model){
        model.addAttribute("title", "Daftar Tamu");
        model.addAttribute("guests", guestSerivce.getAll());
        return "/user/daftarTamu";
    }
}
