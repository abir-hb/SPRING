package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_CPTE",discriminatorType = DiscriminatorType.STRING ,length = 2)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
})
public  abstract class Compte  implements Serializable  {
	@Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_USR")
    private User appUser ;

    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

	public Compte() {
		super();
	}

	
	public Compte(Date dateCreation, double solde, User appUser, Collection<Operation> operations) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.appUser = appUser;
		this.operations = operations;
	}



	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}


	public Compte(String codeCompte, Date dateCreation, double solde, User appUser, Collection<Operation> operations) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.appUser = appUser;
		this.operations = operations;
	}

	public String getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	
public User getAppUser() {
		return appUser;
	}

	public void setAppUser(User appUser) {
		this.appUser = appUser;
	}

@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
    
}
