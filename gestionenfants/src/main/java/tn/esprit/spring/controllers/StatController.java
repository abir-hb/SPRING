package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.services.StatService;



@RestController
public class StatController {
	@Autowired
	StatService statService;
	//statistique nb des users par annÃ©e
	@GetMapping(value ="/retrieve-all-usersAnne")
	public List<?> getUser() {
	
	return statService.retrieveAllUser();}
	//statistique nb des users par mois
		@GetMapping(value ="/retrieve-all-usersMois")
		public List<?> getUserMois() {
		
		return statService.retrieveAllUserMois();

	}
		// nb des enfant par jardin
		@GetMapping(value ="/retrieve-EnfantParJardin")
		public List<?> getEnfantParJardin() {
		
		return statService.retrieveEnfantParJardin();

	}
		
		@GetMapping(value ="/bestUser")
		public List<?> getBestUser() {

		return statService.BestUser();

		}
		@RequestMapping(method = RequestMethod.PUT, value="/add-nbrEnfant-to-jardin")

		public void addNbEnfant() {
		 statService.addnbEnfantParJardin();
		 }

}
