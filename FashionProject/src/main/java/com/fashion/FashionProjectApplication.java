package com.fashion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fashion.sevice.StorageService;

@SpringBootApplication
public class FashionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			
		storageService.init();
		};
	}


}
