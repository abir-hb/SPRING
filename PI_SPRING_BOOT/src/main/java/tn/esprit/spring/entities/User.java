package tn.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Utilisateur")
public class User  {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	private String firstname;
	private String lastname;
	private Boolean Connecte=false;
	Role role;
	Date date;

	@JsonIgnore
	@ManyToOne
	private Chatroom chatroom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Disponibility> dispos;
	 
	@OneToMany(mappedBy="usermessage")
	private List<ChatMessage> chatt = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public User(Long id, String firstname, String lastname, Boolean connecte, Role role, Date date, Chatroom chatroom,
			List<Disponibility> dispos, List<ChatMessage> chatt) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		Connecte = connecte;
		this.role = role;
		this.date = date;
		this.chatroom = chatroom;
		this.dispos = dispos;
		this.chatt = chatt;
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

	public String getLastname() {
		return lastname;
	}

	public Boolean getConnecte() {
		return Connecte;
	}

	public void setConnecte(Boolean connecte) {
		Connecte = connecte;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	public User() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Connecte == null) ? 0 : Connecte.hashCode());
		result = prime * result + ((chatroom == null) ? 0 : chatroom.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		//result = prime * result + ((userdispo == null) ? 0 : userdispo.hashCode());
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
		User other = (User) obj;
		if (Connecte == null) {
			if (other.Connecte != null)
				return false;
		} else if (!Connecte.equals(other.Connecte))
			return false;
		if (chatroom == null) {
			if (other.chatroom != null)
				return false;
		} else if (!chatroom.equals(other.chatroom))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (role != other.role)
			return false;
		
		return true;
	}

	public User(Long id, String firstname, String lastname, Role role, Date date, Set<UserDispo> userdispo,
			List<Chatroom> rooms) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.date = date;
	//	this.userdispo = userdispo;
		//this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + ", date="
				+ date ;
	}

	public Chatroom getChatroom() {
		return chatroom;
	}

	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}

	public User(Chatroom chatroom) {
		super();
		this.chatroom = chatroom;
	}

	

	public List<ChatMessage> getChatt() {
		return chatt;
	}

	public void setChatt(List<ChatMessage> chatt) {
		this.chatt = chatt;
	}

	public List<Disponibility> getDispos() {
		return dispos;
	}

	public void setDispos(List<Disponibility> dispos) {
		this.dispos = dispos;
	}


	
	
}