package tn.esprit.spring.controller;

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


import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RestController
	public class UserRestControlImpl {
	@Autowired
	IUserService userService;
	// http://localhost:8080/SpringMVC/servlet/
	@RequestMapping("/")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à l'application de test des Web ServicesREST."; }
	// URL : http://localhost:8081/SpringMVC/servlet/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers() {
	List<User> list = userService.getAllUsers();
	return list;
	}
	// http://localhost:8081/SpringMVC/servlet/ retrieve-user /{user-id}
//	@GetMapping("/retrieve-user/{user-id}")
//	@ResponseBody
//	public User getEmployee(@PathVariable("user-id") String userId) {
//	return userService.getAllUsers();
//	}
	
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
	User user = userService.addUser(u);
	return user;
	}
	// Supprimer User : http://localhost:8081/SpringMVC/servlet/ delete-user/{user-id}
	@DeleteMapping("/delete-user/{user-id}")
	@ResponseBody
	public void deleteEmployee(@PathVariable("user-id") long userId) {
	userService.deleteUser(userId);
	}
	
	// URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
    @GetMapping(value = "/nb")
    @ResponseBody
	public int getNombreUserJPQL() {
		
		return userService.getNombreUserJPQL();
	}
 // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployes
 	@GetMapping(value = "/getall")
     @ResponseBody
 	public List<User> getAllUsers() {
 		
 		return userService.getAllUsers();
 	}
 	@PutMapping(value = "/login/{userId}") 
	@ResponseBody
	public String login(@PathVariable("userId") Long userIdd) {
 		 userService.login(userIdd);
 		 return "Vous etes connecte";
 		
 	}
	@PutMapping(value = "/logout/{userId}") 
	@ResponseBody
	public String logout(@PathVariable("userId") Long userIdd) {
 		 userService.logout(userIdd);
 		 return "Vous etes deconnecte";
 		
 	}
	@PutMapping(value = "/kick/{userId}") 
	@ResponseBody
	public String kickUser(@PathVariable("userId") Long userIdd) {
 		 userService.KickUser(userIdd);
 		 return "Vous avez bien kické l'utilisateur";
 		
 	}
	
	@PutMapping(value = "/findroom/{userId}") 
	@ResponseBody
	public Long findUserRoom(@PathVariable("userId") Long userIdd) {
		return userService.findUserRoom(userIdd);

 	}
	}

