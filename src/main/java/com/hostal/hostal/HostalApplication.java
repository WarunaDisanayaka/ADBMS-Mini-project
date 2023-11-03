package com.hostal.hostal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend domain
public class HostalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostalApplication.class, args);
	}

}
