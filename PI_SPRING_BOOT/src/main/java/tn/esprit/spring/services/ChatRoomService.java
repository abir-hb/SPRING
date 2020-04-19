package tn.esprit.spring.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Chatroom;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.UserDispo;
import tn.esprit.spring.entities.UserDispoKey;
import tn.esprit.spring.repository.ChatMessageRepository;
import tn.esprit.spring.repository.ChatRoomRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ChatRoomService implements IChatRoomService {
	private static final String idd = null;
	@Autowired
	ChatRoomRepository chatroom;
	@Autowired
	ChatMessageRepository chatmessage;
	@Autowired
	UserRepository user;
	@Autowired
	UserRepository userep;
	

	@Transactional	
	@Override
	public String CreateRoom(Long UserId,Long roomId) {
		User userManagedEntity = user.findById(UserId).get();
		Chatroom chatManagedEntity = chatroom.findById(roomId).get();
		int max =chatManagedEntity.getMaxusers();
		if(max>0) {
		chatManagedEntity.setMaxusers(max-1);
		userManagedEntity.setChatroom(chatManagedEntity);
		userep.save(userManagedEntity);
		return "Congratulation vous avez rejoindre la Room Num : "+roomId+"with success";
		}
		else {
			return "Desole la room num : "+roomId+" il n'il y a pas de place la room est complet";
		}
	}


	@Override
	public List<String> findUserConnecte(Long roomId) {
				return chatroom.findUserConnecte(roomId);
		
	}



}
