package tn.esprit.spring.services;

public interface IUserDispoService {
	public String ajouterUserDispo(long UserId, long DispoId);
	public String ajouterUserDispoUrgent(long UserId, long DispoId);
	public void deleteuserdispo(Long userId);
	public String reserverRendezVous(Long UserId,String Cas);
	public void deletemydispo(Long UserId);
	//public void deleteuserdispo(Long userId,Long dispoId);

}
