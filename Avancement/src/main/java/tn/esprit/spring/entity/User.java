package tn.esprit.spring.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name="Utilisateur")
public class User {
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	private String firstname;
	
	
	//@JsonIgnore
	//@JsonBackReference
	@OneToMany(mappedBy="user")
	private List<Inscription> inscriptions;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public User(int id, String firstname) {
		super();
		this.id = id;
		this.firstname = firstname;
	}
	public User() {
		super();
	}
	public User(String firstname) {
		super();
		this.firstname = firstname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + "]";
	}

	
	}