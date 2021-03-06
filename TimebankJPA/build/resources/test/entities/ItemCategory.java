package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_category")
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy = "itemSubcategoryParent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemSubcategory> itemCategorySubcategories;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferOfferCategory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemTransferOffer> itemCategoryTransferOffers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemTransferRequestCategory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemTransferRequest> itemCategoryTransferRequests;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanOfferCategory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemLoanOffer> itemCategoryLoanOffers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "itemLoanRequestCategory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<ItemLoanRequest> itemCategoryLoanRequests;

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

	public List<ItemSubcategory> getItemCategorySubcategories() {
		return itemCategorySubcategories;
	}

	public void setItemCategorySubcategories(List<ItemSubcategory> itemCategorySubcategories) {
		this.itemCategorySubcategories = itemCategorySubcategories;
	}

	public List<ItemTransferOffer> getItemCategoryTransferOffers() {
		return itemCategoryTransferOffers;
	}

	public void setItemCategoryTransferOffers(List<ItemTransferOffer> itemCategoryTransferOffers) {
		this.itemCategoryTransferOffers = itemCategoryTransferOffers;
	}

	public List<ItemTransferRequest> getItemCategoryTransferRequests() {
		return itemCategoryTransferRequests;
	}

	public void setItemCategoryTransferRequests(List<ItemTransferRequest> itemCategoryTransferRequests) {
		this.itemCategoryTransferRequests = itemCategoryTransferRequests;
	}

	public List<ItemLoanOffer> getItemCategoryLoanOffers() {
		return itemCategoryLoanOffers;
	}

	public void setItemCategoryLoanOffers(List<ItemLoanOffer> itemCategoryLoanOffers) {
		this.itemCategoryLoanOffers = itemCategoryLoanOffers;
	}

	public List<ItemLoanRequest> getItemCategoryLoanRequests() {
		return itemCategoryLoanRequests;
	}

	public void setItemCategoryLoanRequests(List<ItemLoanRequest> itemCategoryLoanRequests) {
		this.itemCategoryLoanRequests = itemCategoryLoanRequests;
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
		ItemCategory other = (ItemCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemCategory [id=").append(id).append(", title=").append(title).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}
	
}
