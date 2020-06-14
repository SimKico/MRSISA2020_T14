package com.mrsisa.eclinic.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.OperacijaDTO;
import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.dto.ZahtjeviZaReigstracijuDTO;
import com.mrsisa.eclinic.dto.ZdravstveniKartonDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Operacija;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.model.ZdravstveniKarton;
import com.mrsisa.eclinic.repository.ZahtjeviRegRepository;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.OperacijaService;
import com.mrsisa.eclinic.service.PacijentService;
import com.mrsisa.eclinic.service.PregledService;
import com.mrsisa.eclinic.service.ZahtjeviRegService;
import com.mrsisa.eclinic.service.ZdravKartonService;


@RestController
@RequestMapping("/homepagePacijent1")
@CrossOrigin("*")
public class PacijentController {

	@Autowired
	private PregledService pregledService;
	@Autowired
	private OperacijaService operacijaService;
	@Autowired
	private PacijentService pacijentService;
	@Autowired
	private ZahtjeviRegService regService;
	@Autowired
	private ZdravKartonService kartonService;
	private int broj = 0;
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<PacijentDTO> getHomepagePacijent(@PathVariable("email") String email)
	{
		System.out.println(email);
		 Pacijent p = pacijentService.findOneByEmail(email);
		 return new ResponseEntity<>(new PacijentDTO(p,null, null), HttpStatus.OK);
	}

	@RequestMapping(value = "/profilPacijent/{email}" ,  method = RequestMethod.GET)
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<PacijentDTO>  getProfilPacijent(@PathVariable("email") String email){
		System.out.println(email);
		 Pacijent p = pacijentService.findOneByEmail(email);
		 return new ResponseEntity<>(new PacijentDTO(p,null, null), HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/profilPacijent/azurirajPodatke/{email}" ,  method = RequestMethod.GET)

	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<PacijentDTO>  getPotatkePacijent(@PathVariable("email") String email){
		 Pacijent p = pacijentService.findOneByEmail(email);
		 return new ResponseEntity<>(new PacijentDTO(p,null, null), HttpStatus.OK);
	}	
	

	@PutMapping(value = "/profilPacijent/azurirajProfil/{email}", consumes =  "application/json")
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<PacijentDTO> updatePacijentDTO(@PathVariable("email") String email,@RequestBody	 PacijentDTO pacijentDTO) {
		
		System.out.println(pacijentDTO);
		System.out.println(pacijentDTO.getJedBrojOsiguranika());
//		Pacijent pacijent = pacijentService.findOne(pacijentDTO.getJedBrojOsiguranika());
		Pacijent pacijent = pacijentService.findOneByEmail(email);
		System.out.println(pacijent);
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
	@PostMapping(value = "/registracija", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<String> getRegistrationRequests(@RequestBody ZahtjeviZaReigstracijuDTO podaci)throws ParseException{
		System.out.println("usao u reg");
		System.out.println(podaci.geteAdresa());
		ZahtjeviZaRegistraciju zahtjev = new ZahtjeviZaRegistraciju();
		zahtjev.setIme(podaci.getIme());
		zahtjev.setPrezime(podaci.getPrezime());
		zahtjev.setGrad(podaci.getGrad());
		zahtjev.setBrojTelefona(podaci.getBrojTelefona());
		zahtjev.setJbo(podaci.getJbo());
		zahtjev.setLozinka(podaci.getLozinka());
		zahtjev.setAdresaPrebivalista(podaci.getAdresaPrebivalista());
		zahtjev.seteAdresa(podaci.geteAdresa());
		zahtjev.setDrzava(podaci.getDrzava());
//		zahtjev.setPrihvacen(false);
		System.out.println(zahtjev);
		
		zahtjev = regService.save(zahtjev);
		
		return new ResponseEntity<>("Zahjev je poslat.", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/kartonPacijenta/{email}" ,  method = RequestMethod.GET)
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<ZdravstveniKartonDTO>  getKarton(@PathVariable("email") String email){
		System.out.println(email);
		Pacijent p = pacijentService.findOneByEmail(email);
		 ZdravstveniKarton k = p.getZdravstveniKarton();
		 ZdravstveniKartonDTO kar = new ZdravstveniKartonDTO(k);
		 return new ResponseEntity<>(kar, HttpStatus.OK);
	}	
	

	
	@RequestMapping(value = "/istorijaOperacija/{email}" ,  method = RequestMethod.GET)
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<List<OperacijaDTO>>  getOperacije(@PathVariable("email") String email){
		System.out.println(email);
		Pacijent p = pacijentService.findOneByEmail(email);
		List<OperacijaDTO> operacije = new ArrayList<OperacijaDTO>();
		 ZdravstveniKarton k = kartonService.findZkById(p.getId());
		 if(k!=null) {
		 Set<Operacija> op = k.getOperacije();
		 
		 
		 
		 for(Operacija o : op)
		 {
			 System.out.println("unutra");
			 OperacijaDTO opDO = new OperacijaDTO(o);
			 operacije.add(opDO);
		 }
		 }
		 return new ResponseEntity<>(operacije, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/istorijaPregleda/{email}" ,  method = RequestMethod.GET)
	@PreAuthorize("hasRole('PACIENT')")
	public ResponseEntity<List<PregledDTO>>  getPreglediPacijenta(@PathVariable("email") String email){
		System.out.println(email);
		
		Pacijent p = pacijentService.findOneByEmail(email);
		Set<Pregled> pregledi = p.getPregledi();
		List<PregledDTO> preglediDTO = new ArrayList<PregledDTO>();
		for(Pregled pregled : pregledi)
		{
			
			if(pregled.getPacijent().getEmail().equals(email)) {
				System.out.println(pregled);
				LjekarDTO lj = new LjekarDTO(pregled.getLjekar());
				TipPregledaDTO tip = new TipPregledaDTO( pregled.getTipPregleda(), null);
				PregledDTO pregledDTO = new PregledDTO(pregled,lj,tip, pregled.getLjekar().getKlinika().getAdresa(),  pregled.getLjekar().getKlinika().getGrad(), pregled.getLjekar().getKlinika().getOcjenaKlinike(), null);
				preglediDTO.add(pregledDTO);
			}
			broj++;
		}
		System.out.println(broj);

		 return new ResponseEntity<>(preglediDTO, HttpStatus.OK);
	}	
	
}	
		
		
		
		