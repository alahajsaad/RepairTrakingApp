package com.alabenhajsaad.RepairTrackingApi.Services;

import com.alabenhajsaad.RepairTrackingApi.Dto.ReparationDto;
import com.alabenhajsaad.RepairTrackingApi.Entities.Machine;
import com.alabenhajsaad.RepairTrackingApi.Entities.RepairStatus;
import com.alabenhajsaad.RepairTrackingApi.Entities.Reparation;
import com.alabenhajsaad.RepairTrackingApi.Repository.ReparationRepository;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceCallNumberGenerator;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceMachine;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceReparation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReparationService implements IServiceReparation {
    private final ReparationRepository repository ;
    private final IServiceCallNumberGenerator callNumberGenerator ;
    private final IServiceMachine serviceMachine ;
    private final ReparationSpecification reparationSpecification ;

    @Override
    @Transactional
    public void addReparation(ReparationDto dto) {
        // Get machine details
        Machine machine = serviceMachine.getMachineById(dto.machine_id());
        if (machine == null) {
            throw new RuntimeException("Machine not found for ID: " + dto.machine_id());
        }

        // Generate a new call number
        String newCallNumber = callNumberGenerator.getGeneratedCallNumber();

        // Create the new Reparation object
        Reparation reparation = Reparation.builder()
                .callNumber(newCallNumber)
                .description(dto.description())
                .entryDate(LocalDate.now())
                .status(RepairStatus.IN_PROGRESS)
                .machine(machine)
                .build();

        repository.save(reparation);
    }

    @Override
    public Reparation getReparationByCallNumber(String callNumber) {
        return repository.findReparationByCallNumber(callNumber);
    }

    @Override
    public void updateReparationStatus(Reparation reparation) {
        repository.save(reparation) ;
    }

    @Override
    public Page<Reparation> getFiltredReparations(
            RepairStatus reparationStatus,
            String machineRef,
            String clientPhoneNumber,
            Pageable pageable) {

        Specification<Reparation> spec = Specification
                .where(reparationSpecification.hasClientPhoneNumber(clientPhoneNumber))
                .and(reparationSpecification.hasMachineReference(machineRef))
                .and(reparationSpecification.hasStatus(reparationStatus));

        return repository.findAll(spec, pageable);
}

}
