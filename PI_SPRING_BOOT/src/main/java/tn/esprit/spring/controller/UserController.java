package tn.esprit.spring.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IUserService;

@Controller
public class UserController implements IUserControl{
	@Autowired
	IUserService userService;

	@Override
	public User addUser(User user) {
		return userService.addUser(user);
	}

	@Override
	public String getFirstNameByUserId(Long userId) {
		return userService.getFirstNameByUserId(userId);
	}

	@Override
	public String getLastNameByUserId(Long userId) {
		return userService.getLastNameByUserId(userId);
	}

	@Override
	public void deleteUser(Long userId) {
		userService.deleteUser(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@Override
	public void updateUser(Long id, String firstname, String lastname) {
		 userService.updateUser(id, firstname, lastname);
	}

	@Override
	public int getNombreUserJPQL() {
		return userService.getNombreUserJPQL();
	}
	@Override
	 public String login(Long userId) {
		userService.login(userId);
		return null;
	}
	@Override
	 public String logout(Long userId) {
		userService.login(userId);
		return null;
	}
	@Override
	 public void KickUser(Long userId) {
		userService.KickUser(userId);
	}
	
	public Long findUserRoom(Long UserId) {
		return userService.findUserRoom(UserId);
	}

	
	
	
}