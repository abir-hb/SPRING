package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "enfant")
public class Enfant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	@ManyToOne(cascade = CascadeType.ALL) 
	User user;
	@ManyToOne(cascade = CascadeType.ALL)
	Jardin jardin;
	private String loisir;
	public Enfant() {
		super();
	}
	public Enfant(Long id, String nom, String prenom, User user, Jardin jardin, String loisir) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.jardin = jardin;
		this.loisir = loisir;
	}
	public Enfant(String nom, String prenom, User user, Jardin jardin, String loisir) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
		this.jardin = jardin;
		this.loisir = loisir;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Jardin getJardin() {
		return jardin;
	}
	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
	public String getLoisir() {
		return loisir;
	}
	public void setLoisir(String loisir) {
		this.loisir = loisir;
	}
	

}
