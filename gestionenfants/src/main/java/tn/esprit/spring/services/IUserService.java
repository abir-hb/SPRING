package tn.esprit.spring.services;




import java.util.List;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;

public interface IUserService {
 
    User getUser(String verificationToken);
 
    void saveRegisteredUser(User user);
    
   
    void createVerificationToken(User user, String token);
 
    VerificationToken getVerificationToken(String VerificationToken);

	List<User> getAllUser();
	
	public void deleteUserById(long userId) ;
}
