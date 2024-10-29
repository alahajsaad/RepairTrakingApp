package com.alabenhajsaad.RepairTrackingApi.Services;

import com.alabenhajsaad.RepairTrackingApi.Dto.MachineDto;
import com.alabenhajsaad.RepairTrackingApi.Entities.Client;
import com.alabenhajsaad.RepairTrackingApi.Entities.Machine;
import com.alabenhajsaad.RepairTrackingApi.Repository.ClientRepository;
import com.alabenhajsaad.RepairTrackingApi.Repository.MachineRepository;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceMachine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineService implements IServiceMachine {
    private final MachineRepository repository ;
    private final PhoneNbsService phoneNbsService ;
    private final ClientRepository clientRepository;
    @Override

    public Machine AddMachine(MachineDto dto) {

        Client client = clientRepository.findById(dto.Client_id()).get() ;

        Machine machine = Machine.builder()
                .designation(dto.designation())
                .numeroS(dto.numeroS())
                .reference(dto.reference())
                .client(client)
                .build();
        if (machine.getId() != null) {
            throw new IllegalArgumentException("Cannot add a machine that already has an ID");
        }
        return repository.save(machine);
    }

    @Override
    public Machine UpdateMachine(Machine machine) {
        // Ensure that we're updating an existing machine, meaning its ID should not be null
        if (machine.getId() == null) {
            throw new IllegalArgumentException("Cannot update a machine without an ID");
        }

        // Optionally: You can verify that the machine exists in the database before updating
        if (!repository.existsById(machine.getId())) {
            throw new IllegalArgumentException("Machine with ID " + machine.getId() + " does not exist");
        }

        return repository.save(machine);
    }

    @Override
    public Machine getMachineById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Machine> getMachinesByClientNumber(String number) {
        return repository.getMachinesByClient_Id(phoneNbsService.getClientByPhoneN(number).id);
    }
}
