package tn.esprit.spring.controller.admin;

import javax.faces.view.ViewScoped;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.stereotype.Controller;

@Controller
@ViewScoped

@Join(path = "/admin", to = "/template.jsf")
public class DashboardController {
	
	


}
