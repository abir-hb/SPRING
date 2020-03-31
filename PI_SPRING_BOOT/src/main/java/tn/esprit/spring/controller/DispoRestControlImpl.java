package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IDispoService;
import tn.esprit.spring.services.IUserService;

@RestController
public class DispoRestControlImpl {
	@Autowired
	IDispoService DispoService;
	@RequestMapping("/Hi")
	@ResponseBody
	public String welcomehome() 
	{ 
		return "Hello ça marche !!"; 
	}
	
	
	@PostMapping("/add-dispo")
	@ResponseBody
	public Disponibility addDispo(@RequestBody Disponibility dispo) {
		Disponibility ddd = DispoService.addDispo(dispo);
	return ddd;
	}
	@GetMapping("/retrieve-all-dispo")
	@ResponseBody
	public List<Disponibility> getAllDispo() {
	List<Disponibility> list = DispoService.getAllDispo();
	return list;
	}
	@DeleteMapping("/delete-dispo/{dispo-id}")
	@ResponseBody
	public String deleteDispo(@PathVariable("dispo-id") long dispoId) {
		DispoService.deleteDispo(dispoId);
		return "La disponiblité N "+dispoId+" est supprimé";
	}
	
}
