package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.User;

public interface IInscriptionService {
	
	public void ajouterInscription(int clubId, int userId);
	public List<Club> findAllClubByUserJPQL(int userId);
	public List<User> getAllUserByClub(int clubId);
	List<Inscription> getAllInscription();

}
