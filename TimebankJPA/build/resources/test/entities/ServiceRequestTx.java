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
@Table(name = "service_request_tx")
public class ServiceRequestTx {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "service_request_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ServiceRequest serviceRequestTxParent;
	
	@JoinColumn(name = "service_request_time_window_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ServiceRequestTimeWindow serviceRequestTxTimeWindow;

	@JoinColumn(name = "provider_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private User serviceRequestProvider;
	
	@Column(name = "provider_accept_request")
	private Timestamp providerAcceptRequest;
	
	@Column(name = "recipient_accept_provider")
	private Timestamp recipientAcceptProvider;
	
	@Column(name = "recipient_reject_provider")
	private Timestamp recipientRejectProvider;
	
	@Column(name = "recipient_cancel")
	private Timestamp recipientCancel;
	
	@Column(name = "provider_cancel")
	private Timestamp providerCancel;
	
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

	public ServiceRequest getServiceRequestTxParent() {
		return serviceRequestTxParent;
	}

	public void setServiceRequestTxParent(ServiceRequest serviceRequestTxParent) {
		this.serviceRequestTxParent = serviceRequestTxParent;
	}

	public ServiceRequestTimeWindow getServiceRequestTxTimeWindow() {
		return serviceRequestTxTimeWindow;
	}

	public void setServiceRequestTxTimeWindow(ServiceRequestTimeWindow serviceRequestTxTimeWindow) {
		this.serviceRequestTxTimeWindow = serviceRequestTxTimeWindow;
	}

	public User getServiceRequestProvider() {
		return serviceRequestProvider;
	}

	public void setServiceRequestProvider(User serviceRequestProvider) {
		this.serviceRequestProvider = serviceRequestProvider;
	}

	public Timestamp getProviderAcceptRequest() {
		return providerAcceptRequest;
	}

	public void setProviderAcceptRequest(Timestamp providerAcceptRequest) {
		this.providerAcceptRequest = providerAcceptRequest;
	}

	public Timestamp getRecipientAcceptProvider() {
		return recipientAcceptProvider;
	}

	public void setRecipientAcceptProvider(Timestamp recipientAcceptProvider) {
		this.recipientAcceptProvider = recipientAcceptProvider;
	}

	public Timestamp getRecipientRejectProvider() {
		return recipientRejectProvider;
	}

	public void setRecipientRejectProvider(Timestamp recipientRejectProvider) {
		this.recipientRejectProvider = recipientRejectProvider;
	}

	public Timestamp getRecipientCancel() {
		return recipientCancel;
	}

	public void setRecipientCancel(Timestamp recipientCancel) {
		this.recipientCancel = recipientCancel;
	}

	public Timestamp getProviderCancel() {
		return providerCancel;
	}

	public void setProviderCancel(Timestamp providerCancel) {
		this.providerCancel = providerCancel;
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
		ServiceRequestTx other = (ServiceRequestTx) obj;
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
		builder.append("ServiceRequestTx [id=").append(id).append(", lastUpdate=").append(lastUpdate).append("]");
		return builder.toString();
	}
	
}
