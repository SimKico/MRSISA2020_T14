package com.mrsisa.eclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.PacijentService;


@RestController
@RequestMapping("/homepagePacijent1")
@CrossOrigin("*")
public class PacijentController {

	@Autowired
	private PacijentService pacijentService;
	
	@Autowired 
	private KlinikaService klinikaService;

//	@RequestMapping(value = "/azurirajProfil1", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<PacijentDTO> getHomepagePacijenta(@PathVariable Long id){
////		Pacijent pacijent = pacijentService.findOne(id);
////		
////		if(pacijent == null) {
////			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////		}
//		
//		return new ResponseEntity<>(new PacijentDTO(pacijent), HttpStatus.OK);
//	}
		
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PacijentDTO> getHomepagePacijent()
	{
		 Pacijent p = pacijentService.myDetails();
		 return new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/profilPacijent" ,  method = RequestMethod.GET)
	public ResponseEntity<PacijentDTO>  getProfilPacijent(){
		 Pacijent p = pacijentService.myDetails();
		 return new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/listaKlinika",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Klinika>> getAllKlinika(){	
		List<Klinika> listaKlinika = klinikaService.findAll();
		System.out.println("nesto");
		return new ResponseEntity<>(listaKlinika, HttpStatus.OK);

	}
	
}	
		
		
		
		