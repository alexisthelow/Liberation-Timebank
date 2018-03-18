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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import interfaces.Activity;
import interfaces.Item;
import interfaces.Request;
import interfaces.Transaction;

@Entity
@Table(name = "item_loan_request")
public class ItemLoanRequest implements Item, Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "timebank_id")
	private Timebank itemLoanRequestTimebank;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "borrower_id")
	private User itemLoanRequestUser;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private ItemCategory itemLoanRequestCategory;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "subcategory_id")
	private ItemSubcategory itemLoanRequestSubcategory;
	
	@Column(name = "days_requested")
	private int daysRequested;
	
	private String title;
	
	private String description;
	
	private Timestamp created;
	
	@Column(name = "global_visibility")
	private Boolean globalVisibility;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	private Boolean active;
	
	@Column(name = "moderator_closed")
	private Boolean moderatorClosed;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "closing_moderator_id")
	private User closingModerator;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanRequestActivityParent", cascade = CascadeType.PERSIST)
	private List<ItemLoanRequestActivity> itemLoanRequestActivities;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToOne(mappedBy = "itemLoanRequestTxParent", cascade = CascadeType.PERSIST)
	private ItemLoanRequestTx itemLoanRequestTx;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timebank getItemLoanRequestTimebank() {
		return itemLoanRequestTimebank;
	}

	public void setItemLoanRequestTimebank(Timebank itemLoanRequestTimebank) {
		this.itemLoanRequestTimebank = itemLoanRequestTimebank;
	}

	public User getItemLoanRequestUser() {
		return itemLoanRequestUser;
	}

	public void setItemLoanRequestUser(User itemLoanRequestUser) {
		this.itemLoanRequestUser = itemLoanRequestUser;
	}

	public ItemCategory getItemLoanRequestCategory() {
		return itemLoanRequestCategory;
	}

	public void setItemLoanRequestCategory(ItemCategory itemLoanRequestCategory) {
		this.itemLoanRequestCategory = itemLoanRequestCategory;
	}

	public ItemSubcategory getItemLoanRequestSubcategory() {
		return itemLoanRequestSubcategory;
	}

	public void setItemLoanRequestSubcategory(ItemSubcategory itemLoanRequestSubcategory) {
		this.itemLoanRequestSubcategory = itemLoanRequestSubcategory;
	}

	public int getDaysRequested() {
		return daysRequested;
	}

	public void setDaysRequested(int daysRequested) {
		this.daysRequested = daysRequested;
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
	
	public Boolean getGlobalVisibility() {
		return globalVisibility;
	}

	public void setGlobalVisibility(Boolean globalVisibility) {
		this.globalVisibility = globalVisibility;
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

	public List<ItemLoanRequestActivity> getItemLoanRequestActivities() {
		return itemLoanRequestActivities;
	}

	public void setItemLoanRequestActivities(List<ItemLoanRequestActivity> itemLoanRequestActivities) {
		this.itemLoanRequestActivities = itemLoanRequestActivities;
	}

	public ItemLoanRequestTx getItemLoanRequestTx() {
		return itemLoanRequestTx;
	}

	public void setItemLoanRequestTx(ItemLoanRequestTx itemLoanRequestTx) {
		this.itemLoanRequestTx = itemLoanRequestTx;
	}
	
	@Override
	public Timebank getTimebank() {
		return this.itemLoanRequestTimebank;
	}

	@Override
	public User getOwner() {
		return this.itemLoanRequestUser;
	}

	@Override
	public List<Transaction> getTransactions() {
		return null;
	}

	@Override
	public List<Activity> getActivity() {
		return null;
	}
	
	@Override
	public void setTimebank(Timebank timebank) {
		this.itemLoanRequestTimebank = timebank;
	}

	@Override
	public void setOwner(User owner) {
		this.itemLoanRequestUser = owner;
	}

	@Override
	public ItemCategory getCategory() {
		return this.itemLoanRequestCategory;
	}

	@Override
	public void setItemCategory(ItemCategory category) {
		this.itemLoanRequestCategory = category;
	}

	@Override
	public ItemSubcategory getSubcategory() {
		return this.itemLoanRequestSubcategory;
	}

	@Override
	public void setItemSubcategory(ItemSubcategory subcategory) {
		this.itemLoanRequestSubcategory = subcategory;
	}

	@Override
	public void setActivity(List<Activity> activity) {
	}

	@Override
	public void setTransactions(List<Transaction> transactions) {
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
		ItemLoanRequest other = (ItemLoanRequest) obj;
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
		builder.append("ItemLoanRequest [id=").append(id).append(", title=").append(title).append(", created=")
				.append(created).append(", active=").append(active).append("]");
		return builder.toString();
	}

 }
