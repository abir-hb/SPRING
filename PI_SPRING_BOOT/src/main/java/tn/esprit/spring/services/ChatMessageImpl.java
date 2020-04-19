package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.Chatroom;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ChatMessageRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class ChatMessageImpl implements IChatMessageService {
	@Autowired
	ChatMessageRepository msg;
	@Autowired
	ChatMessageRepository msgg;
	
	@Autowired
	UserRepository userrep;
	
	
	
	@Override
	public String sendmessageToUser(Long idSender, Long IdReciver,String message, String Content, String type) {
	ChatMessage chat = new ChatMessage();
	Boolean user=userrep.existsById(IdReciver);
	User userManagedEntity = userrep.findById(idSender).get();
	chat.setUsermessage(userManagedEntity);
	chat.setMessage(message);
	chat.setContent(Content);
	chat.setType(type);
	if(user.equals(false)) {
		return "Le user : "+IdReciver+"  est errone Veuillez entrer un autre USER ";	
	}
	else {
		chat.setReceiver(IdReciver);
		msg.save(chat);
		return "Votre message a été envoyer a l'utlisateur num "+IdReciver+"  avec success";
	}}

	@Override
	public List<ChatMessage> affichermesmessage(Long id) {
		List<ChatMessage> list =msgg.FindMyMessages(id);
		return list;
	}}
