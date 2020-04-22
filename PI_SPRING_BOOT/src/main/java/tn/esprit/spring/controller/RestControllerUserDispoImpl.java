package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

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

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.services.IDispoService;
import tn.esprit.spring.services.IUserDispoService;



@RestController
public class RestControllerUserDispoImpl {
	@Autowired
	IDispoService DispoService;
	@Autowired
	IDispoService da;
	@Autowired
	IDispoService ds;
	
	
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
	@GetMapping("/retrieve-all-disponib")
	@ResponseBody
	public List<Disponibility> getAllDispo() {
	List<Disponibility> list = DispoService.getAllDispo();
	return list;
	}
	@DeleteMapping("/delete-d/{dispo-id}")
	@ResponseBody
	public void deleteDispo(@PathVariable("dispo-id") long dispoId) {
		ds.deleteDispo(dispoId);
		//return "La disponiblité N "+dispoId+" est supprimé";
	}
	@PutMapping("/edit-dispo/{dispoId}/{date}/{periode}")
	@ResponseBody
	public Disponibility editdispo(@PathVariable("dispoId")Long dispoId,@PathVariable("date")String date,@PathVariable("periode")String periode) {
		 Disponibility disp =DispoService.editdispo(dispoId,date, periode);
		 return disp;	
	}
	@PutMapping("/Addmydispo/{UserId}/{DispoId}")
	@ResponseBody
	public String ajouterUserDispo(@PathVariable("UserId")long userId,@PathVariable("DispoId") long dispoId) {
		return	da.AffecterDispo(userId, dispoId);
	}
	
	@GetMapping("/GetMydispo/{UserId}")
	@ResponseBody
	public List<String> findMyDispnibite(@PathVariable("UserId")Long UserId){ 
	return DispoService.findMyDispnibite(UserId);
	}

}
