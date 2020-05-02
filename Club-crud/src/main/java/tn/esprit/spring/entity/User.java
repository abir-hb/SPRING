package tn.esprit.spring.entity;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String firstname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public User(Long id, String firstname) {
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