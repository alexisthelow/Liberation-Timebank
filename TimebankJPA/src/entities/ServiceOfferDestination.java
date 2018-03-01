package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import interfaces.Location;

@Entity
@Table(name = "service_offer_destination")
public class ServiceOfferDestination implements Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "service_offer_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ServiceOffer serviceOfferDestinationParent;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "location_category_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private LocationCategory serviceOfferDestinationLocationCategory;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "address_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
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

	public LocationCategory getServiceOfferDestinationLocationCategory() {
		return serviceOfferDestinationLocationCategory;
	}

	public void setServiceOfferDestinationLocationCategory(LocationCategory serviceOfferDestinationLocationCategory) {
		this.serviceOfferDestinationLocationCategory = serviceOfferDestinationLocationCategory;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public Object getParent() {
		return this.serviceOfferDestinationParent;
	}

	@Override
	public LocationCategory getLocationCategory() {
		return this.serviceOfferDestinationLocationCategory;
	}
	
	@Override
	public void setParent(Object parent) {
		this.serviceOfferDestinationParent = (ServiceOffer) parent;
	}

	@Override
	public void setLocationCategory(LocationCategory category) {
		this.serviceOfferDestinationLocationCategory = category;
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
		builder.append("ServiceOfferDestination [id=").append(id).append("]");
		return builder.toString();
	}

}
