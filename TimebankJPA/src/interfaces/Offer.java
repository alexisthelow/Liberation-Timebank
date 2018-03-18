package interfaces;

import java.sql.Timestamp;
import java.util.List;

import entities.Timebank;
import entities.User;

public interface Offer {
	
	public int getId();
	public void setId(int id);
	public Timebank getTimebank();
	public void setTimebank(Timebank timebank);
	public User getOwner();
	public void setOwner(User owner);
	public String getTitle();
	public void setTitle(String title);
	public String getDescription();
	public void setDescription(String description);
	public Boolean getGlobalVisibility();
	public void setGlobalVisibility(Boolean globalVisibility);
	public Timestamp getCreated();
	public void setCreated(Timestamp created);
	public Timestamp getLastUpdate();
	public void setLastUpdate(Timestamp lastUpdate);
	public User getLastUpdateUser();
	public void setLastUpdateUser(User user);
	public Boolean getModeratorClosed();
	public void setModeratorClosed(Boolean moderatorClosed);
	public List<Activity> getActivity();
	public void setActivity(List<Activity> activity);
	public List<Transaction> getTransactions();
	public void setTransactions(List<Transaction> transactions);
	

}
