package tn.esprit.spring.controllers;

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

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.services.IEmployeService;

@RestController
@RequestMapping("/crud")
public class CrudRestController {
	@Autowired 
	private IEmployeService iEmployeService;
	
	@PostMapping("/add-user")
	@ResponseBody
	public Employe addUser(@RequestBody Employe u) {
		Employe user = iEmployeService.addUser(u);
		return user;
	}
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<Employe> getAllUsers() {
		List<Employe> list =iEmployeService.getAllEmployes();
		return list;
	}
	@DeleteMapping("/delete-user/{user-id}")
	@ResponseBody
	public void deleteUser(@PathVariable("user-id")int id) {
		iEmployeService.deleteEmploye(id);
	}
	@PutMapping("/modify-user")
	@ResponseBody
	public Employe updateUser(@RequestBody Employe e) {
		return iEmployeService.updateEmployes(e);

	 }
}
