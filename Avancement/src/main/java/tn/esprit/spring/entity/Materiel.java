package tn.esprit.spring.entity;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="materiel")
public class Materiel {
	
	 @Id
		@GeneratedValue( strategy = GenerationType.IDENTITY )
		private int id;
		
	    private String nom;
		private String description;
		public Boolean disponibilite;
	
		@Temporal(TemporalType.DATE)
		private Date dateDisponibilite;
		
		
		
		public Boolean getDisponibilite() {
			return disponibilite;
		}
		public void setDisponibilite(Boolean disponibilite) {
			this.disponibilite = disponibilite;
		}
		@ManyToOne
		private Club club;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Materiel(int id, String nom, String description) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
		}
		public Club getClub() {
			return club;
		}
		public void setClub(Club club) {
			this.club = club;
		}
		public Date getDateDisponibilite() {
			return dateDisponibilite;
		}
		public void setDateDisponibilite(Date dateDisponibilite) {
			this.dateDisponibilite = dateDisponibilite;
		}
		public Materiel(int id, String nom, String description, Boolean disponibilite, Date dateDisponibilite,
				Club club) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.disponibilite = disponibilite;
			this.dateDisponibilite = dateDisponibilite;
			this.club = club;
		}
		public Materiel() {
			super();
		}
		@Override
		public String toString() {
			return "Materiel [id=" + id + ", nom=" + nom + ", description=" + description + ", disponibilite="
					+ disponibilite + ", dateDisponibilite=" + dateDisponibilite + ", club=" + club + "]";
		}
		
		
		
		

}

	   