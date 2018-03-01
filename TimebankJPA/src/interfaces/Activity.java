package interfaces;

import java.sql.Timestamp;

import entities.User;

public interface Activity {
	
	public int getId();
	public void setId(int id);
	public Object getParent();
	public void setParent(Object parent);
	public User getUser();
	public void setUser(User user);
	public String getMessage();
	public void setMessage(String message);
	public Timestamp getPosted();
	public void setPosted(Timestamp posted);
	public Timestamp getLastUpdate();
	public void setLastUpdate(Timestamp lastUpdate);
	public User getLastUpdateUser();
	public void setLastUpdateUser(User lastUpdateUser);
	public Boolean getModeratorHide();
	public void setModeratorHide(Boolean moderatorHide);
	public User getHidingModerator();
	public void setHidingModerator(User hidingModerator);

}
