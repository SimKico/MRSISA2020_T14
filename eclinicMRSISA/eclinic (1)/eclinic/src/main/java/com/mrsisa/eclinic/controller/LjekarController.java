package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.repository.LjekarRepository;
import com.mrsisa.eclinic.repository.PacijentRepository;
import com.mrsisa.eclinic.repository.PregledRepository;
import com.mrsisa.eclinic.repository.ZdravKartonRepository;

@RestController
@RequestMapping("/ljekar")
public class LjekarController {
	
	@Autowired
	LjekarRepository ljekarRepository;
	
	@Autowired 
	PregledRepository pregledRepository;
	
	@Autowired
	ZdravKartonRepository zdravKartonRepository;
	
	@Autowired
	PacijentRepository pacijentRepository;
	
	@RequestMapping(value = "/ucitaj",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LjekarDTO>> getLjekar(){	
		
		List<Ljekar> ljekari = ljekarRepository.findAll();
		List<LjekarDTO> ljekariDTO = new ArrayList<LjekarDTO>();
		
		for(Ljekar lj : ljekari) {
			LjekarDTO ljekar = new LjekarDTO(lj);
			ljekariDTO.add(ljekar);
		}
		return new ResponseEntity<>(ljekariDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pregledi",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PregledDTO>> getPregledi(@RequestParam("eadresa") String eadresa){	
		
		Ljekar ljekar = ljekarRepository.findOneByprijava_eAdresa(eadresa);
		List<PregledDTO> pregledi = new ArrayList<PregledDTO>();
		
		for (Pregled p : ljekar.getPregledi()) {
			if(p.getStatus() == StatusPregleda.zakazan) {
				LjekarDTO lj = new LjekarDTO(p.getLjekar());
				TipPregledaDTO tp = new TipPregledaDTO(p.getTipPregleda(), null);
				PacijentDTO pac = new PacijentDTO(p.getPacijent());
				PregledDTO pregled = new PregledDTO(p, lj, tp, p.getLjekar().getKlinika().getAdresa(), p.getLjekar().getKlinika().getGrad(), null, pac);
				System.out.print(pregled);
				pregledi.add(pregled);
				
			}
		}
		
		
		return new ResponseEntity<>(pregledi, HttpStatus.OK);
	}
	
}
