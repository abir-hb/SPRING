package tn.esprit.spring.controller;

import java.util.List;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;

public interface IDispoControl {
	Disponibility addDispo(Disponibility dispo);
	String deleteDispo(Long DispoId);
	List<Disponibility> getAllDispo();
	//public void AjouterDispoUser(Long user,Long Dispo);
	public String ajouterUserDispo(Long userId,Long DispoId);
	public List<String> findMyDispnibite(Long UserId);
}
