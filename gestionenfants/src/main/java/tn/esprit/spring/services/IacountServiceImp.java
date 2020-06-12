package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
@Service
public class IacountServiceImp implements IacountService {
	@Autowired
	private UserRepository userRepository ;

	@Override
	public User addUser(User employe) {
		
		return userRepository.save(employe);
	}


	

	


	@Override
	public void updateUser(User e) {
		userRepository.save(e);
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> emp = (List<User>) userRepository.findAll(); 
		return emp;
		
	}

	@Override
	public void deleteUSer(long employeid) {
		userRepository.deleteById(employeid);
		
	}

}
