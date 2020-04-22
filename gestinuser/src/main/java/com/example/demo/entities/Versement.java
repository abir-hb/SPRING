package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.demo.entities.Compte;

@Entity
@DiscriminatorValue("V")
public class Versement  extends Operation{
	 public Versement() {
	        super();
	    }

	    public Versement(Date dateOperation, double montant, Compte compte) {
	        super(dateOperation, montant, compte);
	    }
}
