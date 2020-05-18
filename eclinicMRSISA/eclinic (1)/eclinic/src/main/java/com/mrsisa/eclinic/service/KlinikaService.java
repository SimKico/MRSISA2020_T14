package com.mrsisa.eclinic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.repository.KlinikaRepository;

@Service
public class KlinikaService {

	@Autowired 
	private KlinikaRepository klinikaRepository;
	
		
	public List<Klinika> findAll() {
		return klinikaRepository.findAll();
	}
	
	public Klinika findOneKlinkaByNaziv(String name)
	{
		return klinikaRepository.findOneBynaziv(name);
	}
	
	public Klinika save(Klinika klinika) {
		return klinikaRepository.save(klinika);
	}
	
	public List<Klinika> findAllByljekar(Ljekar ljekari){
		return klinikaRepository.findAllByljekari(ljekari);
		
	}
	public List<KlinikaDTO> searchKlinka(Date datum, Specijalizacija tipPregleda){
		List<Long> klinikeId = klinikaRepository.search( datum.toString(),  tipPregleda);
		System.out.println("Pregled ID" + klinikeId);
		List<KlinikaDTO> klinikeDTO = new ArrayList<KlinikaDTO>();
		
		for(Long klinika_id : klinikeId) {
			Klinika klinika = klinikaRepository.findOneByid(klinika_id);
			System.out.println("klinika" + klinika);
			Set<TipPregleda> pregledi =  klinika.getTipoviPregleda();
			System.out.println(pregledi);
			Set<TipPregledaDTO> tipoviPregledaDTO = new HashSet<TipPregledaDTO>();
			for(TipPregleda pregled : pregledi) {
				TipPregledaDTO tipPregledaDTO = new TipPregledaDTO(pregled,null);
				tipoviPregledaDTO.add(tipPregledaDTO);
				System.out.println("Tip pregleda 1" + pregled);
				System.out.println(pregled.getCijena());
				
			}
			KlinikaDTO klinikaDTO = new KlinikaDTO(klinika,null, tipoviPregledaDTO,null);
			klinikeDTO.add(klinikaDTO);
		}
		
		return klinikeDTO;
	}
}
