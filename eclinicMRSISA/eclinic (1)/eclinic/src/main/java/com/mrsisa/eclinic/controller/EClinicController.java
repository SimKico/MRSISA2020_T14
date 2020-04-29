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

//	@RequestMapping(value = "/")
//	public ModelAndView getLogin(){
//		ModelAndView newView = new ModelAndView();
//		newView.setViewName("login");
//			return newView;
//	}
	
	@RequestMapping(value = "/homepagePacijent1")
	public ModelAndView getHomepagePacijenta(){
		ModelAndView newView = new ModelAndView();
		newView.setViewName("homepagePacijent1");
			return newView;
	}
	
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
