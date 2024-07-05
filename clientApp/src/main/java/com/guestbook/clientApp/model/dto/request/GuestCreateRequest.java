package com.guestbook.clientApp.model.dto.request;

import java.util.List;

import com.guestbook.clientApp.model.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestCreateRequest {
    private Integer id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private String keterangan;
    private String waktuKunjungan;
    private List<Event> events;
}
