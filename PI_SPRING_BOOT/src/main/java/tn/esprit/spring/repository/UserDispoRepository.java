package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.UserDispo;

public interface UserDispoRepository extends CrudRepository<UserDispo, Long> {
	 //@Query("select c.salaire from Contrat c join c.employe e where e.id=:employeId")
	 /*
	@Modifying
    @Transactional
	@Query("UPDATE User u SET u.chatroom=NULL where u.id=:userId")
    public void KickUser(@Param("userId")Long userId);
    */
}
