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
@Table(name = "service_offer_tx")
public class ServiceOfferTx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name ="service_offer_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ServiceOffer serviceOfferTxParent;
	
	@JoinColumn(name = "recipient_user_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private User serviceOfferRecipient;
	
	@Column(name = "recipient_request")
	private Timestamp recipientRequest;
	
	@Column(name = "provider_accept_request")
	private Timestamp providerAcceptRequest;
	
	@Column(name = "provider_reject_request")
	private Timestamp providerRejectRequest;
	
	@Column(name = "recipient_service_complete")
	private Timestamp recipientServiceComplete;
	
	@Column(name = "recipient_hour_offer")
	private double recipientHourOffer;
	
	@Column(name = "provider_service_complete")
	private Timestamp providerServiceComplete;
	
	@Column(name = "provider_hour_request")
	private double providerHourRequest;
	
	@Column(name = "hours_exchanged")
	private double hoursExchanged;
	
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

	public ServiceOffer getServiceOfferTxParent() {
		return serviceOfferTxParent;
	}

	public void setServiceOfferTxParent(ServiceOffer serviceOfferTxParent) {
		this.serviceOfferTxParent = serviceOfferTxParent;
	}

	public User getServiceOfferRecipient() {
		return serviceOfferRecipient;
	}

	public void setServiceOfferRecipient(User serviceOfferRecipient) {
		this.serviceOfferRecipient = serviceOfferRecipient;
	}

	public Timestamp getRecipientRequest() {
		return recipientRequest;
	}

	public void setRecipientRequest(Timestamp recipientRequest) {
		this.recipientRequest = recipientRequest;
	}

	public Timestamp getProviderAcceptRequest() {
		return providerAcceptRequest;
	}

	public void setProviderAcceptRequest(Timestamp providerAcceptRequest) {
		this.providerAcceptRequest = providerAcceptRequest;
	}

	public Timestamp getProviderRejectRequest() {
		return providerRejectRequest;
	}

	public void setProviderRejectRequest(Timestamp providerRejectRequest) {
		this.providerRejectRequest = providerRejectRequest;
	}

	public Timestamp getRecipientServiceComplete() {
		return recipientServiceComplete;
	}

	public void setRecipientServiceComplete(Timestamp recipientServiceComplete) {
		this.recipientServiceComplete = recipientServiceComplete;
	}

	public double getRecipientHourOffer() {
		return recipientHourOffer;
	}

	public void setRecipientHourOffer(double recipientHourOffer) {
		this.recipientHourOffer = recipientHourOffer;
	}

	public Timestamp getProviderServiceComplete() {
		return providerServiceComplete;
	}

	public void setProviderServiceComplete(Timestamp providerServiceComplete) {
		this.providerServiceComplete = providerServiceComplete;
	}

	public double getProviderHourRequest() {
		return providerHourRequest;
	}

	public void setProviderHourRequest(double providerHourRequest) {
		this.providerHourRequest = providerHourRequest;
	}

	public double getHoursExchanged() {
		return hoursExchanged;
	}

	public void setHoursExchanged(double hoursExchanged) {
		this.hoursExchanged = hoursExchanged;
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
		ServiceOfferTx other = (ServiceOfferTx) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceOfferTx [id=").append(id).append(", recipientRequest=").append(recipientRequest)
				.append(", providerAcceptRequest=").append(providerAcceptRequest).append(", providerRejectRequest=")
				.append(providerRejectRequest).append("]");
		return builder.toString();
	}
	
}
