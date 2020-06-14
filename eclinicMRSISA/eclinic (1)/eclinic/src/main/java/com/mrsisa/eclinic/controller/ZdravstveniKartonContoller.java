package com.mrsisa.eclinic.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.IzvjestajPregledaDTO;
import com.mrsisa.eclinic.dto.ZdravstveniKartonDTO;
import com.mrsisa.eclinic.model.Dijagnoza;
import com.mrsisa.eclinic.model.IzvjestajPregleda;
import com.mrsisa.eclinic.model.Lijek;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Recept;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.model.ZdravstveniKarton;
import com.mrsisa.eclinic.service.DijagnozaService;
import com.mrsisa.eclinic.service.IzvjestajPregledaService;
import com.mrsisa.eclinic.service.LijekService;
import com.mrsisa.eclinic.service.PacijentService;
import com.mrsisa.eclinic.service.PregledService;
import com.mrsisa.eclinic.service.ReceptService;
import com.mrsisa.eclinic.service.ZdravKartonService;

@RestController
@RequestMapping("zdravKarton")
public class ZdravstveniKartonContoller {
	
	@Autowired
	PregledService pregledService;
	
	@Autowired 
	ZdravKartonService zkService;
	
	@Autowired
	IzvjestajPregledaService ipService;
	
	@Autowired
	PacijentService pacijentService;
	
	@Autowired
	DijagnozaService dijagnozaService;
	
	@Autowired
	LijekService lijekService;
	
	@Autowired
	ReceptService receptService;
	
	
	
	@RequestMapping(value = "/ucitajZdravKarton", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_LJEKAR')")
	@ResponseBody
	public ResponseEntity<ZdravstveniKartonDTO> getOneByEmail(@RequestParam("idPregleda") String idPregleda){
		
	    System.out.print(idPregleda);
		
		
	    Pregled pregled = pregledService.getOneByid(Long.parseLong(idPregleda));
	  
	    ZdravstveniKarton zk = zkService.findZkById(pregled.getPacijent().getZdravstveniKarton().getIdKartona());
	  
	    ZdravstveniKartonDTO zkDTO = new ZdravstveniKartonDTO(zk, null, pregled);
	    zkDTO.setIzvjestajPregledaDTO(new HashSet<>());
	    
	    for(IzvjestajPregleda ip : zk.getIzvjestajPregleda()) {
			
	    	if(ip.getPregled().getLjekar().getId() == pregled.getLjekar().getId()) {
	    		System.out.print(ip.getIzvjestaj());
				zkDTO.getIzvjestajPregledaDTO().add(new IzvjestajPregledaDTO(ip));	
	    	}  
	    }

		return new ResponseEntity<ZdravstveniKartonDTO>(zkDTO, HttpStatus.OK);
	}
	
	@PostMapping(value= "/izvjestajPregleda", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_LJEKAR')")
	public ResponseEntity<IzvjestajPregledaDTO> saveIzvjestaj(@RequestBody IzvjestajPregledaDTO ipDTO){
		
		System.out.print(ipDTO.getLijekovi());
		
		Pregled pregled = pregledService.getOneByid(ipDTO.getPregledId());
		pregled.setStatus(StatusPregleda.odrzan);
		pregled = pregledService.save(pregled);
		
		Dijagnoza dijagnoza = dijagnozaService.findDijagnozaByName(ipDTO.getDijagnozaDTO().getDijagnoza());
		ZdravstveniKarton zk = zkService.findZkById(pregled.getPacijent().getZdravstveniKarton().getIdKartona());
		Set<Recept> recepti = new HashSet<Recept>();
		
		IzvjestajPregleda ip = new IzvjestajPregleda();
		ip.setDijagnoza(dijagnoza);
		ip.setPregled(pregled);
		ip.setIzvjestaj(ipDTO.getIzvjestaj());
		ip.setRecepti(recepti);
		
		
		
		zk.getIzvjestajPregleda().add(ip);
		ip = ipService.save(ip);
		
		for(String l : ipDTO.getLijekovi()) {		
			Lijek lijek = lijekService.findLijekByName(l);
			Recept recept = new Recept();
			recept.setLijek(lijek);
			recept.setIzvjestajPregleda(ip);
			recept = receptService.save(recept);
		}
		
		return new ResponseEntity<>(ipDTO,HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmjenaPodataka", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_LJEKAR')")
	public ResponseEntity<ZdravstveniKartonDTO> changePatientInfo(@RequestBody ZdravstveniKartonDTO zkDTO){
		System.out.print(zkDTO.getImePacijenta());
		Pacijent pacijent = pacijentService.findOne(zkDTO.getJboPacijenta());
		ZdravstveniKarton zk = zkService.findZkById(pacijent.getZdravstveniKarton().getIdKartona());
		zk.setAlergije(zkDTO.getAlergije());
		zk.setDioptrija(zkDTO.getDioptrija());
		zk.setTezinaKg(zkDTO.getTezinaKg());
		zk.setVisinaCm(zkDTO.getVisinaCm());
		zk.setKrvnaGrupa(zkDTO.getKrvnaGrupa());
		zk = zkService.save(zk);
		ZdravstveniKartonDTO dto = new ZdravstveniKartonDTO(zk);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/izmjeniIzvjestaj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAuthority('ROLE_LJEKAR')")
	public ResponseEntity<IzvjestajPregledaDTO> changePatientReport(@RequestBody IzvjestajPregledaDTO ipDTO){
		
		Pregled pregled = pregledService.getOneByid(ipDTO.getPregledId());
		ZdravstveniKarton zk = zkService.findZkById(pregled.getPacijent().getZdravstveniKarton().getIdKartona());
		Dijagnoza dijagnoza = dijagnozaService.findDijagnozaByName(ipDTO.getDijagnozaDTO().getDijagnoza());
		System.out.print(dijagnoza.getNaziv());
		
		for(IzvjestajPregleda ip : zk.getIzvjestajPregleda()) {
			
			IzvjestajPregleda ipr = ipService.findIzjvPregledaById(ip.getIzvjestaj_id());
			System.out.print(ipr.getIzvjestaj());
			
			if(ipr.getPregled().getPregled_id() == pregled.getPregled_id()) {

				ipr.setDijagnoza(dijagnoza);
				ipr.setIzvjestaj(ipDTO.getIzvjestaj());
				ipr = ipService.save(ipr);
				
				break;
				
			}
			
			
		}
		
		
		
		
		return new ResponseEntity<>(ipDTO, HttpStatus.OK);
	}
	
	
}
