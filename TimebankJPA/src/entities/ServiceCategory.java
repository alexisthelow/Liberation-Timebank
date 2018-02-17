package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service_category")
public class ServiceCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceSubcategoryParent", cascade = CascadeType.PERSIST)
	private List<ServiceSubcategory> serviceSubcategories;

	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferCategory", cascade = CascadeType.PERSIST)
	private List<ServiceOffer> serviceCategoryOffers;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestCategory", cascade = CascadeType.PERSIST)
	private List<ServiceRequest> serviceCategoryRequests;

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

	public List<ServiceSubcategory> getServiceSubcategories() {
		return serviceSubcategories;
	}

	public void setServiceSubcategories(List<ServiceSubcategory> serviceSubcategories) {
		this.serviceSubcategories = serviceSubcategories;
	}

	public List<ServiceOffer> getServiceCategoryOffers() {
		return serviceCategoryOffers;
	}

	public void setServiceCategoryOffers(List<ServiceOffer> serviceCategoryOffers) {
		this.serviceCategoryOffers = serviceCategoryOffers;
	}

	public List<ServiceRequest> getServiceCategoryRequests() {
		return serviceCategoryRequests;
	}

	public void setServiceCategoryRequests(List<ServiceRequest> serviceCategoryRequests) {
		this.serviceCategoryRequests = serviceCategoryRequests;
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
		ServiceCategory other = (ServiceCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceCategory [id=").append(id).append(", title=").append(title).append("]");
		return builder.toString();
	}

}
