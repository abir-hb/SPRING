package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.ChatMessage;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
	@Query("select u from ChatMessage u where u.receiver=:userId")
    public List<ChatMessage> FindMyMessages(@Param("userId")Long userId);
}
