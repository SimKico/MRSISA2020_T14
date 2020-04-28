package com.mrsisa.eclinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")// na jednom mjestu staviti na globalnom nivou
//@RequestMapping()
public class EClinicController {

//	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> sayHello() {
//		return new ResponseEntity<String> ("EClinic", HttpStatus.OK);
//	}
//	
	
	@RequestMapping(value = "/profilPacijenta")
	public ModelAndView getData(){
		ModelAndView newView = new ModelAndView();
		newView.setViewName("profilPacijenta");
			return newView;
	}
	
}
