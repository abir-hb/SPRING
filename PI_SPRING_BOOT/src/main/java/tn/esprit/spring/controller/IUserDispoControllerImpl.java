package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.UserDispoKey;
import tn.esprit.spring.services.IDispoService;
import tn.esprit.spring.services.IUserDispoService;
import tn.esprit.spring.services.IUserService;

@Controller
public class IUserDispoControllerImpl {
	@Autowired
	IUserDispoService iuserDispoService;
	@Autowired
	IUserService iuserservice;
	@Autowired
	IDispoService idisposervice;
	
	public void ajouterUserDispo(long UserId, long DispoId) {
		iuserDispoService.ajouterUserDispo(UserId, DispoId);
	}
	/*
		public void deleteUserdispo(Long userdispo) {
			//UserDispoKey = new UserDispoKey(1, 15);
			iuserDispoService.de
			deletedispp
			
		}
		*/
}
