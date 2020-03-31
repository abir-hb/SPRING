package tn.esprit.spring.controller;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entities.User;

public interface IUserControl {
	User addUser(User user);
	List<User> getAllUsers();
	String getFirstNameByUserId(Long userId);
	String getLastNameByUserId(Long userId);
	void deleteUser(Long userId);
	public void updateUser(Long id, String firstname, String lastname);
	public int getNombreUserJPQL();
}
