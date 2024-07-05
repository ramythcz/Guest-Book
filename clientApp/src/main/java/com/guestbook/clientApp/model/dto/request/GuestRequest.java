package com.guestbook.clientApp.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestRequest {
    private String nama;
    private String alamat;
    private String noTelepon;
    private String keterangan;
    private String waktuKunjungan;
    private List<Integer> eventsId;
}
