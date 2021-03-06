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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_transfer_offer_tx")
public class ItemTransferOfferTx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_transfer_offer_id")
	private ItemTransferOffer itemTransferOfferTxParent;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "recipient_user_id")
	private User itemTransferOfferTxRecipient;
	
	@Column(name = "create_timestamp")
	private Timestamp createTimestamp;
	
	@Column(name = "recipient_accept_timestamp")
	private Timestamp recipientAcceptTimestamp;
	
	@Column(name = "provider_accept_timestamp")
	private Timestamp providerAcceptTimestamp;
	
	@Column(name = "complete_timestamp")
	private Timestamp completeTimestamp;
	
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

	



}
