package com.alabenhajsaad.RepairTrackingApi.Services;

import com.alabenhajsaad.RepairTrackingApi.Repository.ReparationRepository;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceCallNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CallNumberGeneratorService implements IServiceCallNumberGenerator {

    private static final int MAX_NUMBER = 999;
    private static final String INITIAL_CALL_NUMBER = "A001";

    private final ReparationRepository repository;

    public String getLastCallNumber() {
        String lastCallNumber = repository.findLastCallNumber();
        String currentYear = getCurrentYear();

        // If no previous call number exists or it's from a different year, start with the initial call number
        if (lastCallNumber == null || !isSameYear(lastCallNumber, currentYear)) {
            return currentYear + INITIAL_CALL_NUMBER;
        }
        return lastCallNumber;
    }


    public String generateNewCallNumber(String lastCallNumber) {
        String year = lastCallNumber.substring(0, 2);
        char letter = lastCallNumber.charAt(2);
        int number = Integer.parseInt(lastCallNumber.substring(3));


        if (number == MAX_NUMBER) {
            letter++;
            number = 1;  // Reset number to 001
        } else {
            number++;  // Increment the number
        }


        return year + letter + String.format("%03d", number);
    }


    private String getCurrentYear() {
        return String.valueOf(LocalDate.now().getYear()).substring(2);
    }


    private boolean isSameYear(String lastCallNumber, String currentYear) {
        return lastCallNumber.startsWith(currentYear);
    }


    public String getGeneratedCallNumber() {
        // First, retrieve the last valid call number, then generate the next one
        return generateNewCallNumber(getLastCallNumber());
    }
}
