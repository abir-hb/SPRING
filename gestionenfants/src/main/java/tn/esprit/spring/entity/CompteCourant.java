package tn.esprit.spring.entity;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	private double decouvert ;

	public CompteCourant() {
		super();
	}


	public CompteCourant(Date dateCreation, double solde, User appUser, Collection<Operation> operations,
			double decouvert) {
		super(dateCreation, solde, appUser, operations);
		this.decouvert = decouvert;
	}


	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}


	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	

	
}
