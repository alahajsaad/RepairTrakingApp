package com.alabenhajsaad.RepairTrackingApi.Services;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;
import com.alabenhajsaad.RepairTrackingApi.Entities.PhoneNbs;
import com.alabenhajsaad.RepairTrackingApi.Repository.PhoneNbsRepository;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServicePhoneNbs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneNbsService implements IServicePhoneNbs {

    private final PhoneNbsRepository repository ;

    @Override
    public Client getClientByPhoneN(String number) {
        PhoneNbs phoneNbs = repository.getPhoneNbsByNumber(number);
        if (phoneNbs != null && phoneNbs.getClient() != null) {
            return phoneNbs.getClient();
        } else {
            return null; // Return null if no client is associated
        }
    }
}
