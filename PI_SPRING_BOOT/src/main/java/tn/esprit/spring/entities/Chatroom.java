package tn.esprit.spring.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

@EntityScan
@Entity
@Table(name = "Chatroom")
public class Chatroom {
	@Id
	@Column(name = "ID", unique = true, updatable = false, nullable = false)
	@GeneratedValue
	private long id;
	public String roomname;
	public String roomtype;	
	public int maxusers;
	
	/*
	@ManyToOne
    @JoinColumn(name="chat_id", nullable=false)
    private ChatMessage chat;
	*/

	@OneToMany(mappedBy="chatroom",cascade=CascadeType.ALL)
	private List<User> userrr = new ArrayList<>();

	public long getId() {
		return id;
	}

	

	public Chatroom(List<User> userrr) {
		super();
		this.userrr = userrr;
	}



	public Chatroom(String roomname, String roomtype, int maxusers) {
		super();
		this.roomname = roomname;
		this.roomtype = roomtype;
		this.maxusers = maxusers;
	}



	public Chatroom(long id) {
		super();
		this.id = id;
	}



	public void setId(long id) {
		this.id = id;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getMaxusers() {
		return maxusers;
	}

	public void setMaxusers(int maxusers) {
		this.maxusers = maxusers;
	}

	public Chatroom(long id, String roomname, String roomtype, int maxusers, Chatroom chat) {
		super();
		this.id = id;
		this.roomname = roomname;
		this.roomtype = roomtype;
		this.maxusers = maxusers;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + maxusers;
		result = prime * result + ((roomname == null) ? 0 : roomname.hashCode());
		result = prime * result + ((roomtype == null) ? 0 : roomtype.hashCode());
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
		Chatroom other = (Chatroom) obj;
		
		if (id != other.id)
			return false;
		if (maxusers != other.maxusers)
			return false;
		if (roomname == null) {
			if (other.roomname != null)
				return false;
		} else if (!roomname.equals(other.roomname))
			return false;
		if (roomtype == null) {
			if (other.roomtype != null)
				return false;
		} else if (!roomtype.equals(other.roomtype))
			return false;
		return true;
	}

	
/*
	public ChatMessage getChat() {
		return chat;
	}

	public void setChat(ChatMessage chat) {
		this.chat = chat;
	}
*/
	public Chatroom() {
		super();
	}

	public Chatroom(long id, String roomname, String roomtype, int maxusers, User userr) {
		super();
		this.id = id;
		this.roomname = roomname;
		this.roomtype = roomtype;
		this.maxusers = maxusers;
	
	}



	public List<User> getUserrr() {
		return userrr;
	}



	public void setUserrr(List<User> userrr) {
		this.userrr = userrr;
	}






	

	
}
