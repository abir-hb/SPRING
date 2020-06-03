package tn.esprit.spring.services;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Chatroom;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ChatRoomRepository;
import tn.esprit.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;



@Component
public class UserService implements IUserService {
private static final String idd = null;
@Autowired
UserRepository userRepository;

@Autowired
UserRepository userrep;
@Autowired
ChatRoomRepository chatrep;

@Override
public User addUser(User user) {
	return userRepository.save(user);
}

@Override
public String getFirstNameByUserId(Long userId) {
	return userRepository.findById(userId).get().getFirstname().toString();
}

@Override
public String getLastNameByUserId(Long userId) {
	return userRepository.findById(userId).get().getLastname();
}

@Override
public void deleteUser(Long userId) {
	userRepository.deleteById(userId);
}

@Override
public List<User> getAllUsers() {
	return (List<User>)userRepository.findAll();
}

@Override
public void updateUser(Long id, String firstname, String lastname) {
	User userr = userRepository.findById(id).get();
	userr.setFirstname(firstname);
	userr.setLastname(lastname);
	userRepository.save(userr);
}

@Override
public String getNombreUserJPQL() {
	return "Le nombre des utlisateurs totale : "+userRepository.countuser();
}

@Override
public String login(Long userId) {
	User userr = userrep.findById(userId).get();
	String name= userr.getFirstname().toString();
	userrep.login(userId);
	return "Vous etes connecte "+name;
	
}
@Override
public String logout(Long userId) {
	User userr = userrep.findById(userId).get();
	String name= userr.getFirstname().toString();
	userrep.logout(userId);
	return "Vous etes deconnecte "+name;
}
/*

public void KickUser(Long UserId,Long id) {
	/*
	User userr = userRepository.findById(UserId).get();
	List<User> list =userr.getChatroom().getUserrr();
	userr.getChatroom()
	list.remove(UserId);
	userRepository.save(userr);
	}
	*/

@Override
public void KickUser(Long UserId) {
	User userr = userRepository.findById(UserId).get();
	Long roomid = userRepository.findUserRoom(UserId);
	Chatroom chat =chatrep.findById(roomid).get();
	int max = chat.getMaxusers();
	chat.setMaxusers(max+1);
	userr.setChatroom(null);
	userRepository.save(userr);
	chatrep.save(chat);
}

@Override
public Long findUserRoom(Long UserId) {
return	userRepository.findUserRoom(UserId);

}

@Override
public String dologin() {
	// TODO Auto-generated method stub
	return null;
}

	
}
