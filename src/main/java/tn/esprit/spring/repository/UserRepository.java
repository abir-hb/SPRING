package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT count(*) FROM User")
    public int countuser();

}
