package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.services.IDispoService;
import tn.esprit.spring.services.IUserService;

@Controller
public class DispoController implements IDispoControl {
	@Autowired
	IDispoService DispoService;
	
	@Override
	public Disponibility addDispo(Disponibility dispo) {
		
		return DispoService.addDispo(dispo);
	}

	@Override
	public List<Disponibility> getAllDispo() {
		return DispoService.getAllDispo();
	}

	@Override
	public String deleteDispo(Long DispoId) {
		 DispoService.deleteDispo(DispoId);
		return null;
	}

	
	public String AffecterDispo(Long UserId, Long DispID) {
		return DispoService.AffecterDispo(UserId, DispID);
	}

	@Override
	public String ajouterUserDispo(Long userId, Long DispoId) {
		
		return DispoService.ajouterUserDispo(userId, DispoId);
	}

	@Override
	public List<String> findMyDispnibite(Long UserId) {
		return DispoService.findMyDispnibite(UserId);
	}
	//this is the last 
	
}
