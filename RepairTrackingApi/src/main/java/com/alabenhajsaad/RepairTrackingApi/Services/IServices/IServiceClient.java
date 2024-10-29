package com.alabenhajsaad.RepairTrackingApi.Services.IServices;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;

import java.util.List;

public interface IServiceClient {
    public Client AddClient(Client client) ;
    public List<Client> GetAllClients () ;
}
