package com.isaiahs.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.isaiahs.relationships.models.Dojo;
import com.isaiahs.relationships.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id); //findById method re
        if(optionalDojo.isPresent()) { //isPresent() method checks to see if our dojo object exists
            return optionalDojo.get(); //if dojo object exists, then it is returned by calling get() method. Otherwise, returns null.
        } else {
            return null;
        }
    }
}
