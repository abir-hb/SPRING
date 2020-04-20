package tn.esprit.spring.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.UserDispo;
import tn.esprit.spring.entities.UserDispoKey;
import tn.esprit.spring.repository.DisponibilityRepository;
import tn.esprit.spring.repository.UserDispoRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class UserDispoImpl implements IUserDispoService {
	Logger logger = LoggerFactory.getLogger(UserDispoImpl.class);
	@Autowired
	UserDispoRepository userDispoRepository;
	@Autowired
	UserRepository userrep;
	@Autowired
	UserDispoRepository userdispo;
	@Autowired
	UserRepository user;
	@Autowired
	DisponibilityRepository disprep;
	@Override
	public String ajouterUserDispo(long UserId, long DispoId) {	
		try {
			UserDispoKey userkey = new UserDispoKey();
			User user =userrep.findById(UserId).get();
			Role role =user.getRole();
			logger.info(role.toString());
			if(role.toString()=="DOCTOR")
			{
			userkey.setUserId(UserId);
			userkey.setDispoId(DispoId);
			UserDispo userdispo = new UserDispo();
			userdispo.setId(userkey);
			userdispo.setDispo(true);
			userDispoRepository.save(userdispo);
			return "Vous avez ajouter une disponibilite avec success";
		}
			else {
				return "Vous devez etre un medecin pour ajouter des disponibilite";
			}
		} catch (Exception e) {
		return "Vous avez deja ajouter cette dispo";
		}
	
	}
	/*
	public void deleteuserdispo(Long userId,Long dispoId ) {
		Disponibility d = disprep.findById(dispoId).get();
		user
		userdispo.delete(disp);
		
		
	}*/
	@Override
	public void deleteuserdispo(Long userId) {		
	}


}
