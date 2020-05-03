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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Prijava;
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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PacijentDTO> getHomepagePacijent()
	{
		 Pacijent p = pacijentService.findOne("123456");
		 return new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
	}

	@RequestMapping(value = "/profilPacijent" ,  method = RequestMethod.GET)
	public ResponseEntity<PacijentDTO>  getProfilPacijent(){
		 Pacijent p = pacijentService.findOne("123456");
		 return new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
	}	
	@RequestMapping(value = "/profilPacijent/azurirajPodatke" ,  method = RequestMethod.GET)
	public ResponseEntity<PacijentDTO>  getPotatkePacijent(){
		 Pacijent p = pacijentService.findOne("123456");
		 return new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/listaKlinika",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Klinika>> getAllKlinika(){	
		List<Klinika> listaKlinika = klinikaService.findAll();
		System.out.println("nesto");
		return new ResponseEntity<>(listaKlinika, HttpStatus.OK);
	}
	
	@PutMapping(value = "/azurirajProfil1", consumes =  "application/json")
	public ResponseEntity<PacijentDTO> updatePacijetnDTO(@RequestBody PacijentDTO pacijentDTO) {
		System.out.println(pacijentDTO);
		
//		Pacijent pacijent = pacijentService.findOne(pacijentDTO.getJedBrojOsiguranika());
		Pacijent pacijent = pacijentService.findOne("123456");
		
		if (pacijent == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		pacijent.setAdresaPrebivalsta(pacijentDTO.getAdresaPrebivalista());
		pacijent.setDrzava(pacijentDTO.getDrzava());
		pacijent.setBrojTelefona(pacijentDTO.getBrojTelefona());
		pacijent.setGrad(pacijentDTO.getGrad());
		System.out.println("kao da je setovo");

		pacijent = pacijentService.save(pacijent);
		return new ResponseEntity<>(new PacijentDTO(pacijent), HttpStatus.OK);
	}
	
}	
		
		
		
		