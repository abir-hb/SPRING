package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IChatRoomService {
	public String CreateRoom(Long UserId,Long roomId);
	public List<String> findUserConnecte(Long roomId);
	public String ClearRoomChat(Long roomId);
	//public void KickUserChat(Long roomId);
	
		
	}
	/*
	List<User> getAllUsers();
	String getFirstNameByUserId(Long userId);
	String getLastNameByUserId(Long userId);
	void deleteUser(Long userId);
	public void updateUser(Long id, String firstname, String lastname);
	public int getNombreUserJPQL();
	*/

