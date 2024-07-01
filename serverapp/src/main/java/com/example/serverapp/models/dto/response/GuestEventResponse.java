package com.example.serverapp.models.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuestEventResponse {
    private String nama;
    private String alamat;
    private String noTelepon;
    private String keterangan;
    private String waktuKunjungan;
}
