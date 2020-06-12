package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Compte;
@Service
public class IfacturationImpl implements Ifacturation{

	@Override
	public void addCompte(Compte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compte> getAllComptes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte getCompte(Long code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verser(double mt, Long code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirer(double mt, Long code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void virement(double mt, Long cpt1, Long cpt2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suprimerCompte(Long code) {
		// TODO Auto-generated method stub
		
	}

}
