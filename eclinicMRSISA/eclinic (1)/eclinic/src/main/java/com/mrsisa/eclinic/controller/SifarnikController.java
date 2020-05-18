package com.mrsisa.eclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.DijagnozaDTO;
import com.mrsisa.eclinic.dto.LijekDTO;
import com.mrsisa.eclinic.model.Dijagnoza;
import com.mrsisa.eclinic.model.Lijek;
import com.mrsisa.eclinic.model.SifarnikDijagnoza;
import com.mrsisa.eclinic.model.SifarnikLijekova;
import com.mrsisa.eclinic.service.DijagnozaService;
import com.mrsisa.eclinic.service.LijekService;
import com.mrsisa.eclinic.service.SifarnikDijagnozaService;
import com.mrsisa.eclinic.service.SifarnikLijekovaService;

@RestController
@RequestMapping("sifarnik")
public class SifarnikController {
	
	@Autowired
	SifarnikDijagnozaService sdService;
	
	@Autowired
	SifarnikLijekovaService slService;
	
	@Autowired
	LijekService lijekService;
	
	@Autowired 
	DijagnozaService dijagnozaService;
	
	@PostMapping(value = "/lijek", consumes =  "application/json")
	public ResponseEntity<String> addLijek(@RequestBody LijekDTO lijekDTO){
		
		SifarnikLijekova sl = slService.findSLById((long) 1);
		Lijek provjera = lijekService.findLijekByName(lijekDTO.getLijek());
		
		if(provjera != null) {
			return new ResponseEntity<>("Lijek već postoji u šifarniku.",HttpStatus.BAD_REQUEST);
		}
		
		Lijek noviLijek = new Lijek(lijekDTO.getLijek());
		
		sl.getLijekovi().add(noviLijek);
		noviLijek = lijekService.save(noviLijek);
		
		return new ResponseEntity<>("{\"msg\":\"Lijek je upisan u šifarnik.\"}",HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/dijagnoza", consumes = "application/json")
	public ResponseEntity<String> addDijagnoza(@RequestBody DijagnozaDTO dijagnozaDTO){
		
		SifarnikDijagnoza sd = sdService.findSDById((long) 1);
		Dijagnoza provjera = dijagnozaService.findDijagnozaByName(dijagnozaDTO.getDijagnoza());
		
		if(provjera != null) {
			return new ResponseEntity<>("Dijagnoza već postoji u šifarniku.",HttpStatus.BAD_REQUEST);
		}
		
		Dijagnoza novaDijagnoza = new Dijagnoza(dijagnozaDTO.getDijagnoza());
		
		sd.getDijagnoze().add(novaDijagnoza);
		novaDijagnoza = dijagnozaService.save(novaDijagnoza);
		
		return new ResponseEntity<>("{\"msg\":\"Dijagnoza je upisana u šifarnik.\"}",HttpStatus.CREATED);
	}
	

}
