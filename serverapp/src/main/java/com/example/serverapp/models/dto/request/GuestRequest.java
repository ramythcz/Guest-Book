package com.example.serverapp.models.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuestRequest {
    private String nama;
    private String alamat;
    private String noTelepon;
    private String keterangan;
    private String waktuKunjungan;
    private List<Integer> eventsId;
}
