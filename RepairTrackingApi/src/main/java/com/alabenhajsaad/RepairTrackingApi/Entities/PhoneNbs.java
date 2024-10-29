package com.alabenhajsaad.RepairTrackingApi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PhoneNbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;
    public String number ;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private Client client;
}
