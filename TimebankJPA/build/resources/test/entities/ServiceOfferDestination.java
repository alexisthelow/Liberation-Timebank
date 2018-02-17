package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_offer_destination")
public class ServiceOfferDestination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "service_offer_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private ServiceOffer serviceOfferDestinationParent;
	
	@JoinColumn(name = "location_category_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private LocationCategory locationCategory;
	
	@JoinColumn(name = "address_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceOffer getServiceOfferDestinationParent() {
		return serviceOfferDestinationParent;
	}

	public void setServiceOfferDestinationParent(ServiceOffer serviceOfferDestinationParent) {
		this.serviceOfferDestinationParent = serviceOfferDestinationParent;
	}

	public LocationCategory getLocationCategory() {
		return locationCategory;
	}

	public void setLocationCategory(LocationCategory locationCategory) {
		this.locationCategory = locationCategory;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		ServiceOfferDestination other = (ServiceOfferDestination) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceOfferDestination [id=").append(id).append(", locationCategory=").append(locationCategory)
				.append(", getAddress().getTitle()=").append(getAddress().getTitle()).append("]");
		return builder.toString();
	}
	
}
