package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.LjekarService;
import com.mrsisa.eclinic.service.PregledService;

@RestController
@RequestMapping("/klinika")
@CrossOrigin("*")
public class KlinikaController {
	
	@Autowired 
	private KlinikaService klinikaService;

	@Autowired 
	private LjekarService ljekarService;

	@Autowired 
	private PregledService pregledService;

	@RequestMapping(value = "/listaKlinika",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KlinikaDTO>> getAllKlinika(){	
		List<Klinika> listaKlinika = klinikaService.findAll();
	
		List<KlinikaDTO> listaKlinikaDTO = new ArrayList<KlinikaDTO>();
		
		for(Klinika k : listaKlinika) {
			List<TipPregledaDTO> tipoviPregledaDTO = new ArrayList<TipPregledaDTO>();
			
			KlinikaDTO klinikaDTO = new KlinikaDTO(k, null,null,null);
			listaKlinikaDTO.add(klinikaDTO);	
		}
		
		System.out.println("nesto");
		return new ResponseEntity<>(listaKlinikaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listaKlinika/{naziv}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KlinikaDTO> getKlinika(@PathVariable("naziv") String naziv){	
		Klinika klinika = klinikaService.findOneKlinkaByNaziv(naziv);
		Set<Ljekar> ljekari = klinika.getLjekari();
		Set<LjekarDTO> ljekariDTO = new HashSet<>();
		Set<PregledDTO> preglediDTO = new HashSet<>();
		
		for(Ljekar lj : ljekari) {
			LjekarDTO ljekarDTO = new LjekarDTO();
			List<Pregled> preglediLjekara = pregledService.getAllByLjekarId(lj.getId());
			for(Pregled p: preglediLjekara) {
				if(p.getStatus().equals(StatusPregleda.slobodan)) {
					PregledDTO pregledDTO = new PregledDTO();
					pregledDTO.setDatum(p.getDatum());
					pregledDTO.setLjekarDTO(ljekarDTO);
					pregledDTO.setVrijemePocetka(p.getVrijemePocetka());
					TipPregledaDTO tipPregledaDTO = new TipPregledaDTO(p.getTipPregleda(),null);
					pregledDTO.setTipPregledaDTO(tipPregledaDTO);
					pregledDTO.setId(p.getPregled_id());
					preglediDTO.add(pregledDTO);
				}
			
			}
			ljekarDTO.setIme(lj.getIme());
			ljekarDTO.setPrezime(lj.getPrezime());
			ljekarDTO.setProsjecnaOcjena(lj.getProsjecnaOcjena());
			ljekarDTO.setSpecijalizacija(lj.getSpecijalizacija());
			ljekariDTO.add(ljekarDTO);
		}

		
		//klinika.setLjekari(ljekari);
		KlinikaDTO klinikaDTO = new KlinikaDTO(klinika, ljekariDTO,null,preglediDTO);
		System.out.println(klinika.getId());
		System.out.println(klinika.getLjekari());
		System.out.println(ljekariDTO);
		System.out.println("nesto");
		System.out.println(naziv);
//		if (klinika == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
		return new ResponseEntity<>(klinikaDTO, HttpStatus.OK);
	}
	
	

}
