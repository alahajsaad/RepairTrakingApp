package com.alabenhajsaad.RepairTrackingApi;

import com.alabenhajsaad.RepairTrackingApi.Entities.Client;
import com.alabenhajsaad.RepairTrackingApi.Entities.Machine;
import com.alabenhajsaad.RepairTrackingApi.Entities.PhoneNbs;
import com.alabenhajsaad.RepairTrackingApi.Repository.ClientRepository;
import com.alabenhajsaad.RepairTrackingApi.Repository.MachineRepository;
import com.alabenhajsaad.RepairTrackingApi.Repository.PhoneNbsRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RepairTrackingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairTrackingApiApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(
			ClientRepository clientRepository,
			MachineRepository machineRepository
	) {
		return args -> {
			Faker faker = new Faker();

			for (int i = 0; i < 20; i++) {
				// Create a new Client
				Client client = Client.builder()
						.name(faker.name().fullName())
						.email(faker.internet().emailAddress())
						.build();

				// Create a list of phone numbers
				List<PhoneNbs> phoneNbsList = new ArrayList<>();
				for (int j = 0; j < 2; j++) {  // Let's add 2 phone numbers for each client
					PhoneNbs phoneNbs = PhoneNbs.builder()
							.number(faker.phoneNumber().cellPhone())
							.client(client)  // Set the client for the phone number
							.build();
					phoneNbsList.add(phoneNbs);
				}

				// Associate the phone numbers with the client
				client.setPhoneNbsList(phoneNbsList);

				Machine machine = Machine.builder()
						.designation(faker.commerce().productName())
						.reference(faker.bothify("REF-####"))
						.numeroS(faker.bothify("SN-######"))
						.client(client)
						.build();

				// Save the client (CascadeType.ALL ensures phone numbers are saved too)
				clientRepository.save(client);
				machineRepository.save(machine) ;
			}
		};
	}*/
}
