package com.alabenhajsaad.RepairTrackingApi.Controller;

import com.alabenhajsaad.RepairTrackingApi.Dto.ReparationDto;
import com.alabenhajsaad.RepairTrackingApi.Entities.RepairStatus;
import com.alabenhajsaad.RepairTrackingApi.Entities.Reparation;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceCallNumberGenerator;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceReparation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/reparation")
public class ReparationController {
    private final IServiceReparation iServiceReparation ;
    private final IServiceCallNumberGenerator iServiceCallNumberGenerator ;

    @PostMapping()
    public void AddReparation(@RequestBody ReparationDto dto){
        iServiceReparation.addReparation(dto);
    }
    @GetMapping("getNewCallNumber")
    public String getNewCallNumber(){
        return iServiceCallNumberGenerator.getGeneratedCallNumber();
    }
    @GetMapping("getFiltred")
    public Page<Reparation> getFiltredReparations(
            @RequestParam(required = false) RepairStatus ReparationStatus,
            @RequestParam(required = false) String MachineRef,
            @RequestParam(required = false) String ClientPhoneNumber ,

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return iServiceReparation.getFiltredReparations(ReparationStatus, MachineRef, ClientPhoneNumber, pageable);
    }


}
