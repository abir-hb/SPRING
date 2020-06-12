package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.Operation;
import tn.esprit.spring.entity.User;





public interface Ipaiment {
	 public Optional<Compte> consulterCompter(String codeCpte);
	    public void verser(String codeCpte , double montant);
	    public void reterait(String codeCpte , double montant);
	    public void verement(String codeCpte1 , String codeCpte2 , double montant);
	    public Page<Operation> listOperation(String codeCpte , int page , int size);
	    Optional<Compte> findById(String id);
	    public List<Compte> listComp();
	    public Compte addCompte(Compte  compte);
}
