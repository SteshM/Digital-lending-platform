package com.example.digitalLendingPlatform;

import com.example.digitalLendingPlatform.models.LoanProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalLendingPlatformApplication {

@Autowired



	public static void main(String[] args) {
		SpringApplication.run(DigitalLendingPlatformApplication.class, args);
	}

}
