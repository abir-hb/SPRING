package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ClubRepository;
import tn.esprit.spring.repository.InscriptionRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.entity.Club;
@Component
public class InscriptionService implements IInscriptionService{

	

	@Autowired
	ClubRepository clubRepository;
	
	@Autowired
	InscriptionRepository inscriptionRepository;
	@Autowired
	UserRepository userRepository;
	


	public void ajouterInscription(int clubId, int userId) {
		
		Club club = clubRepository.findById(clubId).get();
		long nb=club.getNbm();
	
		Inscription inscription = new Inscription();
		if(nb!=0) {
			inscription.setClub(clubRepository.getOne(clubId));
	     	inscription.setUser(userRepository.getOne(userId));
	     
	     	nb=nb-1;
			club.setNbm(nb);
			inscriptionRepository.save(inscription);
			
		}else {
			if(nb==0) {
				System.out.println("le nombre de participants est maximal");
				return;
			}
			
		}
		
     	
     	
		
		
	}
	
	
	
	@Override
	public List<Inscription> getAllInscription() {
		return (List<Inscription>) inscriptionRepository.findAll();
	}

	
	
	
	public List<Club> findAllClubByUserJPQL(int userId) {
		return inscriptionRepository.findAllClubByUserJPQL(userId);
	}

	
	public List<User> getAllUserByClub(int clubId) {
		return inscriptionRepository.getAllUserByClub(clubId);
	}
}
