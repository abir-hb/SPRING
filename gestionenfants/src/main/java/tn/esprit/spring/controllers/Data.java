package tn.esprit.spring.controllers;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Profession;



@Scope(value = "session")
@Controller(value = "data") 
@ELBeanName(value = "data")

public class Data {
	public Profession[] getRoles() {
		return Profession.values();
	}
}
