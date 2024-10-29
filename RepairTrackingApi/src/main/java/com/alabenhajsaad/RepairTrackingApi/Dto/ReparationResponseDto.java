package com.alabenhajsaad.RepairTrackingApi.Dto;

import com.alabenhajsaad.RepairTrackingApi.Entities.RepairStatus;

import java.time.LocalDate;

public record ReparationResponseDto(int id ,
                                    String callNumber ,
                                    String description ,
                                    LocalDate entryDate ,
                                    LocalDate releaseDate ,
                                    RepairStatus status ,
                                    int machine_id) {
}
