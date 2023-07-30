package com.example.healthcaremicroservice.healthcaremicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareMicroserviceApplication implements CommandLineRunner {

	private final ClinicService clinicService;
	@Autowired
	public HealthcareMicroserviceApplication(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	public static void main(String[] args) {
		System.out.println("Jeg er i main");
		SpringApplication.run(HealthcareMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		clinicService.importCSV("sor.csv");
	}



}
