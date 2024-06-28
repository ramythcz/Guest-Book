package com.example.serverapp.models.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table (name = "guests")
public class Guest {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private Integer id;

    @Column(nullable = false)
    private String nama;
    
    @Column(columnDefinition = "TEXT")
    private String alamat;
    
    @Column(unique = true)
    private String noTelepon;
    
    @Column(columnDefinition = "TEXT")
    private String keterangan;

    @Column (nullable = false)
    private LocalDateTime waktuKunjungan;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "guest_event",
        joinColumns = @JoinColumn (name = "guest_id", referencedColumnName = "guest_id", nullable = false),
        inverseJoinColumns = @JoinColumn (name = "event_id", referencedColumnName = "event_id", nullable = false)
    )
    private List<Event> events;
}
