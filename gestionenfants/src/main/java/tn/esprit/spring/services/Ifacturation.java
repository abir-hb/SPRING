package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Compte;

public interface Ifacturation {
	public void addCompte(Compte c);
	public List<Compte> getAllComptes();
	public Compte getCompte(Long code);
	public void verser (double mt,Long code);
	public void retirer (double mt,Long code);
	public void virement (double mt,Long cpt1,Long cpt2);
	public void updateCompte(Compte c);
	public void suprimerCompte(Long code);

}
