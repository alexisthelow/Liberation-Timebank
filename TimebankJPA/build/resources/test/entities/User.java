package entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_account")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@JsonIgnore
	@JoinColumn(name = "address_id")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Address userAddress;
	
	private String email;
	
	@Column(name = "password")
	private String hashedPassword;
	
	@Column(name = "password_salt")
	private String passwordSalt;
	
	@Column(name = "password_hash")
	private String passwordHash;
	
	private Timestamp created;
	
	private Boolean active;
	
	@Column(name = "last_login")
	private Timestamp lastLogin;
	
	@Column(name = "moderator_ban")
	private Boolean moderatorBan;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "banning_moderator_id")
	private User banningModerator;
	
	@Column(name = "last_update")
	private Timestamp lastUpdate;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_update_user_id")
	private User lastUpdateUser;
	
	//service offers
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ServiceOffer> userServiceOffers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferRecipient", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOfferTx> userServiceOfferTxs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceOfferActivityUser", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ServiceOfferActivity> userServiceOfferActivities;
	
	//service requests
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ServiceRequest> userServiceRequests;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestProvider", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ServiceRequestTx> userServiceRequestTxProvides;
	
	@JsonIgnore
	@OneToMany(mappedBy = "serviceRequestActivityUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ServiceRequestActivity> userServiceRequestActivities;
	
	//item transfer offers
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferOfferUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTransferOffer> userItemTransferOffers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferOfferTxRecipient", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTransferOfferTx> userItemTransferOfferTxReceives;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferOfferActivityUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTransferOfferActivity> userItemTransferOfferActivities;
	
	//item transfer requests
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTransferRequest> userItemTransferRequests;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestTxProvider", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTransferRequestTx> userItemTransferRequestTxProvides;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestActivityUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemTransferRequestActivity> userItemTransferRequestActivities;
	
	//item loan requests
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanRequestUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemLoanRequest> userItemLoanRequests;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanRequestActivityUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemLoanRequestActivity> userItemLoanRequestActivities;

	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanRequestTxLender", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemLoanRequestTx> userItemLoanRequestTxLends;

	// item loan offers
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemLoanOffer> userItemLoanOffers;

	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferActivityUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemLoanOfferActivity> userItemLoanOfferActivities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferTxBorrower", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ItemLoanOfferTx> userItemLoanOfferTxBorrows;
	
	//timebank
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "timebank_user", joinColumns=@JoinColumn(name = "user_id"), inverseJoinColumns=@JoinColumn(name = "timebank_id"))
	private List<Timebank> userTimebanks;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "timebank_moderator", joinColumns=@JoinColumn(name = "moderator_id"), inverseJoinColumns=@JoinColumn(name = "timebank_id"))
	private List<Timebank> userModeratorTimebanks;
	
	//intra user messaging
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<MessageThread> userMessageThreads;
	
	@JsonIgnore
	@OneToMany(mappedBy = "participantUser", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Reply> userMessageThreadReplies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean getModeratorBan() {
		return moderatorBan;
	}

	public void setModeratorBan(Boolean moderatorBan) {
		this.moderatorBan = moderatorBan;
	}

	public User getBanningModerator() {
		return banningModerator;
	}

	public void setBanningModerator(User banningModerator) {
		this.banningModerator = banningModerator;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public User getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public List<ServiceOffer> getUserServiceOffers() {
		return userServiceOffers;
	}

	public void setUserServiceOffers(List<ServiceOffer> userServiceOffers) {
		this.userServiceOffers = userServiceOffers;
	}

	public List<ServiceOfferTx> getUserServiceOfferTxs() {
		return userServiceOfferTxs;
	}

	public void setUserServiceOfferTxs(List<ServiceOfferTx> userServiceOfferTxs) {
		this.userServiceOfferTxs = userServiceOfferTxs;
	}

	public List<ServiceOfferActivity> getUserServiceOfferActivities() {
		return userServiceOfferActivities;
	}

	public void setUserServiceOfferActivities(List<ServiceOfferActivity> userServiceOfferActivities) {
		this.userServiceOfferActivities = userServiceOfferActivities;
	}

	public List<ServiceRequest> getUserServiceRequests() {
		return userServiceRequests;
	}

	public void setUserServiceRequests(List<ServiceRequest> userServiceRequests) {
		this.userServiceRequests = userServiceRequests;
	}

	public List<ServiceRequestTx> getUserServiceRequestTxProvides() {
		return userServiceRequestTxProvides;
	}

	public void setUserServiceRequestTxProvides(List<ServiceRequestTx> userServiceRequestTxProvides) {
		this.userServiceRequestTxProvides = userServiceRequestTxProvides;
	}

	public List<ServiceRequestActivity> getUserServiceRequestActivities() {
		return userServiceRequestActivities;
	}

	public void setUserServiceRequestActivities(List<ServiceRequestActivity> userServiceRequestActivities) {
		this.userServiceRequestActivities = userServiceRequestActivities;
	}

	public List<ItemTransferOffer> getUserItemTransferOffers() {
		return userItemTransferOffers;
	}

	public void setUserItemTransferOffers(List<ItemTransferOffer> userItemTransferOffers) {
		this.userItemTransferOffers = userItemTransferOffers;
	}

	public List<ItemTransferOfferTx> getUserItemTransferOfferTxReceives() {
		return userItemTransferOfferTxReceives;
	}

	public void setUserItemTransferOfferTxReceives(List<ItemTransferOfferTx> userItemTransferOfferTxReceives) {
		this.userItemTransferOfferTxReceives = userItemTransferOfferTxReceives;
	}

	public List<ItemTransferOfferActivity> getUserItemTransferOfferActivities() {
		return userItemTransferOfferActivities;
	}

	public void setUserItemTransferOfferActivities(List<ItemTransferOfferActivity> userItemTransferOfferActivities) {
		this.userItemTransferOfferActivities = userItemTransferOfferActivities;
	}

	public List<ItemTransferRequest> getUserItemTransferRequests() {
		return userItemTransferRequests;
	}

	public void setUserItemTransferRequests(List<ItemTransferRequest> userItemTransferRequests) {
		this.userItemTransferRequests = userItemTransferRequests;
	}

	public List<ItemTransferRequestTx> getUserItemTransferRequestTxProvides() {
		return userItemTransferRequestTxProvides;
	}

	public void setUserItemTransferRequestTxProvides(List<ItemTransferRequestTx> userItemTransferRequestTxProvides) {
		this.userItemTransferRequestTxProvides = userItemTransferRequestTxProvides;
	}

	public List<ItemTransferRequestActivity> getUserItemTransferRequestActivities() {
		return userItemTransferRequestActivities;
	}

	public void setUserItemTransferRequestActivities(List<ItemTransferRequestActivity> userItemTransferRequestActivities) {
		this.userItemTransferRequestActivities = userItemTransferRequestActivities;
	}

	public List<ItemLoanRequest> getUserItemLoanRequests() {
		return userItemLoanRequests;
	}

	public void setUserItemLoanRequests(List<ItemLoanRequest> userItemLoanRequests) {
		this.userItemLoanRequests = userItemLoanRequests;
	}

	public List<ItemLoanRequestActivity> getUserItemLoanRequestActivities() {
		return userItemLoanRequestActivities;
	}

	public void setUserItemLoanRequestActivities(List<ItemLoanRequestActivity> userItemLoanRequestActivities) {
		this.userItemLoanRequestActivities = userItemLoanRequestActivities;
	}

	public List<ItemLoanRequestTx> getUserItemLoanRequestTxLends() {
		return userItemLoanRequestTxLends;
	}

	public void setUserItemLoanRequestTxLends(List<ItemLoanRequestTx> userItemLoanRequestTxLends) {
		this.userItemLoanRequestTxLends = userItemLoanRequestTxLends;
	}

	public List<ItemLoanOffer> getUserItemLoanOffers() {
		return userItemLoanOffers;
	}

	public void setUserItemLoanOffers(List<ItemLoanOffer> userItemLoanOffers) {
		this.userItemLoanOffers = userItemLoanOffers;
	}

	public List<ItemLoanOfferActivity> getUserItemLoanOfferActivities() {
		return userItemLoanOfferActivities;
	}

	public void setUserItemLoanOfferActivities(List<ItemLoanOfferActivity> userItemLoanOfferActivities) {
		this.userItemLoanOfferActivities = userItemLoanOfferActivities;
	}

	public List<ItemLoanOfferTx> getUserItemLoanOfferTxBorrows() {
		return userItemLoanOfferTxBorrows;
	}

	public void setUserItemLoanOfferTxBorrows(List<ItemLoanOfferTx> userItemLoanOfferTxBorrows) {
		this.userItemLoanOfferTxBorrows = userItemLoanOfferTxBorrows;
	}

	public List<Timebank> getUserTimebanks() {
		return userTimebanks;
	}

	public void setUserTimebanks(List<Timebank> userTimebanks) {
		this.userTimebanks = userTimebanks;
	}

	public List<Timebank> getUserModeratorTimebanks() {
		return userModeratorTimebanks;
	}

	public void setUserModeratorTimebanks(List<Timebank> userModeratorTimebanks) {
		this.userModeratorTimebanks = userModeratorTimebanks;
	}

	public List<MessageThread> getUserMessageThreads() {
		return userMessageThreads;
	}

	public void setUserMessageThreads(List<MessageThread> userMessageThreads) {
		this.userMessageThreads = userMessageThreads;
	}

	public List<Reply> getUserMessageThreadReplies() {
		return userMessageThreadReplies;
	}

	public void setUserMessageThreadReplies(List<Reply> userMessageThreadReplies) {
		this.userMessageThreadReplies = userMessageThreadReplies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", created=").append(created).append(", active=").append(active)
				.append(", moderatorBan=").append(moderatorBan).append("]");
		return builder.toString();
	}
	
}
