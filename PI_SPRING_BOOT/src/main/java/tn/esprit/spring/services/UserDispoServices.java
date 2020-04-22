package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.UserDispo;
import tn.esprit.spring.repository.DisponibilityRepository;
import tn.esprit.spring.repository.UserDispoRepository;
import tn.esprit.spring.repository.UserRepository;
@Component
public class UserDispoServices implements IUserDispoService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DisponibilityRepository dispRepository;
	@Autowired
	UserDispoRepository dispRep;
	@Override
	public String ajouterUserDispo(long UserId, long DispoId) {
		User u1 =userRepository.findById(UserId).get();
		Disponibility d = dispRepository.findById(DispoId).get();
		/*
		if(u1.getRole().equals("DOCTOR")) {
			return "Vous etes medecin vous ne pouvez pas prendre un rendez vous";
		}
		else {
		*/
		dispRepository.delete(d);
		Long us_id=UserId;
		us_id.toString();
		Long Dispo = DispoId;
		UserDispo usrdispo = new UserDispo();
		usrdispo.setCas("NOT URGENT");
		//usrdispo.setPatient(us_id.toString());
		usrdispo.setDispo_id(Dispo.toString());
		usrdispo.setUserDispo(u1);
		dispRep.save(usrdispo);
		return "Dispo bien ajouter";
	//}
	}
	/*
	public String ajouterUserDispoUrgent(long UserId, long DispoId) {
		User u1 =userRepository.findById(UserId).get();
		Disponibility d = dispRepository.findById(DispoId).get();
		/*
		if(u1.getRole().equals("DOCTOR")) {
			return "Vous etes medecin vous ne pouvez pas prendre un rendez vous";
		}
		else {
		
		dispRepository.delete(d);
		Long us_id=UserId;
		us_id.toString();
		Long Dispo = DispoId;
		UserDispo usrdispo = new UserDispo();
		usrdispo.setCas("URGENT");
		usrdispo.setDispo(false);
		//usrdispo.setPatient(us_id.toString());
		usrdispo.setDispo_id(Dispo.toString());
		usrdispo.setUserDispo(u1);
		dispRep.save(usrdispo);
		return "Dispo bien ajouter";
		*/
	
	//}

	@Override
	public void deleteuserdispo(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String reserverRendezVous(Long UserId, String Cas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletemydispo(Long UserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String ajouterUserDispoUrgent(long UserId, long DispoId) {
		// TODO Auto-generated method stub
		return null;
	}

}
