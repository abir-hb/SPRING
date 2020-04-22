package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.services.IUserDispoService;


@Controller
public class IUserDispoControllerImpl {
	@Autowired
	 IUserDispoService iuserdispo;
	
	@Autowired
	IUserDispoService disp;

	public String ajouterUserDispo(long UserId, long DispoId) {
		
		return disp.ajouterUserDispo(UserId, DispoId);
	}
	public String ajouterUserDispoUrgent(long UserId, long DispoId) {
		
		return disp.ajouterUserDispoUrgent(UserId, DispoId);
	}
	
}
