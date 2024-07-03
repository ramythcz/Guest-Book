package com.guestbook.clientApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pendaftaran")
public class registGuest {
    
    @GetMapping
    public String getPendaftaran(Model model){
        model.addAttribute("title", "pendaftaran user");
        return "user/formGuest";
    }
}
