package com.mrsisa.eclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.service.PacijentService;


@RestController
@RequestMapping("homepagePacijent1")
@CrossOrigin("*")
public class PacijentController {

	@Autowired
	private PacijentService pacijentService;

	@RequestMapping(value = "/azurirajProfil1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PacijentDTO> getHomepagePacijenta(@PathVariable Long id){
		Pacijent pacijent = pacijentService.findOne(id);
		
		if(pacijent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PacijentDTO(pacijent), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "")
	@ResponseBody
	public String prikaziProfil() {
		return "homepagePacijent1";
	}
	
	@RequestMapping(value = "/listaKlinika", produces = MediaType.APPLICATION_JSON_VALUE)
	public String azurirajProfil() {
		System.out.println("nesto");
		return "usla si na listuKlinika";
	}
	
//	@RequestMapping(value = "/profilPacijenta")
//	public ModelAndView getProfilPacijenta(){
//		ModelAndView newView = new ModelAndView();
//		newView.setViewName("profilPacijenta1");
//			return newView;
//	}
	
//	@RequestMapping(value = "/azurirajProfil")
//	public ModelAndView getAzurirajPacijenta(){
//		ModelAndView newView = new ModelAndView();
//		newView.setViewName("/azurirajProfil");
//			return newView;
//	}
//	
}
