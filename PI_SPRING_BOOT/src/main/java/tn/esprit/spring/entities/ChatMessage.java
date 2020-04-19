package tn.esprit.spring.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

@EntityScan
@Entity
@Table(name = "CHATMESSAGE")
public class ChatMessage {

	@Id
	@Column(name = "ID", unique = true, updatable = false, nullable = false)
	@GeneratedValue
	private long id;
	private String type;
	private String content;
	private String message;
	private Long receiver;
	//private String lastName;	
	
	
	@UpdateTimestamp
	private Timestamp time;
	
	@JsonIgnore
	@ManyToOne
	private User usermessage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getReceiver() {
		return receiver;
	}

	public void setReceiver(Long receiver) {
		this.receiver = receiver;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public User getUsermessage() {
		return usermessage;
	}

	public void setUsermessage(User usermessage) {
		this.usermessage = usermessage;
	}

	public ChatMessage(long id, String type, String content, String message, Long receiver, Timestamp time,
			User usermessage) {
		super();
		this.id = id;
		this.type = type;
		this.content = content;
		this.message = message;
		this.receiver = receiver;
		this.time = time;
		this.usermessage = usermessage;
	}

	@Override
	public String toString() {
		return "ChatMessage [id=" + id + ", type=" + type + ", content=" + content + ", message=" + message
				+ ", receiver=" + receiver + ", time=" + time + ", usermessage=" + usermessage + "]";
	}

	public ChatMessage() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((usermessage == null) ? 0 : usermessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatMessage other = (ChatMessage) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (usermessage == null) {
			if (other.usermessage != null)
				return false;
		} else if (!usermessage.equals(other.usermessage))
			return false;
		return true;
	}
	
	
	/*
	@JsonIgnore
	@OneToOne
	 @JoinColumn(name = "sender",referencedColumnName="firstname")
	private User useres;
	@JsonIgnore
	@OneToOne
	 @JoinColumn(name = "receiver",referencedColumnName="lastname")
	private User useress;
	*/
	/*
    @OneToMany(mappedBy="chat")
    private Set<Chatroom> chatroom;
	*/

	
/*
	public Set<Chatroom> getChatroom() {
		return chatroom;
	}

	public void setChatroom(Set<Chatroom> chatroom) {
		this.chatroom = chatroom;
	}
*/

	
	
}
