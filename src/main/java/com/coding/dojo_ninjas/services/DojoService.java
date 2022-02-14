package com.coding.dojo_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo_ninjas.models.Dojo;
import com.coding.dojo_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo=dojoRepo;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
//	
//	public Dojo findById(Long id) {
//	     Optional<Dojo> optionalDojo = dojoRepo.findById(id);
//	     if(optionalDojo.isPresent()) {
//	         return optionalDojo.get();
//	     } 
//	     else {
//	    	 return null;
//	     }
//	 	}
	
	
	public String deleteDojo(Long id) {
	     Optional<Dojo> optionalDojo = dojoRepo.findById(id);
	     if(optionalDojo.isPresent()) {
	    	 dojoRepo.deleteById(id);
	         return "Completed delete";
	         
	     } 
	     else {
	    	 return "No expense with ID found";
	     }
	 	}
	
	public Dojo findDojo(Long id) {
	     Optional<Dojo> optionalDojo = dojoRepo.findById(id);
	     if(optionalDojo.isPresent()) {
	        
	         return optionalDojo.get();
	         
	     } 
	     else {
	    	 return null;
	     }
	 	}

}
