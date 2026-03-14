package com.example.Hospital_Management_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EnableJpaAuditing
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().systemProperties().load();
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

}
