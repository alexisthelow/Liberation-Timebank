package entities;

import java.sql.Date;
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
@Table(name = "item_transfer_request")
public class ItemTransferRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "timebank_id")
	private Timebank itemTransferRequestTimebank;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User itemTransferRequestUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_category_id")
	private ItemCategory itemTransferRequestCategory;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_subcategory_id")
	private ItemSubcategory itemTransferRequestSubcategory;
	
	private String title;
	
	private String description;
	
	private Date created;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	@Column(name = "moderator_closed")
	private Boolean moderatorClosed;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "closing_moderator_id")
	private User closingModerator;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestActivityParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemTransferRequestActivity> itemTransferRequestActivity;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestTxParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemTransferRequestTx> itemTransferRequestTx;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timebank getItemTransferRequestTimebank() {
		return itemTransferRequestTimebank;
	}

	public void setItemTransferRequestTimebank(Timebank itemTransferRequestTimebank) {
		this.itemTransferRequestTimebank = itemTransferRequestTimebank;
	}

	public User getItemTransferRequestUser() {
		return itemTransferRequestUser;
	}

	public void setItemTransferRequestUser(User itemTransferRequestUser) {
		this.itemTransferRequestUser = itemTransferRequestUser;
	}

	public ItemCategory getItemTransferRequestCategory() {
		return itemTransferRequestCategory;
	}

	public void setItemTransferRequestCategory(ItemCategory itemTransferRequestCategory) {
		this.itemTransferRequestCategory = itemTransferRequestCategory;
	}

	public ItemSubcategory getItemTransferRequestSubcategory() {
		return itemTransferRequestSubcategory;
	}

	public void setItemTransferRequestSubcategory(ItemSubcategory itemTransferRequestSubcategory) {
		this.itemTransferRequestSubcategory = itemTransferRequestSubcategory;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
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

	public List<ItemTransferRequestActivity> getItemTransferRequestActivity() {
		return itemTransferRequestActivity;
	}

	public void setItemTransferRequestActivity(List<ItemTransferRequestActivity> itemTransferRequestActivity) {
		this.itemTransferRequestActivity = itemTransferRequestActivity;
	}

	public List<ItemTransferRequestTx> getItemTransferRequestTx() {
		return itemTransferRequestTx;
	}

	public void setItemTransferRequestTx(List<ItemTransferRequestTx> itemTransferRequestTx) {
		this.itemTransferRequestTx = itemTransferRequestTx;
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
		ItemTransferRequest other = (ItemTransferRequest) obj;
		if (id != other.id)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

}
