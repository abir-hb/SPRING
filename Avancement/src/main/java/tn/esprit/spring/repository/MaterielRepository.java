package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Materiel;



@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Integer>{

	/* @Modifying
	    @Transactional
	    @Query("UPDATE Materiel e SET e.disponibilite=:true where e.id=:clubId")
	    public void affecterMaterielAClub(@Param("clubId")int clubId);
*/
	    
	 @Modifying
	    @Transactional
	    @Query("UPDATE Materiel e SET e.disponibilite=:false where e.id=:maId")
	 public void updateMateriel(@Param("maId")int maId);
}
