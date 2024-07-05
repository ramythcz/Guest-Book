package com.guestbook.clientApp.model.dto.rseponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestCreateResponse {
    private String nama;
    private String alamat;
    private String noTelepon;
    private String keterangan;
    private String waktuKunjungan;
}
