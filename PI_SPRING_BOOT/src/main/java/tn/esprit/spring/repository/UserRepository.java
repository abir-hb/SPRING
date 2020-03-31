package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT count(*) FROM User")
    public int countuser();
}
