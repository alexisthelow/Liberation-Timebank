package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@ManyToMany(mappedBy = "userTimebanks", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<User> timebankUsers;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "userModeratorTimebanks", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<User> timebankModeratorUsers;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private User timebankOwner;
	
	//service offers
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferTimebank", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOffer> timebankServiceOffers;
	
	//service requests
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestTimebank", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceRequest> timebankServiceRequest;
	
	//item loan offers
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferTimebank", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemLoanOffer> timebankItemLoanOffers;
	
	//item loan request
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanRequestTimebank", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemLoanRequest> timebankItemLoanRequests;
	
	//item transfer offers
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferOfferTimebank", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemTransferOffer> timebankItemOffers;

	//item transfer requests
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestTimebank", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemTransferRequest> timebankItemRequests;

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

	public List<User> getTimebankUsers() {
		return timebankUsers;
	}

	public void setTimebankUsers(List<User> timebankUsers) {
		this.timebankUsers = timebankUsers;
	}

	public List<User> getTimebankModeratorUsers() {
		return timebankModeratorUsers;
	}

	public void setTimebankModeratorUsers(List<User> timebankModeratorUsers) {
		this.timebankModeratorUsers = timebankModeratorUsers;
	}

	public User getTimebankOwner() {
		return timebankOwner;
	}

	public void setTimebankOwner(User timebankOwner) {
		this.timebankOwner = timebankOwner;
	}

	public List<ServiceOffer> getTimebankServiceOffers() {
		return timebankServiceOffers;
	}

	public void setTimebankServiceOffers(List<ServiceOffer> timebankServiceOffers) {
		this.timebankServiceOffers = timebankServiceOffers;
	}

	public List<ServiceRequest> getTimebankServiceRequest() {
		return timebankServiceRequest;
	}

	public void setTimebankServiceRequest(List<ServiceRequest> timebankServiceRequest) {
		this.timebankServiceRequest = timebankServiceRequest;
	}

	public List<ItemLoanOffer> getTimebankItemLoanOffers() {
		return timebankItemLoanOffers;
	}

	public void setTimebankItemLoanOffers(List<ItemLoanOffer> timebankItemLoanOffers) {
		this.timebankItemLoanOffers = timebankItemLoanOffers;
	}

	public List<ItemLoanRequest> getTimebankItemLoanRequests() {
		return timebankItemLoanRequests;
	}

	public void setTimebankItemLoanRequests(List<ItemLoanRequest> timebankItemLoanRequests) {
		this.timebankItemLoanRequests = timebankItemLoanRequests;
	}

	public List<ItemTransferOffer> getTimebankItemOffers() {
		return timebankItemOffers;
	}

	public void setTimebankItemOffers(List<ItemTransferOffer> timebankItemOffers) {
		this.timebankItemOffers = timebankItemOffers;
	}

	public List<ItemTransferRequest> getTimebankItemRequests() {
		return timebankItemRequests;
	}

	public void setTimebankItemRequests(List<ItemTransferRequest> timebankItemRequests) {
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
