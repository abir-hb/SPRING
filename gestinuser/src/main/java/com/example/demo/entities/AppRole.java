package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AppRole implements Serializable {
	@Id
	@GeneratedValue
	private Long idRole;
	private String roleName;
//	@ManyToMany
//	private List<AppUser> appUser;
//	
	
	


	public AppRole() {
		super();
	}

	

	


	public AppRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long id) {
		this.idRole = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	


	



	@Override
	public String toString() {
		return "AppRole [id=" + idRole + ", roleName=" + roleName + "]";
	}

	
}
