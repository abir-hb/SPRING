package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IChatRoomService {
	public String CreateRoom(Long UserId,Long roomId);
	public List<String> findUserConnecte(Long roomId);
	public String ClearRoomChat(Long roomId);
	//public void KickUserChat(Long roomId);
	
		
	}
