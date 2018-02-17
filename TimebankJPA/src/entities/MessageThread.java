package entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "message_thread")
public class MessageThread {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "created")
	private Timestamp created;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "message_thread_participant", joinColumns = @JoinColumn(name = "message_thread_id"), inverseJoinColumns = @JoinColumn(name = "participant_id"))
	private List<User> messageThreadParticipants;

	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "parentMessageThread", cascade = CascadeType.PERSIST)
	private List<Reply> messageThreadReplies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public List<User> getMessageThreadParticipants() {
		return messageThreadParticipants;
	}

	public void setMessageThreadParticipants(List<User> messageThreadParticipants) {
		this.messageThreadParticipants = messageThreadParticipants;
	}

	public List<Reply> getMessageThreadReplies() {
		return messageThreadReplies;
	}

	public void setMessageThreadReplies(List<Reply> messageThreadReplies) {
		this.messageThreadReplies = messageThreadReplies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		MessageThread other = (MessageThread) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageThread [id=").append(id).append(", created=").append(created).append("]");
		return builder.toString();
	}
	
}
