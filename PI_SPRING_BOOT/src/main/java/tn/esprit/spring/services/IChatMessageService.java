package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.ChatMessage;

public interface IChatMessageService {
	public String sendmessageToUser(Long idSender,Long IdReciver,String message,String Content,String type);
	public List<ChatMessage> affichermesmessage(Long id);
	public List<String> DisplaymsginaRoom(Long userId);
	

}
