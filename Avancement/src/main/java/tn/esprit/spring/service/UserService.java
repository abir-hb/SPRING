package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.InscriptionRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;

@Component
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	InscriptionRepository inscriptionRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public List<Inscription> getInscriptionsByClub(User user, Club club) {
		return inscriptionRepository.getInscriptionsByClub(user, club);
	}

}