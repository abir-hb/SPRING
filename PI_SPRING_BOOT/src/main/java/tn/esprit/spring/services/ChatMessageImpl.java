package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xpath.internal.operations.And;

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
	ChatMessageRepository msgs;
	
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
	}

	@Override
	public List<String>DisplaymsginaRoom(Long userId) {
		//get User all
		User user = userrep.findById(userId).get();
		// connecte 
		Boolean connecte= user.getConnecte();	
		//Recuperer l'ID
		Long room=user.getChatroom().getId();
		
	List<ChatMessage> list= msgs.FindMyMessages(userId);
	List<String> display=new ArrayList<>() ;
	for (ChatMessage chatMessage : list) {
	Long receiver= chatMessage.getUsermessage().getId();
	User user2 = userrep.findById(receiver).get();
	Long romIdUser2=user2.getChatroom().getId();
	Boolean con2 =user2.getConnecte();
	String name=user2.getFirstname();
	String lastname=user2.getLastname();
	if(con2.equals(true)&& connecte.equals(true)&& room.equals(romIdUser2)){
		String content =chatMessage.getContent();
		String message=chatMessage.getMessage();
		display.add("Sender : " +name+" " +lastname);
		display.add("Content  : " + content);
		display.add("Messages :"+message);
		display.add("Date : "+user2.getDate());
	}
		else if(con2.equals(true)|| connecte.equals(true)|| room.equals(romIdUser2)) {
			display.add("Un utilisateur n'est pas connecte ou dans le memes ROOM ");
}
	}
	if(display.isEmpty()) {
		List<String> list2=new ArrayList<>();
		list2.add("IL n'y a personnne connecte ou en ligne ");
		return list2;
	}
	else {
		return display;
	}
	}
}
	