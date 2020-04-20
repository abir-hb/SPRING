package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.User;

public interface IUserService {
	User addUser(User user);
	List<User> getAllUsers();
	String getFirstNameByUserId(Long userId);
	String getLastNameByUserId(Long userId);
	void deleteUser(Long userId);
	public void updateUser(Long id, String firstname, String lastname);
	public String getNombreUserJPQL();
	 public String login(Long userId);
	public String logout(Long userId);
	public void KickUser(Long UserId);
	public Long findUserRoom(Long UserId);
}
