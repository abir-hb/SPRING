package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Inscription;

import tn.esprit.spring.entity.User;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Integer>{

	@Query("select DISTINCT c from Club c join c.inscriptions i join i.user u where u.id=:userId")
	public List<Club> findAllClubByUserJPQL(@Param("userId")int userId);
	
	@Query("select DISTINCT u from User u "
			+ "join u.inscriptions i "
			+ "join i.club c "
			+ "where c.id=:cisId")
public List<User> getAllUserByClub(@Param("cisId")int clubId);
	
	
	

	@Query("Select i from Inscription i "
				+ "where i.club=:cis and "
				+ "i.user=:us"
				//+ "i.timesheetPK.dateDebut>=:dateD and "
			//	+ "t.timesheetPK.dateFin<=:dateF")
				)
	public List<Inscription> getInscriptionsByClub(@Param("us")User user, @Param("cis")Club club);

	//  public Inscription findByinscriptionPK(InscriptionPK inscriptionPK);
}
