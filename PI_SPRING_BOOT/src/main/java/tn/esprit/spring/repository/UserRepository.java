package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("select u from User u where u.lastname=:nom")
	List<User> getUsersByLastname(@Param("nom") String lastName);
	
	@Query("select u from User u where u.firstname=:prenom")
	List<User> getUsersByFirstname(@Param("prenom")String firstName);
	
	@Query("select max(u.id) from User u")
	Long getMaxId();
	
	
	
//
//	@Query("SELECT DISTINCT t1.* FROM User t1 JOIN User t2 ON t1.LAST_NAME = t2.LAST_NAME AND t1.id <> t2.id ORDER BY t1.LAST_NAME")
//	public List<User> UserLast();
//	
//	@Query("SELECT DISTINCT t1.* FROM User t1 JOIN User t2 ON t1.FIRST_NAME = t2.FIRST_NAME AND t1.id <> t2.id ORDER BY t1.FIRST_NAME")
//	public List<User> UserFirst();
//	
//	
//	@Query("SELECT MAX(u.id), 0) FROM User u")
//	Long getMaxId();
}
