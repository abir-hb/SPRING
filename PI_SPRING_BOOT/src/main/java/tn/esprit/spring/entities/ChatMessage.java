package tn.esprit.spring.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity
@Table(name = "CHATHISTORY")
public class ChatMessage {

	@Id
	@Column(name = "ID", unique = true, updatable = false, nullable = false)
	@GeneratedValue
	private long id;
	private MessageType type;

	@Column(name = "CONTENT", unique = false, updatable = true, nullable = true)
	private String content;
	
	@Transient
	private String sender;	

	@Column(name = "USERNAME", unique = false, updatable = true, nullable = false)
	private String userName;
	
	@Transient
	private String firstName;
	@Transient
	private String lastName;	

	@Column(name = "CHATDATETIME", unique = false, updatable = true, nullable = true)
	private Timestamp time;
	
	@Column(name = "USERLIST", unique = false, updatable = true, nullable = true)
	private String userList;
	
	
	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}

	public ChatMessage() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public ChatMessage(String content) {
		this.content = content;
	}

	public enum MessageType {
		CHAT, JOIN, LEAVE
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "ChatMessage [type=" + type + ", content=" + content + ", sender=" + sender + "]";
	}
}
