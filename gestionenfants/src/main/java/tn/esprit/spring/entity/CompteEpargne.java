package tn.esprit.spring.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux;
	

	public CompteEpargne(double taux) {
		super();
		this.taux = taux;
	}


	public CompteEpargne(String codeCompte, Date dateCreation, double solde, User appUser,
			Collection<Operation> operations, double taux) {
		super(codeCompte, dateCreation, solde, appUser, operations);
		this.taux = taux;
	}

	public CompteEpargne() {
		super();
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
}
