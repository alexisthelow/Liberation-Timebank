package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "location_category")
public class LocationCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestOriginLocationCategory", cascade = CascadeType.PERSIST)
	private Set<ServiceRequestOrigin> serviceRequestOrigins;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestDestinationLocationCategory", cascade = CascadeType.PERSIST)
	private Set<ServiceRequestDestination> serviceRequestDestinations;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferOriginLocationCategory", cascade = CascadeType.PERSIST)
	private Set<ServiceOfferOrigin> serviceOfferOrigins;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferDestinationLocationCategory", cascade = CascadeType.PERSIST)
	private Set<ServiceOfferDestination> serviceOfferDestinations;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<ServiceRequestOrigin> getServiceRequestOrigins() {
		return serviceRequestOrigins;
	}

	public void setServiceRequestOrigins(Set<ServiceRequestOrigin> serviceRequestOrigins) {
		this.serviceRequestOrigins = serviceRequestOrigins;
	}

	public Set<ServiceRequestDestination> getServiceRequestDestinations() {
		return serviceRequestDestinations;
	}

	public void setServiceRequestDestinations(Set<ServiceRequestDestination> serviceRequestDestinations) {
		this.serviceRequestDestinations = serviceRequestDestinations;
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
		LocationCategory other = (LocationCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocationCategory [id=").append(id).append(", title=").append(title).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}
	
}
