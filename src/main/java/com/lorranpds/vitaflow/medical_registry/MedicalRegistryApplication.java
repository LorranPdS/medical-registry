package com.lorranpds.vitaflow.medical_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class MedicalRegistryApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		SpringApplication.run(MedicalRegistryApplication.class, args);
	}
}
