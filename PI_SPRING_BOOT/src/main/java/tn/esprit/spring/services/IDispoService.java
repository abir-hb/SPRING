package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Disponibility;

public interface IDispoService {
	Disponibility addDispo(Disponibility dispo);
	String deleteDispo(Long DispoId);
	List<Disponibility> getAllDispo();
	public void AjouterDispoUser(int user, int Dispo);

}
