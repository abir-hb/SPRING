package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.Ipaiment;

@Controller(value = "paimentController")
@Join(path = "/money", to = "/money.jsf")
@Component
public class PaimentController {
	@Autowired
	private Ipaiment metier;
	private String code1;
	private String code2;
	private double montant;
	private Compte compte;
	private List<Compte> comptes;
	private String code;
    private Date dateCreation;
    private double solde;

	public String verser() {
		metier.verser("code1", montant);
		return "Succes verser ";
	}

	public String retirer() {
		metier.reterait("code1", montant);
		return "Succes";
	}

	public String virement() {
		metier.verement("code1", "code2", montant);
		return "Succes";

	}

	public List<Compte> getListComptes() {
		comptes = metier.listComp();
		return comptes;
	}

	public Ipaiment getMetier() {
		return metier;
	}

	public void setMetier(Ipaiment metier) {
		this.metier = metier;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	
}
