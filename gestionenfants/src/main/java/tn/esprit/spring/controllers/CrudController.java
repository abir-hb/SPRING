package tn.esprit.spring.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IacountService;

//@Scope(value = "session")
@Controller(value = "crudController")
@ELBeanName(value = "crudController")
@Join(path = "/crud", to = "/crud1.jsf")

public class CrudController {
	@Autowired
	private IacountService iacountService;
	@Autowired
	private UserRepository userRepository;
	private User employe;
	private Long employeIdToBeUpdated;
	private List<User> employes;
	private Boolean etatAcc;
	private String email;
	private String password;
	private Date dateInscription;
	private String lastName;
	private String fristName;
	private String imageName;
	private String idImage;
	private UploadedFile file;

	public String ajouterEmploye() throws IOException {
		String navigateTo="null";
		User user = new User(lastName, fristName, email, password, etatAcc);
//		try {
//
//			upload();
//			TransfertFile(file.getFileName(), file.getInputStream());
//			user.setImageName(file.getFileName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		userRepository.save(user);
		//System.out.println(file.getFileName());
		navigateTo = "crud.xhtml?faces-redirect=true";
		return navigateTo;

	}

	public List<User> getEmployes() {
		employes = iacountService.getAllUsers();
		return employes;
	}

	public void mettreAjourEmploye() {
		// User e = new User(employeIdToBeUpdated, lastName, fristName, email, EtatAcc);
		User e = new User(employeIdToBeUpdated, lastName, fristName, email, etatAcc);
		iacountService.updateUser(e);

	}

	public void removeEmploye(Long employeid) {
		iacountService.deleteUSer(employeid);
	}

	public void modifier(User employe) {
		this.setEmail(employe.getEmail());
		// this.setPassword(employe.getPassword());

		this.setEtatAcc(employe.getEtatAcc());
		// this.setDateInscription(employe.getDateInscription());
		this.setLastName(employe.getLastName());
		this.setFristName(employe.getFristName());

		this.setEmployeIdToBeUpdated(employe.getId());
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else
			System.out.println("file is null");

	}

	public void TransfertFile(String filename, InputStream in) {
		String destination = "C:\\khaoulaFile";
		try {
			OutputStream out = new FileOutputStream(new File(destination + filename));
			int reader = 0;
			byte[] bytes = new byte[(int) file.getSize()];
			while ((reader = in.read(bytes)) != -1) {
				out.write(bytes, 0, reader);

			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public IacountService getIacountService() {
		return iacountService;
	}

	public void setIacountService(IacountService iacountService) {
		this.iacountService = iacountService;
	}

	public User getEmploye() {
		return employe;
	}

	public void setEmploye(User employe) {
		this.employe = employe;
	}

	public Long getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Long employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setEmployes(List<User> employes) {
		this.employes = employes;

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

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
