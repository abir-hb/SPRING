package tn.esprit.spring.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String username;
 private String lastName;
 private String fristName;
	
	
	private String email;

	
	private String password;
	
	
	

	
	private Boolean etatAcc=true;
	
	@Column(name = "enabled")
    private boolean enabled=false;
	
	 private String imageName;
		private String	idImage;
	@Temporal (TemporalType.DATE)
	private Date dateInscription;
	@JsonIgnore
	@Column(name = "score")
	private float score;
	
	 @OneToMany(mappedBy = "appUser", fetch = FetchType.LAZY)
	    private Collection<Compte> comptes;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id")) 
	
	private Set<Role> roles = new HashSet<>();

	
	
	@JsonIgnore
	

	public User() {
		super();
	}
	

	public User(String lastName, String fristName,  String email, Boolean etatAcc,
			boolean enabled, Date dateInscription) {
		super();
		this.lastName = lastName;
		this.fristName = fristName;
		this.email = email;
		this.etatAcc = etatAcc;
		this.enabled = enabled;
		this.dateInscription = dateInscription;
	}
	public User(Long employeIdToBeUpdated,String lastName, String fristName, String email, Boolean etatAcc) {
		super();
		this.id=employeIdToBeUpdated;
		this.lastName = lastName;
		this.fristName = fristName;
		this.email = email;
		this.etatAcc = etatAcc;
		
		
	}
	
	




	public User(String lastName, String fristName,  String email,
			String password, Boolean etatAcc, Date dateInscription) {
		super();
		this.lastName = lastName;
		this.fristName = fristName;
		this.email = email;
		this.password = password;
		this.etatAcc = etatAcc;
		this.dateInscription = dateInscription;
	}


	public User(String lastName, String fristName,  String email,
			 String password) {
		super();
		this.lastName = lastName;
		this.fristName = fristName;
		this.email = email;
		this.password = password;
	}


	
	




	public User(String lastName, String fristName, String email, String password, Boolean etatAcc) {
		super();
		this.lastName = lastName;
		this.fristName = fristName;
		this.email = email;
		this.password = password;
		this.etatAcc = etatAcc;
	}


	public User(Long employeIdToBeUpdated, String lastName, String fristName,  String email,
			Boolean etatAcc, Date dateInscription) {
		super();
		this.id = employeIdToBeUpdated;
		this.lastName = lastName;
		this.fristName = fristName;
		this.email = email;
		this.etatAcc = etatAcc;
		this.dateInscription = dateInscription;
	}


	public User( String username,  String email,
			 String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User( String username,  String email,
			 String password, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	

	public User(Long id,  String username,  String email,
			 String password, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.etatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}

	public User( String username,  String email,
			String password, Boolean etatAcc, boolean enabled, Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.etatAcc = etatAcc;
		this.enabled = enabled;
		this.roles = roles;
	}
	

	
	

	
	

	
	
	

	
	

	
	

	

	
	
	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFristName() {
		return fristName;
	}


	public void setFristName(String fristName) {
		this.fristName = fristName;
	}


	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Boolean getEtatAcc() {
		return etatAcc;
	}


	public void setEtatAcc(Boolean etatAcc) {
		this.etatAcc = etatAcc;
	}


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

	
	

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getIdImage() {
		return idImage;
	}


	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}


	

}
