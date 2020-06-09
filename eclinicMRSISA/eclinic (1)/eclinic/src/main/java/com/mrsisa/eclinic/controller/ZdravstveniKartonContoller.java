package com.mrsisa.eclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.ZdravstveniKartonDTO;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.ZdravstveniKarton;
import com.mrsisa.eclinic.service.PregledService;
import com.mrsisa.eclinic.service.ZdravKartonService;

@RestController
@RequestMapping("zdravKarton")
public class ZdravstveniKartonContoller {
	
	@Autowired
	PregledService pregledService;
	
	@Autowired 
	ZdravKartonService zdravKartonService;
	
	@RequestMapping(value = "/ucitajZdravKarton", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ZdravstveniKartonDTO> getOneByEmail(@RequestParam("idPregleda") String idPregleda){
		
		System.out.print(idPregleda);
		
		
		  Pregled pregled = pregledService.getOneByid(Long.parseLong(idPregleda));
		  
		  ZdravstveniKarton zk =
		  zdravKartonService.findZkById(pregled.getPacijent().getZdravstveniKarton().
		  getIdKartona()); ZdravstveniKartonDTO zkDTO = new ZdravstveniKartonDTO(zk,
		  null, pregled);
		 

		return new ResponseEntity<ZdravstveniKartonDTO>(zkDTO, HttpStatus.OK);
	}
	
	
}
