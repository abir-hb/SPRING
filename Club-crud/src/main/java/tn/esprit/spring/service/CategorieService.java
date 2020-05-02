package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Categorie;

import tn.esprit.spring.repository.CategorieRepository;


@Component
public class CategorieService implements ICategorieService{

	@Autowired
	CategorieRepository categorieRepository;
	
	
	@Override
	public Categorie addCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);

	}
	
	@Override
	public void deleteCategorie(long idc) {
		categorieRepository.deleteById(idc);

	}

	@Override
	public List<Categorie> getAllCategorie() {
		return (List<Categorie>) categorieRepository.findAll();
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}
	
	
}
