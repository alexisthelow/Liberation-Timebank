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
@Table(name = "service_offer")
public class ServiceOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "timebank_id")
	private Timebank serviceOfferTimebank;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User serviceOfferUser;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceOfferCategory;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "subcategory_id")
	private ServiceSubcategory serviceOfferSubcategory;
	
	private String title;
	
	private String description;
	
	@Column(name = "global_visibility")
	private Boolean globalVisibility;
	
	@Column(name = "requires_supplies")
	private Boolean requiresSupplies;
	
	@Column(name = "supply_cost_estimate")
	private int supplyCostEstimate;
	
	@Column(name = "created")
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
	@OneToOne(mappedBy = "serviceOfferScheduleParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ServiceOfferSchedule serviceOfferSchedule;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferOriginParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOfferOrigin> serviceOfferOrigins;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferDestinationParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOfferDestination> serviceOfferDestinations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferTxParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOfferTx> serviceOfferTxs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferActivityParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOfferActivity> serviceOfferActivities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timebank getServiceOfferTimebank() {
		return serviceOfferTimebank;
	}

	public void setServiceOfferTimebank(Timebank serviceOfferTimebank) {
		this.serviceOfferTimebank = serviceOfferTimebank;
	}

	public User getServiceOfferUser() {
		return serviceOfferUser;
	}

	public void setServiceOfferUser(User serviceOfferUser) {
		this.serviceOfferUser = serviceOfferUser;
	}

	public ServiceCategory getServiceOfferCategory() {
		return serviceOfferCategory;
	}

	public void setServiceOfferCategory(ServiceCategory serviceOfferCategory) {
		this.serviceOfferCategory = serviceOfferCategory;
	}

	public ServiceSubcategory getServiceOfferSubcategory() {
		return serviceOfferSubcategory;
	}

	public void setServiceOfferSubcategory(ServiceSubcategory serviceOfferSubcategory) {
		this.serviceOfferSubcategory = serviceOfferSubcategory;
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

	public ServiceOfferSchedule getServiceOfferSchedule() {
		return serviceOfferSchedule;
	}

	public void setServiceOfferSchedule(ServiceOfferSchedule serviceOfferSchedule) {
		this.serviceOfferSchedule = serviceOfferSchedule;
	}

	public List<ServiceOfferOrigin> getServiceOfferOrigins() {
		return serviceOfferOrigins;
	}

	public void setServiceOfferOrigins(List<ServiceOfferOrigin> serviceOfferOrigins) {
		this.serviceOfferOrigins = serviceOfferOrigins;
	}

	public List<ServiceOfferDestination> getServiceOfferDestinations() {
		return serviceOfferDestinations;
	}

	public void setServiceOfferDestinations(List<ServiceOfferDestination> serviceOfferDestinations) {
		this.serviceOfferDestinations = serviceOfferDestinations;
	}

	public List<ServiceOfferTx> getServiceOfferTxs() {
		return serviceOfferTxs;
	}

	public void setServiceOfferTxs(List<ServiceOfferTx> serviceOfferTxs) {
		this.serviceOfferTxs = serviceOfferTxs;
	}

	public List<ServiceOfferActivity> getServiceOfferActivities() {
		return serviceOfferActivities;
	}

	public void setServiceOfferActivities(List<ServiceOfferActivity> serviceOfferActivities) {
		this.serviceOfferActivities = serviceOfferActivities;
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
		ServiceOffer other = (ServiceOffer) obj;
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
		builder.append("ServiceOffer [id=").append(id).append(", title=").append(title).append(", created=")
				.append(created).append(", active=").append(active).append("]");
		return builder.toString();
	}
	
}
