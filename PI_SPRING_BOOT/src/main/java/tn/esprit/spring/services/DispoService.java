package tn.esprit.spring.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.Disponibility;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.UserDispo;
import tn.esprit.spring.repository.DisponibilityRepository;
import tn.esprit.spring.repository.UserRepository;


@Component
public class DispoService implements IDispoService {
	private static final String idd = null;
	@Autowired
	DisponibilityRepository DispoRepository;
	@Autowired
	DisponibilityRepository dd;
	@Autowired
	DisponibilityRepository Dispo;
	@Autowired
	UserRepository UserRepository;
	@Autowired
	UserRepository usss;
	@Autowired
	UserRepository usser;
	
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
		dd.deleteById(DispoId);
	}
	/*
	@Transactional
	@Override
	public String AjouterDispoUser(int userId, int DispoId) {
		Disponibility dispoManagedEntity = DispoRepository.findById((long) DispoId).get();
		User userManagedEntity = UserRepository.findById((long) userId).get();
		dispoManagedEntity.setUser(userManagedEntity);
		DispoRepository.save(dispoManagedEntity);
		return null;
	}
*/
	@Transactional
	@Override
	public Disponibility editdispo(Long dispoId, String date, String periode) {
		Disponibility disp= DispoRepository.findById(dispoId).get(); 
		 Date dateString=Date.valueOf(date);//converting string into sql date  
		disp.setDate(dateString);
		disp.setPeriode(periode);
		return DispoRepository.save(disp);
		
	}
	@Transactional
	@Override
	public String AffecterDispo(Long UserId, Long DispID) {
		
		User u=usss.findById(UserId).get();
		Disponibility d =Dispo.findById(DispID).get();
		
		d.setUser(u);
		Dispo.save(d);
		
		return "Vous avez ajouter votr dispo";
	}
	
	@Transactional
	@Override
 	public String ajouterUserDispo(long UserId, long DispoId) {
		/*
		User user =usser.findById(UserId).get();
		Disponibility d =DispoRepository.findById(DispoId).get();
		d.setUser(user);
		DispoRepository.save(d);
		*/
		return "Dispo ajoute avec success";
	}

	@Override
	public List<String> findMyDispnibite(Long UserId) {
		User user =usser.findById(UserId).get();
		List<Disponibility> list = new ArrayList<>();
		list = DispoRepository.FindMyDisponi(user);
		List<String>listall = new ArrayList<>();
		for (Disponibility disponibility : list) {
			Date d = disponibility.getDate();
			String s =disponibility.getPeriode();
			User uso =disponibility.getUser();
			listall.add(d.toString());
			listall.add(s);
			listall.add(uso.getFirstname() + uso.getLastname() + " Id " + uso.getId());	
		}
		return listall;
	}


 
}
