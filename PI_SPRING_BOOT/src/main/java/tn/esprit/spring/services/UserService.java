package tn.esprit.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;



@Component
public class UserService implements IUserService {

private static final String idd = null;
@Autowired
UserRepository userRepository;

@Override
public User addUser(User user) {
	return userRepository.save(user);
}

@Override
public String getFirstNameByUserId(Long userId) {
	return userRepository.findById(userId).get().getFirstname().toString();
}

@Override
public String getLastNameByUserId(Long userId) {
	return userRepository.findById(userId).get().getLastname();
}

@Override
public void deleteUser(Long userId) {
	userRepository.deleteById(userId);
}

@Override
public List<User> getAllUsers() {
	return (List<User>)userRepository.findAll();
}

@Override
public void updateUser(Long id, String firstname, String lastname) {
	User userr = userRepository.findById(id).get();
	userr.setFirstname(firstname);
	userr.setLastname(lastname);
	userRepository.save(userr);
}

@Override
public int getNombreUserJPQL() {
	return userRepository.countuser();
}
	
}