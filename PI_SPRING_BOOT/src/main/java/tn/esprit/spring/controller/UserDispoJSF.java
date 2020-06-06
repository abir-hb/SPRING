package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.UserDispo;
import tn.esprit.spring.services.IDispoService;
import tn.esprit.spring.services.IUserDispoService;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserDispoServices;

@Scope(value = "session")
@Controller(value = "userdispoController")
@ELBeanName(value = "userdispoController")
@Join(path = "/dis", to = "/userdispo.jsf")
public class UserDispoJSF {
	
	@Autowired
	UserControllerJSF controll;
	@Autowired
	IUserDispoService idisposervice;
	@Autowired
	IUserService uss;
	
	private User users;
	private List<UserDispo>  userdisp;
	List<UserDispo> list;
	
	Logger logger = LoggerFactory.getLogger(UserDispoJSF.class);
	public String Addsipo() {
		 String	navigateTo = "/userdispo.xhtml?faces-redirect=true";
		Long  ids=3L;
	ids=controll.globalId();
	users=uss.findByUsers(ids);
	 idisposervice.ajouterUserDispo(ids, 24L);
	 logger.info("Done with success");
	return navigateTo;
	
	}
	
	public List<UserDispo> getAllDispo() {
		userdisp = idisposervice.getAllUserDispo();
		return userdisp;
	}

	public List<UserDispo> getUserdisp() {
		List<UserDispo> list = idisposervice.getAllUserDispo();
		return list;
	}

	public void setUserdisp(List<UserDispo> userdisp) {
		this.userdisp = userdisp;
	}

	public List<UserDispo> getList() {
		return list;
	}

	public void setList(List<UserDispo> list) {
		this.list = list;
	}
	
	
}
