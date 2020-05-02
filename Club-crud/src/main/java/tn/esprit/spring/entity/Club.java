package tn.esprit.spring.entity;

import java.sql.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Club")
public class Club {

	    @Id
		@GeneratedValue( strategy = GenerationType.IDENTITY )
		private Long id;
		private String nom;
		private String description;
		private Long nbm;
		
	
		
		
		Date date;
		
		@ManyToOne
		@JoinColumn(name="ID_CATEGORIE")
		Categorie categorie;
		
		
		
		public Categorie getCategorie() {
			return categorie;
		}



		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}



		public Club(Long id, String nom, String description, Long nbm, Date date, Categorie categorie) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.nbm = nbm;
			this.date = date;
			this.categorie = categorie;
		}



		public Club() {
			super();
		}



		public Club(String nom, String description, Long nbm,  Date date) {
			super();
			this.nom = nom;
			this.description = description;
			this.nbm = nbm;
		
			this.date = date;
		}



		public Club(Long id, String nom, String description, Long nbm, Date date) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.nbm = nbm;
			
			this.date = date;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Long getNbm() {
			return nbm;
		}
		public void setNbm(Long nbm) {
			this.nbm = nbm;
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
			return "Club [id=" + id + ", nom=" + nom + ", description=" + description + ", nbm=" + nbm +  ", date=" + date + "]";
		}
		
		
		
}

