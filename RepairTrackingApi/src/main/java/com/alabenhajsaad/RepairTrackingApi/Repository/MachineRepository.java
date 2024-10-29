package com.alabenhajsaad.RepairTrackingApi.Repository;

import com.alabenhajsaad.RepairTrackingApi.Entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository<Machine ,Integer> {
    List<Machine> getMachinesByClient_Id(int id) ;
}
