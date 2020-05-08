package com.mrsisa.eclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.service.KlinikaService;

@RestController
@RequestMapping("/klinika")
@CrossOrigin("*")
public class KlinikaController {
	
	@Autowired 
	private KlinikaService klinikaService;
	
	@RequestMapping(value = "/listaKlinika",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Klinika>> getAllKlinika(){	
		List<Klinika> listaKlinika = klinikaService.findAll();
		System.out.println("nesto");
		return new ResponseEntity<>(listaKlinika, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{naziv}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Klinika> getKlinika(@PathVariable("naziv") String naziv){	
		Klinika klinika = klinikaService.findOneKlinkaByNaziv(naziv);

		System.out.println("nesto");
		System.out.println(naziv);
		if (klinika == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(klinika, HttpStatus.OK);
	}
}
