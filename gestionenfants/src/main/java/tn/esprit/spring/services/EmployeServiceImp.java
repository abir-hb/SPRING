package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImp implements IEmployeService{
	@Autowired
	EmployeRepository employeRepository;
	@Override
	public Employe getEmployeByEmailAndPassword(String login, String password) {
		
		return employeRepository.getEmployeByEmailAndPassword(login, password); 
	}
	@Override
	public Employe addUser(Employe employe) {
		return employeRepository.save(employe);
	}
	@Override
	public List<Employe> getAllEmployes() {
		List<Employe> emp = (List<Employe>) employeRepository.findAll(); return emp; 
	}
	@Override
	public void deleteEmploye(int employeid) {
		employeRepository.deleteById(employeid); 
		
	}
	@Override
	public void updateEmploye(Employe e) {
		employeRepository.save(e);

		
	}
	@Override
	public Employe updateEmployes(Employe e) {
		return employeRepository.save(e);
	}

}
