package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location_category")
public class LocationCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "service_request_origin", joinColumns = @JoinColumn(name = "location_category_id"), inverseJoinColumns = @JoinColumn(name = "service_request_id"))
	private List<ServiceRequest> originatingServiceRequests;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "service_request_destination", joinColumns = @JoinColumn(name = "location_category_id"), inverseJoinColumns = @JoinColumn(name = "service_request_id"))
	private List<ServiceRequest> terminatingServiceRequests;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "service_offer_origin", joinColumns = @JoinColumn(name = "location_category_id"), inverseJoinColumns = @JoinColumn(name = "service_offer_id"))
	private List<ServiceOffer> originatingServiceOffers;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "service_offer_destination", joinColumns = @JoinColumn(name = "location_category_id"), inverseJoinColumns = @JoinColumn(name = "service_offer_id"))
	private List<ServiceOffer> terminatingServiceOffers;
	
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

	public List<ServiceRequest> getOriginatingServiceRequests() {
		return originatingServiceRequests;
	}

	public void setOriginatingServiceRequests(List<ServiceRequest> originatingServiceRequests) {
		this.originatingServiceRequests = originatingServiceRequests;
	}

	public List<ServiceRequest> getTerminatingServiceRequests() {
		return terminatingServiceRequests;
	}

	public void setTerminatingServiceRequests(List<ServiceRequest> terminatingServiceRequests) {
		this.terminatingServiceRequests = terminatingServiceRequests;
	}

	public List<ServiceOffer> getOriginatingServiceOffers() {
		return originatingServiceOffers;
	}

	public void setOriginatingServiceOffers(List<ServiceOffer> originatingServiceOffers) {
		this.originatingServiceOffers = originatingServiceOffers;
	}

	public List<ServiceOffer> getTerminatingServiceOffers() {
		return terminatingServiceOffers;
	}

	public void setTerminatingServiceOffers(List<ServiceOffer> terminatingServiceOffers) {
		this.terminatingServiceOffers = terminatingServiceOffers;
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
