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
import interfaces.Location;
import interfaces.Request;
import interfaces.Service;
import interfaces.Transaction;

@Entity
@Table(name = "service_request")
public class ServiceRequest implements Service, Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "timebank_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Timebank serviceRequestTimebank;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User serviceRequestUser;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceRequestCategory;

	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "subcategory_id")
	private ServiceSubcategory serviceRequestSubcategory;
	
	private String title;
	
	private String description;
	
	@Column(name = "global_visibility")
	private Boolean globalVisibility;
	
	@Column(name = "requires_supplies")
	private Boolean requiresSupplies;
	
	@Column(name = "supply_cost_estimate")
	private Integer supplyCostEstimate;
	
	private Timestamp created;
	
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
	@OneToMany(mappedBy = "serviceRequestTimeWindowParent", cascade = CascadeType.PERSIST)
	private List<ServiceRequestTimeWindow> serviceRequestTimeWindows;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestOriginParent", cascade = CascadeType.PERSIST)
	private List<ServiceRequestOrigin> serviceRequestOrigins;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestDestinationParent", cascade = CascadeType.PERSIST)
	private List<ServiceRequestDestination> serviceRequestDestinations;

	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestTxParent", cascade = CascadeType.PERSIST)
	private List<ServiceRequestTx> serviceRequestTxs;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestActivityParent", cascade = CascadeType.PERSIST)
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

	public Integer getSupplyCostEstimate() {
		return supplyCostEstimate;
	}

	public void setSupplyCostEstimate(Integer supplyCostEstimate) {
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
	public Timebank getTimebank() {
		return this.serviceRequestTimebank;
	}

	@Override
	public User getOwner() {
		return this.serviceRequestUser;
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
	public ServiceCategory getCategory() {
		return this.serviceRequestCategory;
	}

	@Override
	public ServiceSubcategory getSubcategory() {
		return this.serviceRequestSubcategory;
	}

	@Override
	public List<Location> getOrigins() {
		return null;
	}

	@Override
	public List<Location> getDestinations() {
		return null;
	}
	
	@Override
	public void setTimebank(Timebank timebank) {
		this.serviceRequestTimebank = timebank;
	}

	@Override
	public void setOwner(User owner) {
		this.serviceRequestUser = owner;
	}

	@Override
	public void setTransactions(List<Transaction> transactions) {
	}

	@Override
	public void setActivity(List<Activity> activity) {
	}

	@Override
	public void setCategory(ServiceCategory category) {
		this.serviceRequestCategory = category;
	}

	@Override
	public void setSubcategory(ServiceSubcategory subcategory) {
		this.serviceRequestSubcategory = subcategory;
	}

	@Override
	public void setOrigins(List<Location> origins) {
	}

	@Override
	public void setDestinations(List<Location> destinations) {
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