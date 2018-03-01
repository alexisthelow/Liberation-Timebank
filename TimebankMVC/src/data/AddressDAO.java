package data;

import java.util.Set;

import entities.Address;

public interface AddressDAO {
	
	//create
	
	public Address createAddress(String addressJson);
	
	//read
	
	public Address showAddressById(int addressId);
	public Set<Address> indexAddressesByZip(int zip);
	public Set<Address> indexAddressesByState(String state);
	public Set<Address> indexAddressesByCountry(String country);
	
	//update
	
	public Address updateAddress(int actingUserId, int userId, int addressId, String addressJson);
	
	//destroy
	
	public Boolean destroyAddress(int addressId);
	
}