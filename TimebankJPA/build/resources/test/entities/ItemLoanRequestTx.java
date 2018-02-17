package entities;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_loan_request_tx")
public class ItemLoanRequestTx {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@JoinColumn(name = "item_loan_request_id")
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ItemLoanRequest itemLoanRequestTxParent;
	
	@JoinColumn(name = "lender_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private User itemLoanRequestTxLender;
	
	@Column(name = "created")
	private Timestamp created;
	
	@Column(name = "borrower_accept")
	private Timestamp borrowerAccept;
	
	@Column(name = "borrower_reject")
	private Timestamp borrowerReject;

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
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "closing_moderator_id")
	private User closingModerator;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemLoanRequest getItemLoanRequestTxParent() {
		return itemLoanRequestTxParent;
	}

	public void setItemLoanRequestTxParent(ItemLoanRequest itemLoanRequestTxParent) {
		this.itemLoanRequestTxParent = itemLoanRequestTxParent;
	}

	public User getItemLoanRequestTxLender() {
		return itemLoanRequestTxLender;
	}

	public void setItemLoanRequestTxLender(User itemLoanRequestTxLender) {
		this.itemLoanRequestTxLender = itemLoanRequestTxLender;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getBorrowerAccept() {
		return borrowerAccept;
	}

	public void setBorrowerAccept(Timestamp borrowerAccept) {
		this.borrowerAccept = borrowerAccept;
	}

	public Timestamp getBorrowerReject() {
		return borrowerReject;
	}

	public void setBorrowerReject(Timestamp borrowerReject) {
		this.borrowerReject = borrowerReject;
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

	public int getRenewCount() {
		return renewCount;
	}

	public void setRenewCount(int renewCount) {
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
		ItemLoanRequestTx other = (ItemLoanRequestTx) obj;
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
		builder.append("ItemLoanRequestTx [id=").append(id).append(", created=").append(created)
				.append(", borrowerAccept=").append(borrowerAccept).append(", borrowerReject=").append(borrowerReject)
				.append("]");
		return builder.toString();
	}

}
