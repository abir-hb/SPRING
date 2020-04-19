package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Chatroom;

public interface ChatRoomRepository extends CrudRepository<Chatroom, Long>{

	
	@Query("select u.firstname,u.lastname from User u join u.chatroom c where c.id=:roomId and u.Connecte=true")
	    public List<String> findUserConnecte(@Param("roomId")Long roomId);
	 
	
}

