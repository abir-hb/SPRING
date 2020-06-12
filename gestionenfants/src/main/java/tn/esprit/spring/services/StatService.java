package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.repository.JardinRepository;
import tn.esprit.spring.repository.StatistcRepository;



@EnableScheduling
@Service
public class StatService implements IStatService {

	@Autowired
    private StatistcRepository StatisticRepository;
	@Autowired
	private JardinRepository jardinRepository;
  
	private static final Logger L =(Logger) LogManager.getLogger(StatService.class);

	@Override
	public List<?> retrieveAllUser() {
		return StatisticRepository.listUser();
	}

	@Override
	public List<?> retrieveAllUserMois() {
		return StatisticRepository.listMois1();
	}

	@Override
	public List<?> retrieveEnfantParJardin() {
		return StatisticRepository.listEnfantParJardin();
	}

	@Override
	public List<?> retrieveEnfantParNiveau() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> BestUser() {
		return StatisticRepository.BestUser();
	}

	@Override
	@Transactional
	public void addnbEnfantParJardin() {
		List<Jardin> jardin =new ArrayList<Jardin>();
		jardin=jardinRepository.findAll();

		
		for( Jardin j : jardin){
		
				j.setNombreEnfant(StatisticRepository.nbEnfantParJardin(j.getId()));
				jardinRepository.save(j);
		
			}
	}

}
