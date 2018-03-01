package interfaces;

import entities.Address;
import entities.LocationCategory;

public interface Location {
	
	public int getId();
	public void setId(int id);
	public Object getParent();
	public void setParent(Object parent);
	public LocationCategory getLocationCategory();
	public void setLocationCategory(LocationCategory category);
	public Address getAddress();
	public void setAddress(Address address);

}
