package tn.esprit.spring.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.media.jfxmedia.logging.Logger;

import tn.esprit.spring.entities.User;

import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserService;

@Scope(value = "session")
@Component(value = "usercontroller")
@ELBeanName(value = "usercontroller")
@Join(path = "/login", to = "/loginpage.jsf")
public class UserControllerJSF {
	
	@Autowired
	IUserService iuss;
	
	@Autowired
	UserService us;
	private String login;
	private String password; 
	private User user;
	private Boolean loggedIn;
	private static Long id=3L;
	org.slf4j.Logger logger = LoggerFactory.getLogger(UserControllerJSF.class);
	
	public String dologin() {
		
		String navigateTo = "null";
		User user=us.findlogininfo(login, password);
		us.connectUser(user.getId());
		//System.out.println("THIS IS THE ROLE OF USER CONNECTE");
		//System.out.println(user.getRole());
		
		if (user != null) {
		
			String role =user.getRole().toString();
			if(role.equals("ADMIN")){
			id=user.getId();
			System.out.println("THIS IS THE CORRECT ID");
			System.out.println(id);
			navigateTo = "/template.xhtml?faces-redirect=true";
			loggedIn = true;
			}
			else {
				id=user.getId();
			System.out.println("THIS IS THE CORRECT ID");
			System.out.println(id);
			navigateTo = "/kinder.xhtml?faces-redirect=true";
			loggedIn = true;
				
			}
		}
			else
			{
			FacesMessage facesMessage =
	                new FacesMessage("Login Failed: please check your username/password and try again.");
	            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
			}
		
		return navigateTo;	
	}
	public Long globalId()
	{
		if(id!=null)
		return id;
		else
			return 3L;
	}

	public void KickUser(Long UserId) {
		us.KickUser(UserId);
	}
	public String doLogout() {
		logger.info("this is the id"+id.toString());
		us.deconnectUser(id);
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/loginpage.xhtml?faces-redirect=true";
	}
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
