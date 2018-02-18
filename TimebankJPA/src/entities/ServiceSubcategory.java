package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service_subcategory")
public class ServiceSubcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceSubcategoryParent;
	
	private String title;
	
	private String description;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferSubcategory", cascade = CascadeType.PERSIST)
	private Set<ServiceOffer> serviceSubcategoryOffers;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestSubcategory", cascade = CascadeType.PERSIST)
	private Set<ServiceRequest> serviceSubcategoryRequests;

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

	public Set<ServiceOffer> getServiceSubcategoryOffers() {
		return serviceSubcategoryOffers;
	}

	public void setServiceSubcategoryOffers(Set<ServiceOffer> serviceSubcategoryOffers) {
		this.serviceSubcategoryOffers = serviceSubcategoryOffers;
	}

	public Set<ServiceRequest> getServiceSubcategoryRequests() {
		return serviceSubcategoryRequests;
	}

	public void setServiceSubcategoryRequests(Set<ServiceRequest> serviceSubcategoryRequests) {
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
