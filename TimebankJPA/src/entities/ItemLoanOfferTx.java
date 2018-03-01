package entities;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import interfaces.Loan;
import interfaces.Transaction;

@Entity
@Table(name = "item_loan_offer_tx")
public class ItemLoanOfferTx implements Loan, Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "item_loan_offer_id")
	private ItemLoanOffer itemLoanOfferTxParent;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "borrower_id")
	private User itemLoanOfferTxBorrower;
	
	@Column(name = "created")
	private Timestamp created;
	
	@Column(name = "days_requested")
	private Integer daysRequested;
	
	@Column(name = "lender_accept")
	private Timestamp lenderAccept;
	
	@Column(name = "days_provided")
	private Integer daysProvided;
	
	@Column(name = "lender_reject")
	private Timestamp lenderReject;
	
	@Column(name = "borrower_start")
	private Timestamp borrowerStart;
	
	@Column(name = "lender_start")
	private Timestamp lenderStart;
	
	@Column(name = "begin_date")
	private Date beginDate;
	
	@Column(name = "renew_count")
	private int renewCount;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "borrower_complete")
	private Timestamp borrowerComplete;
	
	@Column(name = "lender_complete")
	private Timestamp lenderComplete;
	
	@Column(name = "moderator_closed")
	private Boolean moderatorClosed;

	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "closing_moderator_id")
	private User closingModerator;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemLoanOffer getItemLoanOfferTxParent() {
		return itemLoanOfferTxParent;
	}

	public void setItemLoanOfferTxParent(ItemLoanOffer itemLoanOfferTxParent) {
		this.itemLoanOfferTxParent = itemLoanOfferTxParent;
	}

	public User getItemLoanOfferTxBorrower() {
		return itemLoanOfferTxBorrower;
	}

	public void setItemLoanOfferTxBorrower(User itemLoanOfferTxBorrower) {
		this.itemLoanOfferTxBorrower = itemLoanOfferTxBorrower;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getDaysRequested() {
		return daysRequested;
	}

	public void setDaysRequested(Integer daysRequested) {
		this.daysRequested = daysRequested;
	}

	public Timestamp getLenderAccept() {
		return lenderAccept;
	}

	public void setLenderAccept(Timestamp lenderAccept) {
		this.lenderAccept = lenderAccept;
	}

	public Integer getDaysProvided() {
		return daysProvided;
	}

	public void setDaysProvided(Integer daysProvided) {
		this.daysProvided = daysProvided;
	}

	public Timestamp getLenderReject() {
		return lenderReject;
	}

	public void setLenderReject(Timestamp lenderReject) {
		this.lenderReject = lenderReject;
	}

	public Timestamp getBorrowerStart() {
		return borrowerStart;
	}

	public void setBorrowerStart(Timestamp borrowerStart) {
		this.borrowerStart = borrowerStart;
	}

	public Timestamp getLenderStart() {
		return lenderStart;
	}

	public void setLenderStart(Timestamp lenderStart) {
		this.lenderStart = lenderStart;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getRenewCount() {
		return renewCount;
	}

	public void setRenewCount(Integer renewCount) {
		this.renewCount = renewCount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getBorrowerComplete() {
		return borrowerComplete;
	}

	public void setBorrowerComplete(Timestamp borrowerComplete) {
		this.borrowerComplete = borrowerComplete;
	}

	public Timestamp getLenderComplete() {
		return lenderComplete;
	}

	public void setLenderComplete(Timestamp lenderComplete) {
		this.lenderComplete = lenderComplete;
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
	
	@Override
	public Object getParent() {
		return this.itemLoanOfferTxParent;
	}

	@Override
	public User getOwner() {
		return this.itemLoanOfferTxBorrower;
	}

	@Override
	public Timestamp getParentUserAccept() {
		return this.lenderAccept;
	}

	@Override
	public Timestamp getParentUserReject() {
		return this.lenderReject;
	}

	@Override
	public Timestamp getOwnerComplete() {
		return this.borrowerComplete;
	}

	@Override
	public Timestamp getParentUserComplete() {
		return this.lenderComplete;
	}
	
	@Override
	public void setParent(Object parent) {
		this.itemLoanOfferTxParent = (ItemLoanOffer) parent;
	}

	@Override
	public void setOwner(User owner) {
		this.itemLoanOfferTxBorrower = owner;
	}

	@Override
	public void setParentUserAccept(Timestamp accept) {
		this.lenderAccept = accept;
	}

	@Override
	public void setParentUserReject(Timestamp reject) {
		this.lenderReject = reject;
	}

	@Override
	public void setOwnerComplete(Timestamp complete) {
		this.borrowerComplete = complete;
	}

	@Override
	public void setParentUserComplete(Timestamp complete) {
		this.lenderComplete = complete;
	}
	
	@Override
	public Timestamp getParentUserStart() {
		return this.lenderStart;
	}

	@Override
	public void setParentUserStart(Timestamp start) {
		this.lenderStart = start;
	}

	@Override
	public Timestamp getOwnerStart() {
		return this.borrowerStart;
	}

	@Override
	public void setOwnerStart(Timestamp start) {
		this.borrowerStart = start;
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
		ItemLoanOfferTx other = (ItemLoanOfferTx) obj;
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
		builder.append("ItemLoanOfferTx [id=").append(id).append(", created=").append(created).append(", lenderAccept=")
				.append(lenderAccept).append(", lenderReject=").append(lenderReject).append("]");
		return builder.toString();
	}
	
}
