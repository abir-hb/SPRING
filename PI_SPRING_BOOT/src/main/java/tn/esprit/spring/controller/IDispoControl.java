package tn.esprit.spring.controller;

import java.util.List;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;

public interface IDispoControl {
	Disponibility addDispo(Disponibility dispo);
	List<Disponibility> getAllDispo();

}
