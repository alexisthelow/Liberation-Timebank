package interfaces;

import java.sql.Timestamp;
import java.util.Set;

import entities.ServiceCategory;
import entities.ServiceSubcategory;
import entities.User;

public interface Service {
	
	public int getId();
	public void setId(int id);
	public ServiceCategory getCategory();
	public void setCategory(ServiceCategory category);
	public ServiceSubcategory getSubcategory();
	public void setSubcategory(ServiceSubcategory subcategory);
	public Boolean getRequiresSupplies();
	public void setRequiresSupplies(Boolean requiresSupplies);
	public Integer getSupplyCostEstimate();
	public void setSupplyCostEstimate(Integer estimate);
	public Timestamp getCreated();
	public void setCreated(Timestamp created);
	public Timestamp getLastUpdate();
	public void setLastUpdate(Timestamp lastUpdate);
	public User getLastUpdateUser();
	public void setLastUpdateUser(User user);
	public Boolean getActive();
	public void setActive(Boolean active);
	public Set<Location> getOrigins();
	public void setOrigins(Set<Location> origins);
	public Set<Location> getDestinations();
	public void setDestinations(Set<Location> destinations);

}
