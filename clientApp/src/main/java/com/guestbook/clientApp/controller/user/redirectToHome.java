package com.guestbook.clientApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class redirectToHome {
    
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("title", "Home User");
        return "user/index";
    }
    
}
