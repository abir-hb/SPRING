package tn.esprit.spring.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IUserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping(value="/SpringMvc/servelet") au lieu des dernieres lignes dans proprieties 
public class UserRestController {

	@Autowired
	IUserService userService;




	// URL : http://localhost:8081/SpringMVC/servlet/all-users
	@GetMapping("/all-users")
	@ResponseBody
	public List<User> getUser() {
		List<User> list = userService.getAllUsers();
		return list;
	}


	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
		User user = userService.addUser(u);
		return user;
	};

//	// Supprimer User : http://localhost:8081/SpringMVC/servlet/
// delete-user/{user-id}
	@DeleteMapping("/delete-user/{user-id}")
	@ResponseBody
	public void deleteUser(@PathVariable("user-id") int id) {
	userService.deleteUser(id);
	}


	
	// Modifier User 
	// http://localhost:8081/SpringMVC/servlet/modify-user
	@PutMapping("/modify-user")
	@ResponseBody 
	public User updateUser(@RequestBody User user) 
	{ 
		return userService.updateUser(user); }



}