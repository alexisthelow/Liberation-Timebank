package entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_loan_offer_activity")
public class ItemLoanOfferActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_loan_offer_id")
	private ItemLoanOffer itemLoanOfferActivityParent;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User itemLoanOfferActivityUser;
	
	private String message;
	
	@Column(name = "posted")
	private Timestamp posted;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	@Column(name = "moderator_hide")
	private Boolean moderatorHide;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "hiding_moderator_id")
	private User hidingModerator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemLoanOffer getItemLoanOfferActivityParent() {
		return itemLoanOfferActivityParent;
	}

	public void setItemLoanOfferActivityParent(ItemLoanOffer itemLoanOfferActivityParent) {
		this.itemLoanOfferActivityParent = itemLoanOfferActivityParent;
	}

	public User getItemLoanOfferActivityUser() {
		return itemLoanOfferActivityUser;
	}

	public void setItemLoanOfferActivityUser(User itemLoanOfferActivityUser) {
		this.itemLoanOfferActivityUser = itemLoanOfferActivityUser;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
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
		ItemLoanOfferActivity other = (ItemLoanOfferActivity) obj;
		if (id != other.id)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemLoanOfferActivity [id=").append(id).append(", message=").append(message).append(", posted=")
				.append(posted).append("]");
		return builder.toString();
	}

}
