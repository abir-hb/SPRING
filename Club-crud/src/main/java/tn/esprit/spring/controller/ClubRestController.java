package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.service.IClubService;

@RestController
public class ClubRestController {

	
	@Autowired
	IClubService clubService;
	
	
	// http://localhost:8081/SpringMVC/servlet/
		@RequestMapping("/")
		@ResponseWrapper
			public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web Services REST."; }
		
		
		
		// URL : http://localhost:8081/SpringMVC/servlet/all-club
		@GetMapping("/all-club")
		@ResponseBody
		public List<Club> getClub() {
			List<Club> list = clubService.getAllClub();
			return list;
		}
		
		
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-club
		@PostMapping("/add-club")
		@ResponseBody
		public Club addClub(@RequestBody Club c) {
			Club club = clubService.addClub(c);
			return club;
		};

//		// Supprimer User : http://localhost:8081/SpringMVC/servlet/
	// delete-club/{club-id}
		@DeleteMapping("/delete-club/{club-id}")
		@ResponseBody
		public void deleteUser(@PathVariable("club-id") long id) {
		clubService.deleteClub(id);
		}
		
		
		// Modifier User 
		// http://localhost:8081/SpringMVC/servlet/modify-club
		@PutMapping("/modify-club")
		@ResponseBody 
		public Club updateClub(@RequestBody Club club) 
		{ 
			return clubService.updateClub(club); }
		
		
		// rechercher club  
		// http://localhost:8081/SpringMVC/servlet/rechercher/nom
		@GetMapping(value = "/rechercher/{nom}")
		public Optional<Club> findByNom(@PathVariable("nom") String nom){
			return clubService.findByNom(nom);
		}


}
