package com.coding.dojo_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.dojo_ninjas.models.Ninja;
import com.coding.dojo_ninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo=ninjaRepo;
	}
	
	
	
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public List<Ninja> allNinjasAtDojo(Long id){
		return ninjaRepo.findByDojo_Id(id);
	}
	
	public Ninja createNinja(Ninja ninja) {
		System.out.println("Does it get here?");
		return ninjaRepo.save(ninja);
	}
	
	

}