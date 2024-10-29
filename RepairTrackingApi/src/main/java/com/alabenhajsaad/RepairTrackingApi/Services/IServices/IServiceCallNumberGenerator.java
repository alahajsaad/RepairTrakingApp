package com.alabenhajsaad.RepairTrackingApi.Services.IServices;

public interface IServiceCallNumberGenerator {
    String getLastCallNumber();
    String generateNewCallNumber(String prev) ;
    String getGeneratedCallNumber() ;
}
