package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.services.IChatMessageService;

@RestController
public class RestMesages {
	@Autowired
	IChatMessageService chatmessages;

	@PutMapping(value = "/sendmsg/{idSender}/{IdReciver}/{message}/{Content}/{type}")
	public String sendmessageToUser(@PathVariable("idSender") long idSenderr, @PathVariable("IdReciver") long IdReciverr,@PathVariable("message") String messages, @PathVariable("Content") String Contentt, @PathVariable("type") String typee) {
	return	chatmessages.sendmessageToUser(idSenderr, IdReciverr,messages, Contentt, typee);		
	}
	
	 @GetMapping(value = "findmymsg/{userId}")
	    @ResponseBody
	    public List<ChatMessage> CreateRoom(@PathVariable("userId") Long userId) {
			return chatmessages.affichermesmessage(userId);
			 
		}
}
