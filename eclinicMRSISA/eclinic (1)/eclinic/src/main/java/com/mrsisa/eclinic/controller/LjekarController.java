package com.mrsisa.eclinic.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.dto.ZakaziPregledDTO;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.service.LjekarService;
import com.mrsisa.eclinic.service.PacijentService;
import com.mrsisa.eclinic.service.PregledService;
import com.mrsisa.eclinic.service.ZdravKartonService;

@RestController
@RequestMapping("/ljekar")
public class LjekarController {
	
	@Autowired
	LjekarService ljekarService;
	
	@Autowired 
	PregledService pregledService;
	
	@Autowired
	ZdravKartonService zdravKartonService;
	
	@Autowired
	PacijentService pacijentService;
	
	@RequestMapping(value = "/ucitaj",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LjekarDTO>> getLjekar(){	
		
		List<Ljekar> ljekari = ljekarService.findAll();
		List<LjekarDTO> ljekariDTO = new ArrayList<LjekarDTO>();
		
		for(Ljekar lj : ljekari) {
			LjekarDTO ljekar = new LjekarDTO(lj);
			ljekariDTO.add(ljekar);
		}
		return new ResponseEntity<>(ljekariDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pregledi",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PregledDTO>> getPregledi(@RequestParam("eadresa") String eadresa) throws ParseException{	
		
		Ljekar ljekar = ljekarService.findOneByEmail(eadresa);
		List<PregledDTO> pregledi = new ArrayList<PregledDTO>();
		List<Pregled> preg = pregledService.getAllByLjekarId(ljekar.getId());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Pregled p : preg) {
			Date date = new Date();
			System.out.print(date);
			if(sdf.parse(sdf.format((p.getDatum()))).before(sdf.parse(sdf.format(date)))) {
				pregledService.remove(p);
			}
		}
		for (Pregled p : ljekar.getPregledi()) {
			if(p.getStatus() == StatusPregleda.zakazan) {
				System.out.print(p.getDatum());
				LjekarDTO lj = new LjekarDTO(p.getLjekar());
				TipPregledaDTO tp = new TipPregledaDTO(p.getTipPregleda(), null);
				PacijentDTO pac = new PacijentDTO(p.getPacijent());
				PregledDTO pregled = new PregledDTO(p, lj, tp, p.getLjekar().getKlinika().getAdresa(), p.getLjekar().getKlinika().getGrad(), null, pac);
				System.out.print(pregled);
				pregledi.add(pregled);
				
			}
		}
		
		if(pregledi.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pregledi, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/zapocni",  method = RequestMethod.GET)
	public ResponseEntity<String> checkStart(@RequestParam("id") String id) throws ParseException{	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Pregled pregled = pregledService.getOneByid(Long.parseLong(id));
		
		LocalTime pocetak = LocalTime.parse(pregled.getVrijemePocetka());
		LocalTime kraj = pocetak.plusHours(pregled.getTipPregleda().getTrajanje());
		LocalTime trenutno = LocalTime.now();
		
		Date danas = new Date();
		
		if(sdf.parse(sdf.format(danas)).before(sdf.parse(sdf.format(pregled.getDatum())))) {
			return new ResponseEntity<>("Pregled nije na današnji dan.", HttpStatus.BAD_REQUEST);
		}
		else if(trenutno.isBefore(pocetak) || trenutno.isAfter(kraj)) {
			return new ResponseEntity<>("Pregled se ne može započeti. Ili je prošlo vrijeme održavanja ili nije još vrijeme održavanja.", HttpStatus.BAD_REQUEST);
		}
		System.out.print(id);
		return new ResponseEntity<>("Uspjeh", HttpStatus.OK);
	}
	
	
}
