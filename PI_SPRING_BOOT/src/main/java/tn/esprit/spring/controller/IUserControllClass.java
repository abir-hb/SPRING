package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;



@Controller
public class IUserControllClass {
	
	@Autowired
	IUserService iuserservice;
	
	public int getNombreUserJPQL() {
		
		return iuserservice.getNombreUserJPQL();
	}
	
public List<User> getAllUsers() {
		
		return iuserservice.getAllUsers();
	}

}
