package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.DijagnozaDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LijekDTO;
import com.mrsisa.eclinic.model.Dijagnoza;
import com.mrsisa.eclinic.model.Klinika;
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
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
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
	@PreAuthorize("hasAuthority('ROLE_ADMINKC')")
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
	
	@RequestMapping(value="/ucitajDijagnoze",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DijagnozaDTO>> getAllDijagnoze(){	
		List<Dijagnoza> listaDijagnoza = dijagnozaService.findAll();
		List<DijagnozaDTO> dijagnoze = new ArrayList<DijagnozaDTO>();
		
		for(Dijagnoza dijagnoza : listaDijagnoza) {
			dijagnoze.add(new DijagnozaDTO(dijagnoza.getNaziv()));
		}
		
		return new ResponseEntity<>(dijagnoze, HttpStatus.OK);

	}
	
	@RequestMapping(value="/ucitajLijekove", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LijekDTO>> getAllLijekovi(){
		List<Lijek> listaLijekova = lijekService.findAll();
		List<LijekDTO> lijekovi = new ArrayList<LijekDTO>();
		
		for(Lijek lijek : listaLijekova) {
			lijekovi.add(new LijekDTO(lijek.getNaziv()));
		}
		
		return new ResponseEntity<>(lijekovi, HttpStatus.OK);
	}
	
	
	
	

}
