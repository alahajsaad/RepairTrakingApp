package com.alabenhajsaad.RepairTrackingApi.Services.IServices;

import com.alabenhajsaad.RepairTrackingApi.Dto.MachineDto;
import com.alabenhajsaad.RepairTrackingApi.Entities.Machine;
import com.alabenhajsaad.RepairTrackingApi.Entities.Reparation;

import java.util.List;

public interface IServiceMachine {
    Machine AddMachine(MachineDto machine) ;
    Machine UpdateMachine(Machine machine) ;
    Machine getMachineById(int id) ;
    List<Machine> getMachinesByClientNumber(String number) ;


}
