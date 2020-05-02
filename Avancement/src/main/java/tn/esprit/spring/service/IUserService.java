package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.User;

public interface IUserService {
	User addUser(User user);
	List<User> getAllUsers();
	

	 void deleteUser(int id) ;
	User updateUser(User user);
}
