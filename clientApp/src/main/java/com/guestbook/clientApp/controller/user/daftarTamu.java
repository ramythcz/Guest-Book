package com.guestbook.clientApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/daftartamu")
public class daftarTamu {
    
    @GetMapping
    public String getDaftartamu(Model model){
        model.addAttribute("title", "Daftar Tamu");
        return "/user/daftarTamu";
    }
}
