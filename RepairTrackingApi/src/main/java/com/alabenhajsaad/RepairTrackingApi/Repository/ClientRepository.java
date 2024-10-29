package com.alabenhajsaad.RepairTrackingApi.Repository;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
