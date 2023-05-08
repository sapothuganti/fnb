package com.fnb.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fnb.services.client.ServiceClient;

@RestController
//@RequestMapping(value = "/fnb-home")
public class FnbController {
	
	@Autowired
	private ServiceClient client;
	
	@GetMapping(value = "/services", produces = "application/json")
	public ResponseEntity<List<String>> services(){
		ResponseEntity<List<String>> responseBody=null;
		List<String> services=new ArrayList<>();
		services.add("bank");
		services.add("invest");
		responseBody=new ResponseEntity<List<String>>(services, HttpStatus.OK);
		return responseBody;
	}
//	@GetMapping(path ="/searchby/{serviceName}")
	@GetMapping(value = "/searchby/{serviceName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> fetchServices(@PathVariable("serviceName") String serviceName){
		System.out.println("came--"+serviceName);
		List<String> singleService= client.callServices(serviceName);
		if(singleService != null && singleService.isEmpty()) {
			return new ResponseEntity<List<String>>(singleService, HttpStatus.OK);
		}
		
		return null;
	}

}
