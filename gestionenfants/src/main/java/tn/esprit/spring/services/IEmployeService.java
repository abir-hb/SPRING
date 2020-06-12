package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Employe;




public interface IEmployeService {
	public Employe getEmployeByEmailAndPassword(String login, String password) ;
	 public Employe addUser(Employe employe);
	 public List<Employe> getAllEmployes();
	 public void deleteEmploye(int employeid) ;
	 public void updateEmploye(Employe e);
	public Employe updateEmployes(Employe e);
	
}
