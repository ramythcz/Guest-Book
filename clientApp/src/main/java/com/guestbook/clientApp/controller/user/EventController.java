package com.guestbook.clientApp.controller.user;

import org.springframework.stereotype.Controller;

import com.guestbook.clientApp.services.EventService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class EventController {
    private EventService eventService;



}
