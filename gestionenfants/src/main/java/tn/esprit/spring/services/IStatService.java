package tn.esprit.spring.services;

import java.util.List;

public interface IStatService {
	public List<?> retrieveAllUser();
	public List<?> retrieveAllUserMois();
	public List<?> retrieveEnfantParJardin();
	public List<?> retrieveEnfantParNiveau();
	public void updateScore();
	public List<?> BestUser();
	void addnbEnfantParJardin();

}
