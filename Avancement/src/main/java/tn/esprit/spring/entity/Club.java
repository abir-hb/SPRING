package tn.esprit.spring.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Entity
@Table(name="Club")
public class Club {

	    @Id
		@GeneratedValue( strategy = GenerationType.IDENTITY )
		private int id;
		
	    private String nom;
		private String description;
		private Long nbm;
		
	
		
		
		Date date;
		

		@OneToMany(mappedBy="club", 
				cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
				fetch=FetchType.EAGER)
		private List<Materiel> materiels = new ArrayList<>();

		
		public List<Materiel> getMateriels() {
			return materiels;
		}



		public void setMateriels(List<Materiel> materiels) {
			this.materiels = materiels;
		}



		@ManyToOne
		@JoinColumn(name="ID_CATEGORIE")
		Categorie categorie;
		

		@OneToMany(mappedBy="club")
		private  List<Inscription> inscriptions;
		
		
		public List<Inscription> getInscriptions() {
			return inscriptions;
		}



		public void setInscriptions(List<Inscription> inscriptions) {
			this.inscriptions = inscriptions;
		}



		public Categorie getCategorie() {
			return categorie;
		}



		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}



		public Club(int id, String nom, String description, Long nbm, Date date, Categorie categorie) {
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



		public Club(int id, String nom, String description, Long nbm, Date date) {
			super();
			this.id = id;
			this.nom = nom;
			this.description = description;
			this.nbm = nbm;
			
			this.date = date;
		}
		
		
		
		
		
		
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

