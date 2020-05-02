package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Categorie;

public interface ICategorieService {

	Categorie addCategorie(Categorie categorie);

	void deleteCategorie(long idc);

	List<Categorie> getAllCategorie();

	Categorie updateCategorie(Categorie categorie);

}
