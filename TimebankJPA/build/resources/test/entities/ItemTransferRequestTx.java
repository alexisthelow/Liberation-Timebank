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
@Table(name = "item_transfer_request_tx")
public class ItemTransferRequestTx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_transfer_request_id")
	private ItemTransferRequest itemTransferRequestTxParent;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "provider_id")
	private User itemTransferRequestTxProvider;
	
	private Timestamp created;
	
	@Column(name = "recipient_accept")
	private Timestamp recipientAccept;

	@Column(name = "recipient_reject")
	private Timestamp recipientReject;
	
	@Column(name = "recipient_complete")
	private Timestamp recipientComplete;
	
	@Column(name = "provider_complete")
	private Timestamp providerComplete;
	
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

	public ItemTransferRequest getItemTransferRequestTxParent() {
		return itemTransferRequestTxParent;
	}

	public void setItemTransferRequestTxParent(ItemTransferRequest itemTransferRequestTxParent) {
		this.itemTransferRequestTxParent = itemTransferRequestTxParent;
	}

	public User getItemTransferRequestTxProvider() {
		return itemTransferRequestTxProvider;
	}

	public void setItemTransferRequestTxProvider(User itemTransferRequestTxProvider) {
		this.itemTransferRequestTxProvider = itemTransferRequestTxProvider;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getRecipientAccept() {
		return recipientAccept;
	}

	public void setRecipientAccept(Timestamp recipientAccept) {
		this.recipientAccept = recipientAccept;
	}

	public Timestamp getRecipientReject() {
		return recipientReject;
	}

	public void setRecipientReject(Timestamp recipientReject) {
		this.recipientReject = recipientReject;
	}

	public Timestamp getRecipientComplete() {
		return recipientComplete;
	}

	public void setRecipientComplete(Timestamp recipientComplete) {
		this.recipientComplete = recipientComplete;
	}

	public Timestamp getProviderComplete() {
		return providerComplete;
	}

	public void setProviderComplete(Timestamp providerComplete) {
		this.providerComplete = providerComplete;
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
		ItemTransferRequestTx other = (ItemTransferRequestTx) obj;
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
		builder.append("ItemTransferRequestTx [id=").append(id).append(", created=").append(created)
				.append(", recipientAccept=").append(recipientAccept).append(", recipientReject=")
				.append(recipientReject).append("]");
		return builder.toString();
	}
	
}