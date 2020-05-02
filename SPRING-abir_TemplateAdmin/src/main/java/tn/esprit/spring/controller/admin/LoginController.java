package tn.esprit.spring.controller.admin;

import javax.faces.view.ViewScoped;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.stereotype.Controller;






@ViewScoped
@Controller

@Join(path = "/", to = "/login.jsf")
public class LoginController   {
	
}
