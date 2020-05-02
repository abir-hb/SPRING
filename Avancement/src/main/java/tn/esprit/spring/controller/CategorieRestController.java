package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Categorie;

import tn.esprit.spring.service.ICategorieService;
@RestController
public class CategorieRestController {
	
	@Autowired
	ICategorieService categorie_service;
	
	
	
	

	// URL : http://localhost:8081/SpringMVC/servlet/all-categorie
	@GetMapping("/all-categorie")
	@ResponseBody
	public List<Categorie> getCategorie() {
		List<Categorie> list = categorie_service.getAllCategorie();
		return list;
	}
	
	// Ajouter categorie : http://localhost:8081/SpringMVC/servlet/add-categorie
			@PostMapping("/add-categorie")
			@ResponseBody
			public Categorie addCategorie(@RequestBody Categorie c) {
				Categorie categorie = categorie_service.addCategorie(c);
				return categorie;
			}
	
// Supprimer categorie : http://localhost:8081/SpringMVC/servlet/delete-categorie/{categorie-idc}
			
				@DeleteMapping("/delete-categorie/{categorie-idc}")
				@ResponseBody
				public void deleteCategorie(@PathVariable("categorie-idc ") long idc) {
				categorie_service.deleteCategorie(idc);
				}
				
		// Modifier categorie 
		// http://localhost:8081/SpringMVC/servlet/modify-categorie
				@PutMapping("/modify-categorie")
				@ResponseBody 
				public Categorie updateCategorie(@RequestBody Categorie categorie) 
				{ 
					return categorie_service.updateCategorie(categorie); }
				

}
