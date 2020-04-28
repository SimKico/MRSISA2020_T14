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

//	@SLOBO ovjde trebas dodati pocetnu stranicu, tj.prvu stranu koja ce se ikada prikazati
	//to je vjerovatno stranica login.html
	//znaci, samo return "login.html" ali prije tog moras da sve html stavis u templates
//	@GetMapping("/")
//	public String index()
//	{
//		return "";
//	}
	
	@RequestMapping(value = "/profilPacijenta")
	public ModelAndView getProfilPacijenta(){
		ModelAndView newView = new ModelAndView();
		newView.setViewName("profilPacijenta");
			return newView;
	}
	@RequestMapping(value = "/azurirajProfil")
	public ModelAndView getAzurirajPacijenta(){
		ModelAndView newView = new ModelAndView();
		newView.setViewName("/azurirajProfil");
			return newView;
	}
	
}
