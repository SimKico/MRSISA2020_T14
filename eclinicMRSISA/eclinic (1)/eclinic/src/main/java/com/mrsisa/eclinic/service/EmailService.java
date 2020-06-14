package com.mrsisa.eclinic.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender emailSender;
	
	@Autowired
	ZahtjeviRegService regService;
//	
//	@Autowired
//	AdminKlinikeService adminKlinkeService;
	
	@Async
	public void sendDenialEmail(String email, String reason) {
		
		//ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(email);
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("kovacevic.natasa.95@gmail.com"); 
        message.setSubject("Eclinic - Zahtjev za registraciju"); 
        message.setText("Odbijen vam je zahtjev za registraciju." + reason);
        emailSender.send(message);
	}
	
	@Async
	public void sendAcceptanceEmail(String email) {
		
		ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(email);
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("kovacevic.natasa.95@gmail.com"); 
        message.setSubject("Eclinic - Aktivacija naloga"); 
        message.setText("Aktivirajte nalog klikom na aktivacioni link: \n\n" 
        		+ "http://localhost:8080/zahtjeviReg/aktivacija/"+zahtjev.getIdZahtjeva());
        emailSender.send(message);
	}
	
	@Async
	public void requestPregledEmail(String tipPregleda, String datumPregleda, String emailLjekara, String vrijemePregleda, Klinika kl,String email) {
		
		
//		for(AdminKlinike k : kl.getAdminKlinike()) {
			SimpleMailMessage message = new SimpleMailMessage(); 
			//TO DO uncoment after test period
			// message.setTo(k.getPrijava().geteAdresa()); 
			 message.setTo("s.snjezana@outlook.com"); 
		     message.setSubject("Eclinic - Zahtjev za pregled pacijenta"); 
		     message.setText("Zelim da zakazem pregled u vasoj klinici." + tipPregleda + " " + datumPregleda + " " + emailLjekara + " "+  vrijemePregleda + " " + email );
	         emailSender.send(message);
//		}
       
	}


	public void requestBrziPregledEmail(TipPregleda tipPregleda, Date datum, String email, String vrijemePocetka,
			Klinika klinika, String emailPacijenta) {
		
//		for(AdminKlinike k : klinika.getAdminKlinike()) {
//			System.out.println(klinika.getAdminKlinike());
			SimpleMailMessage message = new SimpleMailMessage(); 
			//TO DO uncoment after test period
			// message.setTo(k.getPrijava().geteAdresa()); 
			 message.setTo("s.snjezana@outlook.com"); 
		     message.setSubject("Eclinic - Zahtjev za pregled pacijenta"); 
		     message.setText("Zelim da zakazem pregled u vasoj klinici." + tipPregleda + " " + datum + " " + email + " "+  vrijemePocetka  + " " + emailPacijenta);
	         emailSender.send(message);
//		}
		
	}


	

}
