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
@Table(name = "item_transfer_offer")
public class ItemTransferOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "timebank_id")
	private Timebank itemTransferOfferTimebank;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User itemTransferOfferUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_category_id")
	private ItemCategory itemTransferOfferCategory;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_subcategory_id")
	private ItemSubcategory itemTransferOfferSubcategory;
	
	private String title;
	
	private String description;
	
	@Column(name = "created")
	private Timestamp created;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	private Boolean active;
	
	@Column(name = "moderator_closed")
	private Boolean moderatorClosed;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "closing_moderator_id")
	private User closingModerator;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timebank getItemTransferOfferTimebank() {
		return itemTransferOfferTimebank;
	}

	public void setItemTransferOfferTimebank(Timebank itemTransferOfferTimebank) {
		this.itemTransferOfferTimebank = itemTransferOfferTimebank;
	}

	public User getItemTransferOfferUser() {
		return itemTransferOfferUser;
	}

	public void setItemTransferOfferUser(User itemTransferOfferUser) {
		this.itemTransferOfferUser = itemTransferOfferUser;
	}

	public ItemCategory getItemTransferOfferCategory() {
		return itemTransferOfferCategory;
	}

	public void setItemTransferOfferCategory(ItemCategory itemTransferOfferCategory) {
		this.itemTransferOfferCategory = itemTransferOfferCategory;
	}

	public ItemSubcategory getItemTransferOfferSubcategory() {
		return itemTransferOfferSubcategory;
	}

	public void setItemTransferOfferSubcategory(ItemSubcategory itemTransferOfferSubcategory) {
		this.itemTransferOfferSubcategory = itemTransferOfferSubcategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getModeratorClosed() {
		return moderatorClosed;
	}

	public void setModeratorClosed(Boolean moderatorClosed) {
		this.moderatorClosed = moderatorClosed;
	}

	public User getClosingModerator() {
		return closingModerator;
	}

	public void setClosingModerator(User closingModerator) {
		this.closingModerator = closingModerator;
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
		ItemTransferOffer other = (ItemTransferOffer) obj;
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
		builder.append("ItemTransferOffer [id=").append(id).append(", title=").append(title).append(", created=")
				.append(created).append(", active=").append(active).append("]");
		return builder.toString();
	}

}
