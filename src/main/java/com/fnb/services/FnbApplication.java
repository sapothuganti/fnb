package com.fnb.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FnbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FnbApplication.class, args);
	}
	
	@Bean
	public RestTemplate newRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
