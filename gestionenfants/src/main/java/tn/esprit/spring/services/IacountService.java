package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface IacountService {
	 public User addUser(User employe);
	 public List<User> getAllUsers();
	 public void deleteUSer(long employeid) ;
	 public void updateUser(User e);

}
