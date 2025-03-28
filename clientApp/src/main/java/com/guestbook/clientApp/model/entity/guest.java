package com.guestbook.clientApp.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    private Integer id;
    private String nama;
    private String alamat;
    private String noTelepon;
    private String keterangan;
    private LocalDateTime waktuKunjungan;
    private List<Event> events;
}
