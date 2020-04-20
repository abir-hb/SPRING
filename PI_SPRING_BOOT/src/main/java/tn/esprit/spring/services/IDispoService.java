package tn.esprit.spring.services;

import java.sql.Date;
import java.util.List;

import tn.esprit.spring.entities.Disponibility;

public interface IDispoService {
	Disponibility addDispo(Disponibility dispo);
	public Disponibility editdispo(Long dispoId,Date date,String periode );
	void deleteDispo(Long DispoId);
	List<Disponibility> getAllDispo();
	public String AjouterDispoUser(int user, int Dispo);

}
