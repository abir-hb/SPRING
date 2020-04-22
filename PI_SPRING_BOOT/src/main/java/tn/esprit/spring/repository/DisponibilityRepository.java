package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;


public interface DisponibilityRepository extends CrudRepository<Disponibility, Long> {
	@Query("select u from Disponibility u where u.user=:userId")
    public List<Disponibility> FindMyDisponi(@Param("userId")User userId);
	

}
