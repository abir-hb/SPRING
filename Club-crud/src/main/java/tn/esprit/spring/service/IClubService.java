package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Club;


public interface IClubService {

	Club addClub(Club club);

	String getFirstNameByClubId(Long clubId);

	void deleteClub(long id);

	List<Club> getAllClub();

	Club updateClub(Club club);

	Optional<Club> findByNom(String nom);
	
}