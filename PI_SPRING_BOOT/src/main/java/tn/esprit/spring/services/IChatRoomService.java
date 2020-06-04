package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Chatroom;
import tn.esprit.spring.entities.User;

public interface IChatRoomService {
	public String CreateRoom(Long UserId,Long roomId);
	public List<String> findUserConnecte(Long roomId);
	public String ClearRoomChat(Long roomId);
	public void KickUser(Long userId);
	public void kick(Long userId);
	public Chatroom AddRoom(Chatroom chat);
	
		
	}

