package com.alabenhajsaad.RepairTrackingApi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Reparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;
    public String callNumber ;
    private String description ;
    public LocalDate entryDate ;
    public LocalDate releaseDate ;

    @Enumerated(EnumType.STRING)
    private RepairStatus status ;


    @ManyToOne
    public Machine machine ;
}
