package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Materiel;


public interface IClubService {

	Club addClub(Club club);

	

	void deleteClub(int id);

	List<Club> getAllClub();

	Club updateClub(Club club);

	Optional<Club> findByNom(String nom);



	List<Materiel> getAllMateriel();
	
}