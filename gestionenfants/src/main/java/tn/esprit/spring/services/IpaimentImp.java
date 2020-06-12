package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.CompteCourant;
import tn.esprit.spring.entity.Operation;
import tn.esprit.spring.entity.Retrait;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Versement;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.OperationRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
@Transactional
public class IpaimentImp implements Ipaiment {
	 @Autowired
	    public CompteRepository compteRepository;

	    @Autowired
	    public OperationRepository operationRepository;
	    @Autowired
	    public  UserRepository userRepository ;

	@Override
	public Optional<Compte> consulterCompter(String codeCpte) {
		Optional<Compte> cp = compteRepository.findById(codeCpte);
        if(cp==null) throw new RuntimeException("Compte Introuvable!");
        return cp;
		
	}

	@Override
	public void verser(String codeCpte, double montant) {
		if(findById(codeCpte).isPresent()){
	        Optional<Compte> cp = findById(codeCpte);
	        Versement v = new Versement(new Date() , montant, cp.get());
	        operationRepository.save(v);
	        cp.get().setSolde(cp.get().getSolde()+montant);
	        compteRepository.save(cp.get());}
	}

	@Override
	public void reterait(String codeCpte, double montant) {
		 Optional<Compte> cp = findById(codeCpte);

	        if (findById(codeCpte).isPresent()) {
	            if (cp.get() instanceof CompteCourant) {
	                if (cp.get().getSolde() < montant) {
	                    throw new RuntimeException("Solde insuffisant");

	                } else {
	                    Retrait r = new Retrait(new Date(), montant, cp.get());
	                    operationRepository.save(r);
	                    cp.get().setSolde(cp.get().getSolde() - montant);
	                    compteRepository.save(cp.get());
	                }
	            }

	        }
		
	}

	@Override
	public void verement(String codeCpte1, String codeCpte2, double montant) {
		 if (!codeCpte1.equals(codeCpte2)) {
	            reterait(codeCpte1,montant);
	            verser(codeCpte2,montant);
	        }
	        else{
	            throw new RuntimeException("You can't send money to yourself");
	        }
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		return operationRepository.listOperatiion(codeCpte,PageRequest.of(page,size));

	}

	@Override
	
	public Optional<Compte> findById(String codeCpte) {
		 return compteRepository.findById(codeCpte);
	}

	@Override
	public List<Compte> listComp() {
		List<Compte> emp = (List<Compte>) compteRepository.findAll(); 
		return emp;
	}

	@Override
	public Compte addCompte(Compte compte) {
		return compteRepository.save(compte);
	}

}
