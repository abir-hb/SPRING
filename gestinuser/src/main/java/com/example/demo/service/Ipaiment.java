package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;



public interface Ipaiment {
	 public Optional<Compte> consulterCompter(String codeCpte);
	    public void verser(String codeCpte , double montant);
	    public void reterait(String codeCpte , double montant);
	    public void verement(String codeCpte1 , String codeCpte2 , double montant);
	    public Page<Operation> listOperation(String codeCpte , int page , int size);
	    Optional<Compte> findById(String id);

}
