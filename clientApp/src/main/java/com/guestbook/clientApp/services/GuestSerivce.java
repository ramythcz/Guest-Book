package com.guestbook.clientApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.guestbook.clientApp.model.dto.request.GuestRequest;
import com.guestbook.clientApp.model.entity.Event;
import com.guestbook.clientApp.model.entity.Guest;

@Service
public class GuestSerivce {
    
    @Value("${server.base.url}/api/guest")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<Guest> getAll(){
        return restTemplate
                .exchange(
                    url, 
                    HttpMethod.GET, 
                    null, 
                    new ParameterizedTypeReference<List<Guest>>() {}
                    ).getBody();
    }

    public Guest getById (Integer id){
        return restTemplate
                .exchange(
                    url.concat("/" + id), 
                    HttpMethod.GET, 
                    null, 
                    Guest.class
                    ).getBody();
    }

    public GuestRequest createDTO(GuestRequest guestRequest){
        HttpEntity<GuestRequest> httpEntity = new HttpEntity<GuestRequest>(guestRequest);
        return restTemplate
                .exchange(
                    url, 
                    HttpMethod.POST, 
                    httpEntity,
                    GuestRequest.class
                    ).getBody();
    }

    public Guest create(Guest guest){
        return restTemplate
                .exchange(
                    url, 
                    HttpMethod.POST, 
                    new HttpEntity<>(guest), 
                    Guest.class
                    ).getBody();
    }


    public Guest update(Integer id, Guest guest){
        HttpEntity<Guest> httpEntity = new HttpEntity<Guest>(guest);
        return restTemplate
                .exchange(
                    url.concat("/" + id), 
                    HttpMethod.PUT, 
                    httpEntity, 
                    Guest.class
                    ).getBody();
    }

    public Guest delete (Integer id){
         return restTemplate
                .exchange(
                    url.concat("/" + id), 
                    HttpMethod.DELETE, 
                    null, 
                    Guest.class
                    ).getBody();
    }

}
