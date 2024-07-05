package com.guestbook.clientApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.guestbook.clientApp.model.dto.request.EventRequest;
import com.guestbook.clientApp.model.entity.Event;

@Service
public class EventService {
    @Value("${server.base.url}/api/event")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<Event> getAll(){
        return restTemplate
                .exchange(
                    url, 
                    HttpMethod.GET, 
                    null, 
                    new ParameterizedTypeReference<List<Event>>() {}
                    ).getBody();
    }

    public Event getById (Integer id){
        return restTemplate
                .exchange(
                    url.concat("/" + id), 
                    HttpMethod.GET, 
                    null, 
                    Event.class
                    ).getBody();
    }

    public Event create(EventRequest eventRequest){
        return restTemplate
                .exchange(
                    url, 
                    HttpMethod.POST, 
                    new HttpEntity<>(eventRequest), 
                    Event.class
                    ).getBody();
    }

     public Event update(Integer id, Event event){
        HttpEntity<Event> httpEntity = new HttpEntity<Event>(event);
        return restTemplate
                .exchange(
                    url.concat("/" + id), 
                    HttpMethod.PUT, 
                    httpEntity, 
                    Event.class
                    ).getBody();
     }

     public Event delete(Integer id){
        return restTemplate
                .exchange(
                    url.concat("/" + id), 
                    HttpMethod.DELETE, 
                    null, 
                    Event.class
                    ).getBody();
     }

}
