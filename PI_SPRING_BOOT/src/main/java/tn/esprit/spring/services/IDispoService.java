package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Disponibility;

public interface IDispoService {
	Disponibility addDispo(Disponibility dispo);
	List<Disponibility> getAllDispo();

}
