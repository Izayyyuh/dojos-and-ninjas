package com.isaiahs.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.isaiahs.relationships.models.Ninja;
import com.isaiahs.relationships.repositories.NinjaRepo;
@Service
public class NinjaService {

private final NinjaRepo ninjaRepository;
	
	public NinjaService(NinjaRepo ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id); //findById method re
        if(optionalNinja.isPresent()) { //isPresent() method checks to see if our dojo object exists
            return optionalNinja.get(); //if dojo object exists, then it is returned by calling get() method. Otherwise, returns null.
        } else {
            return null;
        }
    }
}
