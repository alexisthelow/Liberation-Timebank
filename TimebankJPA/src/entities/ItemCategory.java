package entities;

import java.util.Set;

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
@Table(name = "item_category")
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemSubcategoryParent", cascade = CascadeType.PERSIST)
	private Set<ItemSubcategory> itemCategorySubcategories;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemTransferOfferCategory", cascade = CascadeType.PERSIST)
	private Set<ItemTransferOffer> itemCategoryTransferOffers;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemTransferRequestCategory", cascade = CascadeType.PERSIST)
	private Set<ItemTransferRequest> itemCategoryTransferRequests;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanOfferCategory", cascade = CascadeType.PERSIST)
	private Set<ItemLoanOffer> itemCategoryLoanOffers;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "itemLoanRequestCategory", cascade = CascadeType.PERSIST)
	private Set<ItemLoanRequest> itemCategoryLoanRequests;

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

	public Set<ItemSubcategory> getItemCategorySubcategories() {
		return itemCategorySubcategories;
	}

	public void setItemCategorySubcategories(Set<ItemSubcategory> itemCategorySubcategories) {
		this.itemCategorySubcategories = itemCategorySubcategories;
	}

	public Set<ItemTransferOffer> getItemCategoryTransferOffers() {
		return itemCategoryTransferOffers;
	}

	public void setItemCategoryTransferOffers(Set<ItemTransferOffer> itemCategoryTransferOffers) {
		this.itemCategoryTransferOffers = itemCategoryTransferOffers;
	}

	public Set<ItemTransferRequest> getItemCategoryTransferRequests() {
		return itemCategoryTransferRequests;
	}

	public void setItemCategoryTransferRequests(Set<ItemTransferRequest> itemCategoryTransferRequests) {
		this.itemCategoryTransferRequests = itemCategoryTransferRequests;
	}

	public Set<ItemLoanOffer> getItemCategoryLoanOffers() {
		return itemCategoryLoanOffers;
	}

	public void setItemCategoryLoanOffers(Set<ItemLoanOffer> itemCategoryLoanOffers) {
		this.itemCategoryLoanOffers = itemCategoryLoanOffers;
	}

	public Set<ItemLoanRequest> getItemCategoryLoanRequests() {
		return itemCategoryLoanRequests;
	}

	public void setItemCategoryLoanRequests(Set<ItemLoanRequest> itemCategoryLoanRequests) {
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
