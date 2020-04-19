package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.IChatRoomService;
import tn.esprit.spring.services.IUserService;

@RestController
public class RestControllerChatRoom {
@Autowired
IUserService iuserservices;
@Autowired
IChatRoomService ichatroom;


	//ma9loubin userId + chatroom_id
	@PutMapping(value = "/createroom/{chatroom_id}/{id}")
	public String Joinaroom(@PathVariable("chatroom_id") long roomId,@PathVariable("id") long userId) {
		return	ichatroom.CreateRoom(roomId,userId);
	
		//return "Congratulation Vous avez rejoindre la room num Avec Success";
	}
	

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeNamesJPQL
    @GetMapping(value = "findconnecte/{roomId}")
    @ResponseBody
    public List<String> CreateRoom(@PathVariable("roomId") Long roomId) {
		return ichatroom.findUserConnecte(roomId);
		 
	}
    
}
