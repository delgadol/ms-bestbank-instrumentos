package com.bestbank.instrumentos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import jakarta.annotation.PostConstruct;

@EnableDiscoveryClient
@SpringBootApplication
public class MsBestbanckInstrumentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBestbanckInstrumentosApplication.class, args);
	}
	
}
