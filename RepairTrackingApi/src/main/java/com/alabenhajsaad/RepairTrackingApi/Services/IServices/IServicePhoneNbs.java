package com.alabenhajsaad.RepairTrackingApi.Services.IServices;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;

public interface IServicePhoneNbs {
    Client getClientByPhoneN(String number) ;
}
