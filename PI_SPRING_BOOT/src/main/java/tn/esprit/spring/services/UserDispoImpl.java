package tn.esprit.spring.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.UserDispo;
import tn.esprit.spring.entities.UserDispoKey;

import tn.esprit.spring.repository.UserDispoRepository;


@Service
public class UserDispoImpl implements IUserDispoService {

	@Autowired
	UserDispoRepository userDispoRepository;
	@Override
	public void ajouterUserDispo(long UserId, long DispoId) {
		UserDispoKey userkey = new UserDispoKey();
		userkey.setUserId(UserId);
		userkey.setDispoId(DispoId);
		UserDispo userdispo = new UserDispo();
		userdispo.setId(userkey);
		userdispo.setDispo(true);
		userDispoRepository.save(userdispo);		
	}
	/*
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}
	*/

}
