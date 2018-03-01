package interfaces;

import java.sql.Timestamp;

import entities.User;

public interface Transaction {
	
	public int getId();
	public void setId(int id);
	public Object getParent();
	public void setParent(Object parent);
	public User getOwner();
	public void setOwner(User owner);
	public Timestamp getCreated();
	public void setCreated(Timestamp created);
	public Timestamp getLastUpdate();
	public void setLastUpdate(Timestamp lastUpdate);
	public User getLastUpdateUser();
	public void setLastUpdateUser(User user);
	public Timestamp getParentUserAccept();
	public void setParentUserAccept(Timestamp accept);
	public Timestamp getParentUserReject();
	public void setParentUserReject(Timestamp reject);
	public Timestamp getOwnerComplete();
	public void setOwnerComplete(Timestamp complete);
	public Timestamp getParentUserComplete();
	public void setParentUserComplete(Timestamp complete);
	public Boolean getModeratorClosed();
	public void setModeratorClosed(Boolean closed);
	public User getClosingModerator();
	public void setClosingModerator(User moderator);
	

}
