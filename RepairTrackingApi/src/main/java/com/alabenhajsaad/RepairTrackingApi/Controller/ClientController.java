package com.alabenhajsaad.RepairTrackingApi.Controller;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServiceClient;
import com.alabenhajsaad.RepairTrackingApi.Services.IServices.IServicePhoneNbs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {
   private final IServiceClient iServiceClient ;
   private final IServicePhoneNbs iServicePhoneNbs ;

   @PostMapping()
    public Client addClient(@RequestBody Client client) {
        return iServiceClient.AddClient(client);
    }

    @GetMapping("getClientByPhoneNumber")
    public ResponseEntity<?> getClientByPhoneNumber(@RequestParam String phoneNumber) {
        Client client = iServicePhoneNbs.getClientByPhoneN(phoneNumber);

        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            // Return a message as part of the ResponseEntity when client is not found
            Map<String, String> response = new HashMap<>();
            response.put("message", "Aucun client trouvé pour ce numéro de téléphone.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
