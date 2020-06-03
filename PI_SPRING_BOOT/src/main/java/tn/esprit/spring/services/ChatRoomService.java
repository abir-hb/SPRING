package tn.esprit.spring.services;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Chatroom;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.UserDispo;

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
	Logger logger = LoggerFactory.getLogger(ChatRoomService.class);
	
	@Transactional	
	@Override
	public void KickUser(Long userId) {
		User userr = user.findById(userId).get();
		userr.setChatroom(null);
		user.save(userr);
	}
	
	@Transactional	
	@Override
	public String CreateRoom(Long UserId,Long roomId) {
		User userManagedEntity = user.findById(UserId).get();
		
		//logger.info(Long.toString(userroom));
		//logger.info(userroom.toString());
		try {
			Long userroom=userManagedEntity.getChatroom().getId();
			logger.info(Long.toString(userroom));
		} catch (Exception e) {
			Chatroom chatManagedEntity = chatroom.findById(roomId).get();
			int max =chatManagedEntity.getMaxusers();
			/*
			if(userroom>0) {
				return "Desole vous avez deja rejoindre la romm vous ne pouvez pas le rejoindre ";
			*/
			 if(max>0) {
				logger.info(Integer.toString(max));
			chatManagedEntity.setMaxusers(max-1);
			userManagedEntity.setChatroom(chatManagedEntity);
			userep.save(userManagedEntity);
			return "Congratulation vous avez rejoindre la Room Num : "+roomId+"with success";
		}
			 else	{
			
			return "Desole la room num : "+roomId+" il n'il y a pas de place la room est complet";
		}
		}
		return "Vous avez deja rejoindre la room ";
	}
	@Override
	public List<String> findUserConnecte(Long roomId) {
			return chatroom.findUserConnecte(roomId);
	}
	@Override
	public String ClearRoomChat(Long roomId) {
		Chatroom chat = chatroom.findById(roomId).get();
		chatroom.delete(chat);
		return "Vous avez bien supprime le chat de la room  : "+roomId;
	}
	@Transactional
	@Override
	public void kick(Long userId) {
		User userr = user.findById(userId).get();
		userr.setChatroom(null);
		user.save(userr);
		
	}
	
}
