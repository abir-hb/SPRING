package tn.esprit.spring.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="Categorie")
public class Categorie {

    @Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idc;
	private String name;
	public Categorie(Long idc, String name) {
		super();
		this.idc = idc;
		this.name = name;
	}
	
	

	public Categorie(String name) {
		super();
		this.name = name;
	}

	public Categorie() {
		super();
	}
	public Long getIdc() {
		return idc;
	}
	public void setIdc(Long idc) {
		this.idc = idc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Categorie [idc=" + idc + ", name=" + name + "]";
	}
	
	
}

