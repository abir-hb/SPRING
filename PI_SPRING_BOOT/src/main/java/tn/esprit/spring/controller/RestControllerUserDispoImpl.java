package tn.esprit.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.IUserDispoService;



@RestController
public class RestControllerUserDispoImpl {
	@Autowired
	IUserDispoService userdispoService;
	
	
	//	public void ajouterUserDispo(int UserId, int DispoId);
	//@PostMapping("/ajouterTimesheet/idmission/idemp/dated/datef")
	//@PutMapping(value = "/affecterMissionADepartement/{idmission}/{iddept}") 
	@PutMapping(value = "/ajouterUserDispo/{disponibility_id}/{user_id}")
	public String ajouterUserDispo(@PathVariable("disponibility_id") long UserId, @PathVariable("user_id") long DispoId) {
		userdispoService.ajouterUserDispo(UserId, DispoId);
		return "ajouter avec success";
	}


}
