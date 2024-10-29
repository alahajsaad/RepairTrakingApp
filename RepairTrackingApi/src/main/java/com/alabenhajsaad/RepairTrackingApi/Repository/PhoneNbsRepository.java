package com.alabenhajsaad.RepairTrackingApi.Repository;

import com.alabenhajsaad.RepairTrackingApi.Entities.PhoneNbs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNbsRepository extends JpaRepository<PhoneNbs, Integer> {
    PhoneNbs getPhoneNbsByNumber(String number) ;
}
