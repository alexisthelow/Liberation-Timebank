package entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import interfaces.Activity;

@Entity
@Table(name = "service_offer_activity")
public class ServiceOfferActivity implements Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "service_offer_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ServiceOffer serviceOfferActivityParent;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "user_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User serviceOfferActivityUser;
	
	private String message;
	
	private Timestamp posted;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	@Column(name = "moderator_hide")
	private Boolean moderatorHide;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hiding_moderator_id")
	private User hidingModerator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceOffer getServiceOfferActivityParent() {
		return serviceOfferActivityParent;
	}

	public void setServiceOfferActivityParent(ServiceOffer serviceOfferActivityParent) {
		this.serviceOfferActivityParent = serviceOfferActivityParent;
	}

	public User getServiceOfferActivityUser() {
		return serviceOfferActivityUser;
	}

	public void setServiceOfferActivityUser(User serviceOfferActivityUser) {
		this.serviceOfferActivityUser = serviceOfferActivityUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public User getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Boolean getModeratorHide() {
		return moderatorHide;
	}

	public void setModeratorHide(Boolean moderatorHide) {
		this.moderatorHide = moderatorHide;
	}

	public User getHidingModerator() {
		return hidingModerator;
	}

	public void setHidingModerator(User hidingModerator) {
		this.hidingModerator = hidingModerator;
	}
	
	@Override
	public Object getParent() {
		return this.serviceOfferActivityParent;
	}

	@Override
	public User getUser() {
		return this.serviceOfferActivityUser;
	}
	
	@Override
	public void setParent(Object parent) {
		this.serviceOfferActivityParent = (ServiceOffer) parent;
	}

	@Override
	public void setUser(User user) {
		this.serviceOfferActivityUser = user;
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
		ServiceOfferActivity other = (ServiceOfferActivity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceOfferActivity [id=").append(id).append(", posted=").append(posted).append("]");
		return builder.toString();
	}
	
}
