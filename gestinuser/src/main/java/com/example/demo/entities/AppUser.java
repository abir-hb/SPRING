package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class AppUser implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	private String lastName;
	private String firstName;
	private String email;
	@Embedded
	private File image;
	
	public AppUser(Long id, String username, String password, String lastName, String firstName, String email,
			Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AppUser(Long id, String username, String password, String lastName, String firstName,
			Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.roles = roles;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList<>();

	public AppUser() {
		super();
	}

	public AppUser(Long id, String username, String password, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public AppUser(String username, String password, Collection<AppRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}

	public AppUser(Long id, String username, String password, String lastName, String firstName, String email,
			File image, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.image = image;
		this.roles = roles;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
}
