package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IClubService;
import tn.esprit.spring.service.IInscriptionService;
import tn.esprit.spring.service.IUserService;


@RestController
public class InscriptionRestController {
	
	
	@Autowired
	IUserService userservice;
	@Autowired
	IClubService clubservice;
	@Autowired
	IInscriptionService inscriptionservice;
	
	
	// http://localhost:8081/SpringMVC/servlet/ajouterInscription
    //{"clubId":1,"userId":2,}
	
	@PostMapping("/ajouterInscription/{idclub}/{iduser}")
	@ResponseBody
	public void ajouterInscription(@PathVariable("idclub") int clubId, @PathVariable("iduser") int userId) {
		inscriptionservice.ajouterInscription(clubId, userId);
		
		
}
	
	// URL : http://localhost:8081/SpringMVC/servlet/findAllClubByUserJPQL/1
    @GetMapping(value = "findAllClubByUserJPQL/{iduser}")
    @ResponseBody
	public List<Club> findAllClubByUserJPQL(@PathVariable("iduser") int userId) {

		return inscriptionservice.findAllClubByUserJPQL(userId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllUserByClub/1
    @GetMapping(value = "getAllUserByClub/{idclub}")
    @ResponseBody
	public List<User> getAllUserByClub(@PathVariable("idclub") int clubId) {

		return inscriptionservice.getAllUserByClub(clubId);

    }
 // URL : http://localhost:8081/SpringMVC/servlet/all
 	@GetMapping("/all-inscri")
 	@ResponseBody
 	public List<Inscription> getAllInscription() {
 		List<Inscription> list = inscriptionservice.getAllInscription();
 		return list;
 	}
 	
 	

}
