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

@Entity
@Table(name = "service_request_origin")
public class ServiceRequestOrigin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "service_request_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ServiceRequest serviceRequestOriginParent;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "location_category_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private LocationCategory serviceRequestOriginLocationCategory;
	
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

	public ServiceRequest getServiceRequestOriginParent() {
		return serviceRequestOriginParent;
	}

	public void setServiceRequestOriginParent(ServiceRequest serviceRequestOriginParent) {
		this.serviceRequestOriginParent = serviceRequestOriginParent;
	}

	public LocationCategory getServiceRequestOriginLocationCategory() {
		return serviceRequestOriginLocationCategory;
	}

	public void setServiceRequestOriginLocationCategory(LocationCategory serviceRequestOriginLocationCategory) {
		this.serviceRequestOriginLocationCategory = serviceRequestOriginLocationCategory;
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
		ServiceRequestOrigin other = (ServiceRequestOrigin) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRequestOrigin [id=").append(id).append("]");
		return builder.toString();
	}

}
