package tn.esprit.spring.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Utilisateur")
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String firstname;
	private String lastname;
	Role role;
	Date date;
	
	public User() {}
	public User(Long id) {
		super();
		this.id = id;
	}



	public User(Long id, String firstname, String lastname, Role role, Date date) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.date = date;
	}



	public User(String firstname, String lastname, Role role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstname + ", lastName=" + lastname + ", role=" + role + ", date="
				+ date + "]";
	}
	
}