package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.IUserDispoService;

@RestController
public class RestDispUserImpl {
	@Autowired
	IUserDispoService iuserdisposervice;
	
	@PutMapping(value = "/AddDispo/{UserId}/{DispoId}")
	public String ajouterUserDispo(@PathVariable("UserId")long UserId,@PathVariable("DispoId") long DispoId) {
		return	iuserdisposervice.ajouterUserDispo(UserId, DispoId);
}
	
	@PutMapping(value = "/AddDispoUrgent/{UserId}/{DispoId}")
	public String ajouterUserDispoUrgent(@PathVariable("UserId")long UserId,@PathVariable("DispoId") long DispoId) {
		return	iuserdisposervice.ajouterUserDispoUrgent(UserId, DispoId);
}
}
