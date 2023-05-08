package com.fnb.services.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	public List<String> callServices(String serviceName) {
		if ("bank".equals(serviceName)) {
			// call another micro-service
			System.out.println();
			try {
				ResponseEntity<List> responseBody = null;
				responseBody = restTemplate.getForEntity("http://localhost:8081/fnb-bank/fetchServices", List.class);
				if(HttpStatus.OK.equals(responseBody.getStatusCode())) {
					return responseBody.getBody();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}

}
