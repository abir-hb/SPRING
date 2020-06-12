package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;
@Repository

public interface StatistcRepository extends JpaRepository<User, Long> {
	@Query("select count (*) , YEAR(u.dateInscription) from User u group by YEAR(u.dateInscription) ")
    public List<?> listUser();

	@Query("select count (u) , YEAR(u.dateInscription) , MONTH(u.dateInscription) from User u group by YEAR(u.dateInscription), MONTH(u.dateInscription) ")
    public List<?> listMois1();
	@Query("select  e.jardin.nom, count (*) from Enfant e group by e.jardin")  
    public List<?> listEnfantParJardin();
	@Query("select Max(u.score), u.username from User u")  
    public List<?> BestUser();
	
	@Query("SELECT u FROM User u")
	List <User> getUserList();
	
	@Query("SELECT count(*) FROM Enfant e where e.jardin.id =:jardinid ")  
	public int nbEnfantParJardin(@Param ("jardinid") Long jardinid);
	
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2020 and e.jardin.id =:jardinid")
    public int NbUser2020(@Param ("jardinid") Long jardinid);
	
	@Query("select count (*) from Enfant e where YEAR(e.user.dateInscription)=2019 and e.jardin.id =:jardinid")
    public int NbUser2019(@Param ("jardinid") Long jardinid);
	
}
