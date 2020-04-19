package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.services.IChatRoomService;

@Controller
public class IControllerChatRoomImpl {
	@Autowired
	IChatRoomService ichat;
	@Autowired
	IUserControl iuser;
	
	
	public void CreateRoom(Long userid,Long roomId) {
		ichat.CreateRoom(userid,roomId);
	}
	public String findUserConnecte(Long userid,Long roomId) {
	return	ichat.CreateRoom(userid, roomId);
	}
	
}
