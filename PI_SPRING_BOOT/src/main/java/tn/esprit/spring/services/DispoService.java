package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DisponibilityRepository;
import tn.esprit.spring.repository.UserRepository;


@Component
public class DispoService implements IDispoService {
	private static final String idd = null;
	@Autowired
	DisponibilityRepository DispoRepository;
	
	@Override
	public Disponibility addDispo(Disponibility dispo) {
		return DispoRepository.save(dispo);
	}

	@Override
	public List<Disponibility> getAllDispo() {
		return (List<Disponibility>)DispoRepository.findAll();
	}
	

}
