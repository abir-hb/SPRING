package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entity.Club;
import tn.esprit.spring.entity.Materiel;
import tn.esprit.spring.repository.ClubRepository;
import tn.esprit.spring.repository.MaterielRepository;

@Component
public class ClubService implements IClubService {

	
	@Autowired
	ClubRepository clubRepository;
	@Autowired
	MaterielRepository materielRepository;
	
	
	

	@Override
	public Club addClub(Club club) {
		return clubRepository.save(club);

	}
	
	public Materiel ajouterMateriel(Materiel materiel) {
		return materielRepository.save(materiel);
		//return ma.getId();
	}

	

	@Override
	public void deleteClub(int id) {
		clubRepository.deleteById(id);

	}

	@Override
	public List<Club> getAllClub() {
		return (List<Club>) clubRepository.findAll();
	}


	public List<Materiel> getAllMateriel() {
		return (List<Materiel>) materielRepository.findAll();
	}
	
	@Override
	public Club updateClub(Club club) {
		return clubRepository.save(club);
	}

	public Optional<Club> findByNom(String nom) {

		return clubRepository.findByNom(nom);
	}
	
	public void affecterMaterielAClub(int maId, int clubId) {
		
				Club clubManagedEntity = clubRepository.findById(clubId).get();
				Materiel MaManagedEntity = materielRepository.findById(maId).get();
				//MaManagedEntity.setDisponibilite(true);
				
				if(MaManagedEntity.getDisponibilite()==true) {
					
					MaManagedEntity.setClub(clubManagedEntity);
					MaManagedEntity.setDisponibilite(false);
					materielRepository.save(MaManagedEntity);
					
				}else {
				
				if (MaManagedEntity.getDisponibilite()==false) {	
						System.out.println("le matieriel n'est pas disponible ");
						return;
					}}
	}
	public void mettreAjourMaterielByMaId(int maId) {
		Materiel materiel = materielRepository.findById(maId).get();
		//Club club = clubRepository.findById(clubId).get();
		if (materiel.getDateDisponibilite().after(new Date())) {
			
		//	materiel.setDateDisponibilite(new Date ());		
			materiel.setDisponibilite(true);
			materielRepository.save(materiel);
			System.out.println("le matieriel est disponible maintenant ");
			
		}else {
			System.out.println("le matieriel est en cours d'utilisation");
		return;
		
		}
		

	}
	
	
	//today.getYear(),today.getMonth()-1,today.getDay()

	public Materiel updateMateriel(Materiel materiel) {
		materiel.setDisponibilite(false);
		 		return materielRepository.save(materiel);
	}




	
	
	public List<String> getAllMaterielsNamesByClub(int clubId) {
		Club clubManagedEntity = clubRepository.findById(clubId).get();
		List<String> MaterielNames = new ArrayList<>();
		for(Materiel Ma : clubManagedEntity.getMateriels()){
			MaterielNames.add(Ma.getNom());
		}
		
		return MaterielNames;
	}
	
	
	public void deleteMaterielById(int MaId) {
		materielRepository.deleteById( MaId);
	}
	
	}