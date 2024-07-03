package com.guestbook.clientApp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class home {
 
    @GetMapping
    public String getHome(Model model){
        model.addAttribute("title", "Home User");
        return "user/index";
    }
}
