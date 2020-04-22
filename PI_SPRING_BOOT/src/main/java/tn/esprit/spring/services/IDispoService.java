package tn.esprit.spring.services;

import java.sql.Date;
import java.util.List;

import tn.esprit.spring.entities.Disponibility;

public interface IDispoService {
	Disponibility addDispo(Disponibility dispo);
	public String AffecterDispo(Long UserId,Long DispID);
	public Disponibility editdispo(Long dispoId,String date,String periode );
	void deleteDispo(Long DispoId);
	List<Disponibility> getAllDispo();
	//public String AjouterDispoUser(Long user, Long Dispo);
	String ajouterUserDispo(long UserId, long DispoId);
	public List<String> findMyDispnibite(Long UserId);

}
