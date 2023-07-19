package com.bestbank.instrumentos;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MsBestbanckInstrumentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBestbanckInstrumentosApplication.class, args);
	}
	
  @PostConstruct
  void init() {
    //TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
  }

}
