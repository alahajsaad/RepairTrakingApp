package com.alabenhajsaad.RepairTrackingApi.Services.IServices;

import com.alabenhajsaad.RepairTrackingApi.Dto.ReparationDto;
import com.alabenhajsaad.RepairTrackingApi.Entities.RepairStatus;
import com.alabenhajsaad.RepairTrackingApi.Entities.Reparation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceReparation {
    void addReparation(ReparationDto dto) ;
    Reparation getReparationByCallNumber(String callNumber) ;
    void updateReparationStatus(Reparation reparation);
    Page<Reparation> getFiltredReparations(RepairStatus reparationStatus, String machineRef, String clientPhoneNumber, Pageable pageable);

}
