package com.alabenhajsaad.RepairTrackingApi.Services;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;
import com.alabenhajsaad.RepairTrackingApi.Repository.ClientRepository;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientService implements IServiceClient {
    private final ClientRepository repository ;

    @Override
    public Client AddClient(Client client) {
        // Synchronisation des relations bidirectionnelles
        if (client.getPhoneNbsList() != null) {
            client.getPhoneNbsList().forEach(phoneNbs -> phoneNbs.setClient(client));
        }
        return repository.save(client);
    }

    @Override
    public List<Client> GetAllClients() {
        return List.of();
    }
}
