package interfaces;

import java.sql.Timestamp;
import java.util.List;

import entities.ItemCategory;
import entities.ItemSubcategory;
import entities.Timebank;
import entities.User;

public interface Item {
	
	public int getId();
	public void setId(int id);
	public Timebank getTimebank();
	public void setTimebank(Timebank timebank);
	public User getOwner();
	public void setOwner(User owner);
	public ItemCategory getCategory();
	public void setItemCategory(ItemCategory category);
	public ItemSubcategory getSubcategory();
	public void setItemSubcategory(ItemSubcategory subcategory);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public Timestamp getCreated();
	public void setCreated(Timestamp created);
	public Boolean getGlobalVisibility();
	public void setGlobalVisibility(Boolean globalVisibility);
	public Boolean getActive();
	public void setActive(Boolean active);
	public Boolean getModeratorClosed();
	public void setModeratorClosed(Boolean closed);
	public User getClosingModerator();
	public void setClosingModerator(User closingModerator);
	public List<Activity> getActivity();
	public void setActivity(List<Activity> activity);
	public List<Transaction> getTransactions();
	public void setTransactions(List<Transaction> transactions);

}
