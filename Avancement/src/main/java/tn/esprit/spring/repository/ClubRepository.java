package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Club;



public interface ClubRepository extends JpaRepository<Club, Integer> { 
	
	Optional<Club> findByNom(String nom);

}
