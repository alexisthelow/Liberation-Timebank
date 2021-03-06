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
@Table(name = "service_request")
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "timebank_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Timebank serviceRequestTimebank;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User serviceRequestUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceRequestCategory;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "subcategory_id")
	private ServiceSubcategory serviceRequestSubcategory;
	
	private String title;
	
	private String description;
	
	@Column(name = "global_visibility")
	private Boolean globalVisibility;
	
	@Column(name = "requires_supplies")
	private Boolean requiresSupplies;
	
	@Column(name = "supply_cost_estimate")
	private int supplyCostEstimate;
	
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

	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestTimeWindowParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceRequestTimeWindow> serviceRequestTimeWindows;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestOriginParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceRequestOrigin> serviceRequestOrigins;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestDestinationParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceRequestDestination> serviceRequestDestinations;

	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestTxParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceRequestTx> serviceRequestTxs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestActivityParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceRequestActivity> serviceRequestActivities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timebank getServiceRequestTimebank() {
		return serviceRequestTimebank;
	}

	public void setServiceRequestTimebank(Timebank serviceRequestTimebank) {
		this.serviceRequestTimebank = serviceRequestTimebank;
	}

	public User getServiceRequestUser() {
		return serviceRequestUser;
	}

	public void setServiceRequestUser(User serviceRequestUser) {
		this.serviceRequestUser = serviceRequestUser;
	}

	public ServiceCategory getServiceRequestCategory() {
		return serviceRequestCategory;
	}

	public void setServiceRequestCategory(ServiceCategory serviceRequestCategory) {
		this.serviceRequestCategory = serviceRequestCategory;
	}

	public ServiceSubcategory getServiceRequestSubcategory() {
		return serviceRequestSubcategory;
	}

	public void setServiceRequestSubcategory(ServiceSubcategory serviceRequestSubcategory) {
		this.serviceRequestSubcategory = serviceRequestSubcategory;
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

	public Boolean getGlobalVisibility() {
		return globalVisibility;
	}

	public void setGlobalVisibility(Boolean globalVisibility) {
		this.globalVisibility = globalVisibility;
	}

	public Boolean getRequiresSupplies() {
		return requiresSupplies;
	}

	public void setRequiresSupplies(Boolean requiresSupplies) {
		this.requiresSupplies = requiresSupplies;
	}

	public int getSupplyCostEstimate() {
		return supplyCostEstimate;
	}

	public void setSupplyCostEstimate(int supplyCostEstimate) {
		this.supplyCostEstimate = supplyCostEstimate;
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

	public List<ServiceRequestTimeWindow> getServiceRequestTimeWindows() {
		return serviceRequestTimeWindows;
	}

	public void setServiceRequestTimeWindows(List<ServiceRequestTimeWindow> serviceRequestTimeWindows) {
		this.serviceRequestTimeWindows = serviceRequestTimeWindows;
	}

	public List<ServiceRequestOrigin> getServiceRequestOrigins() {
		return serviceRequestOrigins;
	}

	public void setServiceRequestOrigins(List<ServiceRequestOrigin> serviceRequestOrigins) {
		this.serviceRequestOrigins = serviceRequestOrigins;
	}

	public List<ServiceRequestDestination> getServiceRequestDestinations() {
		return serviceRequestDestinations;
	}

	public void setServiceRequestDestinations(List<ServiceRequestDestination> serviceRequestDestinations) {
		this.serviceRequestDestinations = serviceRequestDestinations;
	}

	public List<ServiceRequestTx> getServiceRequestTxs() {
		return serviceRequestTxs;
	}

	public void setServiceRequestTxs(List<ServiceRequestTx> serviceRequestTxs) {
		this.serviceRequestTxs = serviceRequestTxs;
	}

	public List<ServiceRequestActivity> getServiceRequestActivities() {
		return serviceRequestActivities;
	}

	public void setServiceRequestActivities(List<ServiceRequestActivity> serviceRequestActivities) {
		this.serviceRequestActivities = serviceRequestActivities;
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
		ServiceRequest other = (ServiceRequest) obj;
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
		builder.append("ServiceRequest [id=").append(id).append(", title=").append(title).append(", active=")
				.append(active).append("]");
		return builder.toString();
	}
	
}