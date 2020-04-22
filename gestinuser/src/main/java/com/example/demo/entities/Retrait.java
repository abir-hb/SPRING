package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.example.demo.entities.Compte;





@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {
	 public Retrait() {
	        super();
	    }
	 public Retrait(Date dateOperation, double montant, Compte compte) {
	        super(dateOperation, montant, compte);
	    }
	

}
