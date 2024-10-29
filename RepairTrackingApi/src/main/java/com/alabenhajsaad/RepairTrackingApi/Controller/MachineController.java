package com.alabenhajsaad.RepairTrackingApi.Controller;

import com.alabenhajsaad.RepairTrackingApi.Dto.MachineDto;
import com.alabenhajsaad.RepairTrackingApi.Entities.Machine;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceMachine;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/machine")
public class MachineController {
    private final IServiceMachine iServiceMachine ;
    @PostMapping()
    public Machine AddMachine(@RequestBody MachineDto machine) {
        return iServiceMachine.AddMachine(machine);
    }
    @GetMapping("getMachinesByClientNumber")
    public List<Machine> getMachinesByClientNumber(@RequestParam String phoneNumber){
        return iServiceMachine.getMachinesByClientNumber(phoneNumber) ;
    }
}
