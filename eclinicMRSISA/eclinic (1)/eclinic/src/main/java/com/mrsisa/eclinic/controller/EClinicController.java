package com.mrsisa.eclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/test")
public class EClinicController {

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String> ("EClinic", HttpStatus.OK);
	}
	
}
