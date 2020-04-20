package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class UserDispo implements Serializable {
	private static final long serialVersionUID = 3876346912862238239L;
	@EmbeddedId
	private UserDispoKey id;
	
	@ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    User user;
 
    @ManyToOne
    @MapsId("disponibility_id")
    @JoinColumn(name = "disponibility_id")
    Disponibility disponibility;
    
    Boolean Dispo=true;
    String cas;
    String patient;

	public UserDispoKey getId() {
		return id;
	}

	public void setId(UserDispoKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Disponibility getDisponibility() {
		return disponibility;
	}

	public void setDisponibility(Disponibility disponibility) {
		this.disponibility = disponibility;
	}

	public Boolean getDispo() {
		return Dispo;
	}

	public void setDispo(Boolean dispo) {
		Dispo = dispo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dispo == null) ? 0 : Dispo.hashCode());
		result = prime * result + ((cas == null) ? 0 : cas.hashCode());
		result = prime * result + ((disponibility == null) ? 0 : disponibility.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (disponibility == null) {
			if (other.disponibility != null)
				return false;
		} else if (!disponibility.equals(other.disponibility))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public UserDispo(UserDispoKey id, Long idd, User user, Disponibility disponibility, Boolean dispo) {
		super();
		this.id = id;
		this.user = user;
		this.disponibility = disponibility;
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

	public UserDispo() {
		super();
	}
    
    
}
