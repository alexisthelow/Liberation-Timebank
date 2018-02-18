package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "timebank")
public class Timebank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;

	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "userTimebanks", cascade = CascadeType.PERSIST)
	private Set<User> timebankUsers;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "userModeratorTimebanks", cascade = CascadeType.PERSIST)
	private Set<User> timebankModeratorUsers;
	
	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "owner_id")
	private User timebankOwner;
	
	//service offers
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceOfferTimebank", cascade = CascadeType.PERSIST)
	private Set<ServiceOffer> timebankServiceOffers;
	
	//service requests
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "serviceRequestTimebank", cascade = CascadeType.PERSIST)
	private Set<ServiceRequest> timebankServiceRequest;
	
	//item loan offers
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanOfferTimebank", cascade = CascadeType.PERSIST)
	private Set<ItemLoanOffer> timebankItemLoanOffers;
	
	//item loan request
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanRequestTimebank", cascade = CascadeType.PERSIST)
	private Set<ItemLoanRequest> timebankItemLoanRequests;
	
	//item transfer offers
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemTransferOfferTimebank", cascade = CascadeType.PERSIST)
	private Set<ItemTransferOffer> timebankItemOffers;

	//item transfer requests
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemTransferRequestTimebank", cascade = CascadeType.PERSIST)
	private Set<ItemTransferRequest> timebankItemRequests;

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

	public Set<User> getTimebankUsers() {
		return timebankUsers;
	}

	public void setTimebankUsers(Set<User> timebankUsers) {
		this.timebankUsers = timebankUsers;
	}

	public Set<User> getTimebankModeratorUsers() {
		return timebankModeratorUsers;
	}

	public void setTimebankModeratorUsers(Set<User> timebankModeratorUsers) {
		this.timebankModeratorUsers = timebankModeratorUsers;
	}

	public User getTimebankOwner() {
		return timebankOwner;
	}

	public void setTimebankOwner(User timebankOwner) {
		this.timebankOwner = timebankOwner;
	}

	public Set<ServiceOffer> getTimebankServiceOffers() {
		return timebankServiceOffers;
	}

	public void setTimebankServiceOffers(Set<ServiceOffer> timebankServiceOffers) {
		this.timebankServiceOffers = timebankServiceOffers;
	}

	public Set<ServiceRequest> getTimebankServiceRequest() {
		return timebankServiceRequest;
	}

	public void setTimebankServiceRequest(Set<ServiceRequest> timebankServiceRequest) {
		this.timebankServiceRequest = timebankServiceRequest;
	}

	public Set<ItemLoanOffer> getTimebankItemLoanOffers() {
		return timebankItemLoanOffers;
	}

	public void setTimebankItemLoanOffers(Set<ItemLoanOffer> timebankItemLoanOffers) {
		this.timebankItemLoanOffers = timebankItemLoanOffers;
	}

	public Set<ItemLoanRequest> getTimebankItemLoanRequests() {
		return timebankItemLoanRequests;
	}

	public void setTimebankItemLoanRequests(Set<ItemLoanRequest> timebankItemLoanRequests) {
		this.timebankItemLoanRequests = timebankItemLoanRequests;
	}

	public Set<ItemTransferOffer> getTimebankItemOffers() {
		return timebankItemOffers;
	}

	public void setTimebankItemOffers(Set<ItemTransferOffer> timebankItemOffers) {
		this.timebankItemOffers = timebankItemOffers;
	}

	public Set<ItemTransferRequest> getTimebankItemRequests() {
		return timebankItemRequests;
	}

	public void setTimebankItemRequests(Set<ItemTransferRequest> timebankItemRequests) {
		this.timebankItemRequests = timebankItemRequests;
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
		Timebank other = (Timebank) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Timebank [id=").append(id).append(", title=").append(title).append("]");
		return builder.toString();
	}

}
