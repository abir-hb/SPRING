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
import tn.esprit.spring.entity.Materiel;
import tn.esprit.spring.service.ClubService;
import tn.esprit.spring.service.IClubService;

@RestController
public class ClubRestController {

	
	@Autowired
	IClubService clubService;
	@Autowired
	ClubService materielService;
	
	
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
		
		
		@GetMapping("/all-materiels")
		@ResponseBody
		public List<Materiel> getMateriel() {
			List<Materiel> list = materielService.getAllMateriel();
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
		public void deleteUser(@PathVariable("club-id") int id) {
		clubService.deleteClub(id);
		}
		
		
		// Modifier User 
		// http://localhost:8081/SpringMVC/servlet/modify-club
		@PutMapping("/modify-club")
		@ResponseBody 
		public Club updateClub(@RequestBody Club club) 
		{ 
			return clubService.updateClub(club); }
		
		@PutMapping("/modify-mat")
		@ResponseBody 
		public Materiel updateMateriel(@RequestBody Materiel materiel) 
		{ 
			return materielService.updateMateriel(materiel); }
		
		
		
		
		
		// rechercher club  
		// http://localhost:8081/SpringMVC/servlet/rechercher/nom
		@GetMapping(value = "/rechercher/{nom}")
		public Optional<Club> findByNom(@PathVariable("nom") String nom){
			return clubService.findByNom(nom);
		}
		
		 // http://localhost:8081/SpringMVC/servlet/ajouterMateriel
	 	//{"id":1,"name":"Telecom"}

	 	@PostMapping("/ajouterMateriel")
	 	@ResponseBody
		public Materiel ajouterMateriel(@RequestBody Materiel Ma) {
			Materiel materiel=materielService.ajouterMateriel(Ma);
			return materiel;
		}
	 	
	 	
	 
	 // http://localhost:8081/SpringMVC/servlet/affecterMaterielAClub/1/1
	    @PutMapping(value = "/affecterMaterielAClub/{idmateriel}/{idclub}") 
		public void affecterMaterielAClub(@PathVariable("idmateriel")int MaId, @PathVariable("idclub")int clubId) {
			materielService.affecterMaterielAClub(MaId, clubId);
		}
	     
	 // Modifier email : http://localhost:8081/SpringMVC/servlet/modifyDate/1
		@PutMapping(value = "/modifyDate/{id}") 
		@ResponseBody
		public void  mettreAjourMaterielByMaId( @PathVariable("id") int maId) {
			materielService.mettreAjourMaterielByMaId( maId);
			
		}
	    @GetMapping(value = "getAllMaterielsNamesByClub/{idclub}")
	    @ResponseBody
		public List<String> getAllMaterielsNamesByClub(@PathVariable("idclub") int clubId) {
			return materielService.getAllMaterielsNamesByClub(clubId);
		}
	 	
	    
	 // URL : http://localhost:8081/SpringMVC/servlet/deleteMaterielById/3
	    @DeleteMapping("/deleteMaterielById/{idmateriel}") 
		@ResponseBody 
		public void deleteMaterielById(@PathVariable("idmateriel") int MaId) {
			materielService.deleteMaterielById(MaId);

		}
	    
		/*// ajouter image  
		// http://localhost:8081/SpringMVC/servlet/upload

		@PostMapping("/upload")
			@ResponseBody
			@RequestMapping(value="/upload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
			public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
				File convertFile=new File("C:\\PDEV\\Club"+file.getOriginalFilename());
				convertFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(convertFile);
				fout.write(file.getBytes());
				fout.close();
				return new ResponseEntity<>("File is uploaded successfully",HttpStatus.OK);
			*/
			//}


}
