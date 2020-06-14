package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.MedicinskaSestraDTO;
import com.mrsisa.eclinic.dto.ReceptDTO;
import com.mrsisa.eclinic.model.MedicinskaSestra;
import com.mrsisa.eclinic.model.Recept;
import com.mrsisa.eclinic.service.MedicinskaSestraService;
import com.mrsisa.eclinic.service.ReceptService;

@RestController
@RequestMapping("/sestra")
public class MedicinskaSestraController {
	
	@Autowired
	MedicinskaSestraService msService;
	
	@Autowired 
	ReceptService receptService;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_SESTRA')")
	public ResponseEntity<MedicinskaSestraDTO> getSestra(@RequestParam("eadresa") String eadresa){
		MedicinskaSestra ms = msService.findByEmail(eadresa);
		MedicinskaSestraDTO sestra = new MedicinskaSestraDTO(ms);
		return new ResponseEntity<MedicinskaSestraDTO>(sestra, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/recepti", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_SESTRA')")
	public ResponseEntity<List<ReceptDTO>> getRecepti(@RequestParam("eadresa") String eadresa){
		
		MedicinskaSestra ms = msService.findByEmail(eadresa);
		List<Recept> recepti = receptService.findAll();
		List<ReceptDTO> receptiDTO = new ArrayList<ReceptDTO>();
		
		for(Recept r : recepti) {
			System.out.print(r.getIzvjestajPregleda().getIzvjestaj_id());
			if((r.getIzvjestajPregleda().getPregled().getLjekar().getKlinika().getNaziv()).equals(ms.getKlinika().getNaziv()) && (r.getSestra() == null))
				receptiDTO.add(new ReceptDTO(r.getLijek().getNaziv(), null, r.getRecept_id()));
		}
		
		if(receptiDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<ReceptDTO>>(receptiDTO, HttpStatus.OK);
	}
	
	@PutMapping(value = "/ovjera", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_SESTRA')")
	public ResponseEntity<ReceptDTO> recept(@RequestBody ReceptDTO receptDTO){
		
		Recept recept = receptService.findOneById(Long.parseLong(receptDTO.getIdRecepta()));
		MedicinskaSestra sestra = msService.findByEmail(receptDTO.getEadresaMedSestre());
		recept.setSestra(sestra);
		recept = receptService.save(recept);
		
		return new ResponseEntity<>(receptDTO, HttpStatus.OK);
	}
	

}
