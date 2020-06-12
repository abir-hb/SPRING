package tn.esprit.spring.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Profession;
import tn.esprit.spring.services.IEmployeService;



@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/crud1", to = "/crud1.jsf")

public class EmployeController {
	@Autowired
	IEmployeService iEmployeService;

	private String login;
	private String password;
	private Employe employe;
	private Boolean loggedIn;
	private String email;
	private Boolean isActif;
	private Profession role;
	private Integer employeIdToBeUpdated;
	private List<Employe> employes;

	

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

	
	public void ajouterEmploye() {
		System.out.println("ajout success");
		iEmployeService.addUser(new Employe(login, password, email, isActif, role));
	}

	public List<Employe> getEmployes() {
		employes = iEmployeService.getAllEmployes();
		return employes;
	}

	public void mettreAjourEmploye() {
		Employe e = new Employe(employeIdToBeUpdated, login, password, email, isActif, role);
		iEmployeService.updateEmploye(e);
	}

	public void removeEmploye(int employeid) {
		iEmployeService.deleteEmploye(employeid);
	}

	public void modifier(Employe employe) {
		this.setEmail(employe.getEmail());
		this.setIsActif(employe.getIsActif());
		this.setLogin(employe.getLogin());
		this.setPassword(employe.getPassword());
		this.setRole(employe.getRole());
		this.setEmployeIdToBeUpdated(employe.getId());
	}

	public IEmployeService getiEmployeService() {
		return iEmployeService;
	}

	public void setiEmployeService(IEmployeService iEmployeService) {
		this.iEmployeService = iEmployeService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}



	public Profession getRole() {
		return role;
	}

	public void setRole(Profession role) {
		this.role = role;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

}
