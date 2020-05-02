package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Club;



public interface ClubRepository extends CrudRepository<Club, Long> { 
	
	Optional<Club> findByNom(String nom);

}
