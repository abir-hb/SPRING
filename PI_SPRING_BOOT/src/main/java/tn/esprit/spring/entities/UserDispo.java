package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserDispo implements Serializable {
	private static final long serialVersionUID = 3876346912862238239L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	 
    Boolean Dispo=true;
    String cas;
   
    String patient;
    String dispo_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userDispo_id")
    private User userDispo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dispo == null) ? 0 : Dispo.hashCode());
		result = prime * result + ((cas == null) ? 0 : cas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((userDispo == null) ? 0 : userDispo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDispo other = (UserDispo) obj;
		if (Dispo == null) {
			if (other.Dispo != null)
				return false;
		} else if (!Dispo.equals(other.Dispo))
			return false;
		if (cas == null) {
			if (other.cas != null)
				return false;
		} else if (!cas.equals(other.cas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (userDispo == null) {
			if (other.userDispo != null)
				return false;
		} else if (!userDispo.equals(other.userDispo))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDispo() {
		return Dispo;
	}

	public void setDispo(Boolean dispo) {
		Dispo = dispo;
	}

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDispo_id() {
		return dispo_id;
	}

	public void setDispo_id(String dispo_id) {
		this.dispo_id = dispo_id;
	}

	public UserDispo(Long id, Boolean dispo, String cas, String patient, UserDispo userDispo) {
		super();
		this.id = id;
		Dispo = dispo;
		this.cas = cas;
		this.patient = patient;
		//this.userDispo = userDispo;
	}

	public UserDispo() {
		super();
	}

	public User getUserDispo() {
		return userDispo;
	}

	public void setUserDispo(User userDispo) {
		this.userDispo = userDispo;
	}

	public UserDispo(Long id, Boolean dispo, String cas, String patient, String dispo_id, User userDispo) {
		super();
		this.id = id;
		Dispo = dispo;
		this.cas = cas;
		this.patient = patient;
		this.dispo_id = dispo_id;
		this.userDispo = userDispo;
	}

	
    
  
   


	
    
}
