package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.services.IChatMessageService;

@Controller
public class IControllerChatMessages {
	@Autowired
	IChatMessageService msgservice;
	
	public String sendmessageToUser(Long idSender,Long IdReciver,String message,String Content,String type) {
		msgservice.sendmessageToUser(idSender, IdReciver,message, Content, type);
		return "Votre messag est envoye avec Success ";
		
	}
	public List<ChatMessage> FindMyMessages(Long id){
		return msgservice.affichermesmessage(id);
	}

}
