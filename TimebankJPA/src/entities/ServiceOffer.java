package entities;

import java.sql.Timestamp;
import java.util.Set;

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

@Entity
@Table(name = "service_offer")
public class ServiceOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "timebank_id")
	private Timebank serviceOfferTimebank;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User serviceOfferUser;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceOfferCategory;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "subcategory_id")
	private ServiceSubcategory serviceOfferSubcategory;
	
	private String title;
	
	private String description;
	
	@Column(name = "global_visibility")
	private Boolean globalVisibility;
	
	@Column(name = "requires_supplies")
	private Boolean requiresSupplies;
	
	@Column(name = "supply_cost_estimate")
	private Integer supplyCostEstimate;
	
	@Column(name = "created")
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
	@OneToOne(mappedBy = "serviceOfferScheduleParent", cascade = CascadeType.PERSIST)
	private ServiceOfferSchedule serviceOfferSchedule;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferOriginParent", cascade = CascadeType.PERSIST)
	private Set<ServiceOfferOrigin> serviceOfferOrigins;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferDestinationParent", cascade = CascadeType.PERSIST)
	private Set<ServiceOfferDestination> serviceOfferDestinations;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferTxParent", cascade = CascadeType.PERSIST)
	private Set<ServiceOfferTx> serviceOfferTxs;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferActivityParent", cascade = CascadeType.PERSIST)
	private Set<ServiceOfferActivity> serviceOfferActivities;

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

	public ServiceOfferSchedule getServiceOfferSchedule() {
		return serviceOfferSchedule;
	}

	public void setServiceOfferSchedule(ServiceOfferSchedule serviceOfferSchedule) {
		this.serviceOfferSchedule = serviceOfferSchedule;
	}

	public Set<ServiceOfferOrigin> getServiceOfferOrigins() {
		return serviceOfferOrigins;
	}

	public void setServiceOfferOrigins(Set<ServiceOfferOrigin> serviceOfferOrigins) {
		this.serviceOfferOrigins = serviceOfferOrigins;
	}

	public Set<ServiceOfferDestination> getServiceOfferDestinations() {
		return serviceOfferDestinations;
	}

	public void setServiceOfferDestinations(Set<ServiceOfferDestination> serviceOfferDestinations) {
		this.serviceOfferDestinations = serviceOfferDestinations;
	}

	public Set<ServiceOfferTx> getServiceOfferTxs() {
		return serviceOfferTxs;
	}

	public void setServiceOfferTxs(Set<ServiceOfferTx> serviceOfferTxs) {
		this.serviceOfferTxs = serviceOfferTxs;
	}

	public Set<ServiceOfferActivity> getServiceOfferActivities() {
		return serviceOfferActivities;
	}

	public void setServiceOfferActivities(Set<ServiceOfferActivity> serviceOfferActivities) {
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
