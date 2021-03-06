package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service_subcategory")
public class ServiceSubcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceSubcategoryParent;
	
	private String title;
	
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferSubcategory", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ServiceOffer> serviceSubcategoryOffers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestSubcategory", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ServiceRequest> serviceSubcategoryRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceCategory getServiceSubcategoryParent() {
		return serviceSubcategoryParent;
	}

	public void setServiceSubcategoryParent(ServiceCategory serviceSubcategoryParent) {
		this.serviceSubcategoryParent = serviceSubcategoryParent;
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

	public List<ServiceOffer> getServiceSubcategoryOffers() {
		return serviceSubcategoryOffers;
	}

	public void setServiceSubcategoryOffers(List<ServiceOffer> serviceSubcategoryOffers) {
		this.serviceSubcategoryOffers = serviceSubcategoryOffers;
	}

	public List<ServiceRequest> getServiceSubcategoryRequests() {
		return serviceSubcategoryRequests;
	}

	public void setServiceSubcategoryRequests(List<ServiceRequest> serviceSubcategoryRequests) {
		this.serviceSubcategoryRequests = serviceSubcategoryRequests;
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
		ServiceSubcategory other = (ServiceSubcategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceSubcategory [id=").append(id).append(", serviceSubcategoryParent=")
				.append(serviceSubcategoryParent).append(", title=").append(title).append("]");
		return builder.toString();
	}
	
}
