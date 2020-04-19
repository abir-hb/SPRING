package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT count(*) FROM User")
    public int countuser();
	
	 @Modifying
	 @Transactional
    @Query("UPDATE User e SET e.Connecte= true WHERE e.id =:userId")
    public void login(@Param("userId")Long userIdd);
	 
	 
	 @Modifying
	 @Transactional
    @Query("UPDATE User e SET e.Connecte= false WHERE e.id =:userId")
    public void logout(@Param("userId")Long userIdd);  
	 /*
	 @Query("SELECT u.id from User where u.id=:userId")
	    public Long findUserByID(@Param("userId")Long userIdd);
	 
	 */
	 @Query("SELECT c.id from Chatroom c join c.userrr u where u.id=:userId")
	    public Long findUserRoom(@Param("userId")Long userIdd);
}
