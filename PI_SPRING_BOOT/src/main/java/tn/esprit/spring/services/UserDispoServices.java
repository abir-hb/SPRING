package tn.esprit.spring.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	Logger logger = LoggerFactory.getLogger(ChatRoomService.class);

	@Override
	public String ajouterUserDispo(long UserId, long DispoId) {
		User u1 =userRepository.findById(UserId).get();
		Disponibility d = dispRepository.findById(DispoId).get();
			if(u1.getRole().equals("DOCTOR")) {
			return "Vous etes medecin vous ne pouvez pas prendre un rendez vous";
		}
		else {
			logger.info("Date ajourdhui" +d.getDate().toString());
			java.sql.Date dayavant = this.addDays(d.getDate(), -1);
			logger.info("Date avant ajourdhui" +dayavant);
			
			//CONVERSION DATE TODAY
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new java.util.Date());
			logger.info("Date  TODAY" +date.toString());
			
			if(dayavant.toString().equals(date.toString())) {
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
	}
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
		
		}
	}
	@Override
	public String ajouterUserDispoUrgent(long UserId, long DispoId) {
		User u1 =userRepository.findById(UserId).get();
		Disponibility d = dispRepository.findById(DispoId).get();
		UserDispo userdisp = dispRep.findById(DispoId).get();
		
		if(u1.getRole().equals("DOCTOR")) {
			return "Vous etes medecin vous ne pouvez pas prendre un rendez vous";
		}
		else {
		if (userdisp.getCas().equals("NOT URGENT")){
			dispRep.delete(userdisp);
		}
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
		}
	
	}
	//FONCTION POUR AJOUTER OU SUPPRIMER UN JOUR DE LA DATE
	 public static Date addDays(Date date, int days) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(date);
	        c.add(Calendar.DATE, days);
	        return new Date(c.getTimeInMillis());
	    }
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
/*
	@Override
	public String ajouterUserDispoUrgent(long UserId, long DispoId) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
