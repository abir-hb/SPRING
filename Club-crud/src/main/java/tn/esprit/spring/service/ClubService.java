package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Club;

import tn.esprit.spring.repository.ClubRepository;

@Component
public class ClubService implements IClubService {

	@Autowired
	ClubRepository clubRepository;

	@Override
	public Club addClub(Club club) {
		return clubRepository.save(club);

	}

	@Override
	public String getFirstNameByClubId(Long clubId) {
		return clubRepository.findById(clubId).get().getNom().toString();
	}

	@Override
	public void deleteClub(long id) {
		clubRepository.deleteById(id);

	}

	@Override
	public List<Club> getAllClub() {
		return (List<Club>) clubRepository.findAll();
	}

	@Override
	public Club updateClub(Club club) {
		return clubRepository.save(club);
	}

	public Optional<Club> findByNom(String nom) {

		return clubRepository.findByNom(nom);
	}

}