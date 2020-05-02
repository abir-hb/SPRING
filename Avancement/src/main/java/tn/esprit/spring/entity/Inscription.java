package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
public class Inscription  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	 @Id
		@GeneratedValue( strategy = GenerationType.IDENTITY )
		private int id;
	@ManyToOne
 // (name = "idClub", referencedColumnName = "id", insertable=false, updatable=false)
	private Club club;
	
	//iduser est a la fois primary key et foreign key
	
	@ManyToOne
   // @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
	private User user;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date dateFinInscription;


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateFinInscription() {
		return dateFinInscription;
	}


	public void setDateFinInscription(Date dateFinInscription) {
		this.dateFinInscription = dateFinInscription;
	}


	public Inscription(int id, Club club, User user, Date dateFinInscription) {
		super();
		this.id = id;
		this.club = club;
		this.user = user;
		this.dateFinInscription = dateFinInscription;
	}


	public Inscription() {
		super();
	}


	


	
	
}
