package entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_loan_offer")
public class ItemLoanOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "timebank_id")
	private Timebank itemLoanOfferTimebank;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "lender_id")
	private User itemLoanOfferUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private ItemCategory itemLoanOfferCategory;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "subcategory_id")
	private ItemSubcategory itemLoanOfferSubcategory;
	
	private String title;
	
	private String description;
	
	private Timestamp created;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	private Boolean active;
	
	private Boolean available;

	@Column(name = "moderator_closed")
	private Boolean moderatorClosed;
	
	@JoinColumn(name = "closing_moderator_id")
	private User closingModerator;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferActivityParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemLoanOfferActivity> itemLoanOfferActivities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferTxParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemLoanOfferTx> itemLoanOfferTxs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timebank getItemLoanOfferTimebank() {
		return itemLoanOfferTimebank;
	}

	public void setItemLoanOfferTimebank(Timebank itemLoanOfferTimebank) {
		this.itemLoanOfferTimebank = itemLoanOfferTimebank;
	}

	public User getItemLoanOfferUser() {
		return itemLoanOfferUser;
	}

	public void setItemLoanOfferUser(User itemLoanOfferUser) {
		this.itemLoanOfferUser = itemLoanOfferUser;
	}

	public ItemCategory getItemLoanOfferCategory() {
		return itemLoanOfferCategory;
	}

	public void setItemLoanOfferCategory(ItemCategory itemLoanOfferCategory) {
		this.itemLoanOfferCategory = itemLoanOfferCategory;
	}

	public ItemSubcategory getItemLoanOfferSubcategory() {
		return itemLoanOfferSubcategory;
	}

	public void setItemLoanOfferSubcategory(ItemSubcategory itemLoanOfferSubcategory) {
		this.itemLoanOfferSubcategory = itemLoanOfferSubcategory;
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

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
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

	public List<ItemLoanOfferActivity> getItemLoanOfferActivities() {
		return itemLoanOfferActivities;
	}

	public void setItemLoanOfferActivities(List<ItemLoanOfferActivity> itemLoanOfferActivities) {
		this.itemLoanOfferActivities = itemLoanOfferActivities;
	}

	public List<ItemLoanOfferTx> getItemLoanOfferTxs() {
		return itemLoanOfferTxs;
	}

	public void setItemLoanOfferTxs(List<ItemLoanOfferTx> itemLoanOfferTxs) {
		this.itemLoanOfferTxs = itemLoanOfferTxs;
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
		ItemLoanOffer other = (ItemLoanOffer) obj;
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
		builder.append("ItemLoanOffer [id=").append(id).append(", title=").append(title).append(", created=")
				.append(created).append(", active=").append(active).append("]");
		return builder.toString();
	}

}
