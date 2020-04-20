package tn.esprit.spring.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Disponibility;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DisponibilityRepository;
import tn.esprit.spring.repository.UserRepository;


@Component
public class DispoService implements IDispoService {
	private static final String idd = null;
	@Autowired
	DisponibilityRepository DispoRepository;
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public Disponibility addDispo(Disponibility dispo) {
		return DispoRepository.save(dispo);
	}

	@Override
	public List<Disponibility> getAllDispo() {
		return (List<Disponibility>)DispoRepository.findAll();
	}

	@Override
	public void deleteDispo(Long DispoId) {
		DispoRepository.deleteById(DispoId);
	}
	@Transactional
	@Override
	public String AjouterDispoUser(int userId, int DispoId) {
		Disponibility dispoManagedEntity = DispoRepository.findById((long) DispoId).get();
		User userManagedEntity = UserRepository.findById((long) userId).get();
		return null;
	}

	@Override
	public Disponibility editdispo(Long dispoId, Date date, String periode) {
		Disponibility disp= DispoRepository.findById(dispoId).get();
		disp.setDate(date);
		disp.setPeriode(periode);
		return DispoRepository.save(disp);
		
	}
	

}
