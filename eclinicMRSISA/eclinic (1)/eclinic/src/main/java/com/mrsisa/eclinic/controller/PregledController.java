package com.mrsisa.eclinic.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.service.PregledService;

@RestController
@RequestMapping("/pregled")
@CrossOrigin("*")
public class PregledController {
	
	@Autowired 
	private PregledService pregledService;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//private Date dateNaissance;
	
	@RequestMapping(value ="/pretragaPregleda/{tipPregleda}/{datum}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PregledDTO>> getPretragaPregleda(@PathVariable("tipPregleda") String tipPregleda,@PathVariable("datum") String datum) throws Exception{
		System.out.println(Specijalizacija.valueOf(tipPregleda) + tipPregleda + datum);
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(datum); 
		System.out.println(Specijalizacija.valueOf(tipPregleda) + tipPregleda +" " +date1);
		List<PregledDTO> preglediDTO = pregledService.pretraziPreglede(date1, Specijalizacija.valueOf(tipPregleda));
		
//		List<PregledDTO> preglediDTO = new ArrayList<PregledDTO>();
		
//		for( Pregled pregled : pregledi) {
//			PregledDTO pregledDTO = new PregledDTO(pregled);
//			System.out.println(pregled);
//			preglediDTO.add(pregledDTO);
//			
//		}
//		System.out.println(pregledi);
		System.out.println(preglediDTO);
		
		//RESPONSE TREBA DA BUDU KLINIKE
		
		return new ResponseEntity<>(preglediDTO,HttpStatus.OK);
	}
}
