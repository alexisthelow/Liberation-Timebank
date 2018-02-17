package entities;

import java.util.List;

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

@Entity
@Table(name = "item_subcategory")
public class ItemSubcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	private ItemCategory itemSubcategoryParent;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemTransferOfferSubcategory", cascade = CascadeType.PERSIST)
	private List<ItemTransferOffer> itemSubcategoryTransferOffers;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemTransferRequestSubcategory", cascade = CascadeType.PERSIST)
	private List<ItemTransferRequest> itemSubcategoryTransferRequests;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanOfferSubcategory", cascade = CascadeType.PERSIST)
	private List<ItemLoanOffer> itemSubcategoryLoanOffers;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanRequestSubcategory", cascade = CascadeType.PERSIST)
	private List<ItemLoanRequest> itemSubcategoryLoanRequests;

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

	public ItemCategory getItemSubcategoryParent() {
		return itemSubcategoryParent;
	}

	public void setItemSubcategoryParent(ItemCategory itemSubcategoryParent) {
		this.itemSubcategoryParent = itemSubcategoryParent;
	}

	public List<ItemTransferOffer> getItemSubcategoryTransferOffers() {
		return itemSubcategoryTransferOffers;
	}

	public void setItemSubcategoryTransferOffers(List<ItemTransferOffer> itemSubcategoryTransferOffers) {
		this.itemSubcategoryTransferOffers = itemSubcategoryTransferOffers;
	}

	public List<ItemTransferRequest> getItemSubcategoryTransferRequests() {
		return itemSubcategoryTransferRequests;
	}

	public void setItemSubcategoryTransferRequests(List<ItemTransferRequest> itemSubcategoryTransferRequests) {
		this.itemSubcategoryTransferRequests = itemSubcategoryTransferRequests;
	}

	public List<ItemLoanOffer> getItemSubcategoryLoanOffers() {
		return itemSubcategoryLoanOffers;
	}

	public void setItemSubcategoryLoanOffers(List<ItemLoanOffer> itemSubcategoryLoanOffers) {
		this.itemSubcategoryLoanOffers = itemSubcategoryLoanOffers;
	}

	public List<ItemLoanRequest> getItemSubcategoryLoanRequests() {
		return itemSubcategoryLoanRequests;
	}

	public void setItemSubcategoryLoanRequests(List<ItemLoanRequest> itemSubcategoryLoanRequests) {
		this.itemSubcategoryLoanRequests = itemSubcategoryLoanRequests;
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
		ItemSubcategory other = (ItemSubcategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemSubcategory [id=").append(id).append(", title=").append(title)
				.append(", itemSubcategoryParent=").append(itemSubcategoryParent).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}
	
}