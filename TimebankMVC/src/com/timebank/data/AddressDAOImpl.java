package com.timebank.data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Address;
import entities.User;

@Transactional
@Repository
public class AddressDAOImpl implements AddressDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Address createAddress(String addressJson) {
		ObjectMapper mapper = new ObjectMapper();
		Address newAddress = null;
		
		try {
			newAddress = mapper.readValue(addressJson, Address.class);
			em.persist(newAddress);
			em.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
 		return newAddress;
	}

	@Override
	public Address showAddressById(int addressId) {
		return em.find(Address.class, addressId);
	}

	@Override
	public List<Address> indexAddressesByZip(int zip) {
		String query = "SELECT a FROM Address a WHERE zip = :zip";
		return em.createQuery(query, Address.class).setParameter("zip", zip).getResultList();
	}

	@Override
	public List<Address> indexAddressesByState(String state) {
		String query = "SELECT a FROM Address a WHERE state = :state";
		return em.createQuery(query, Address.class).setParameter("state", state).getResultList();
	}

	@Override
	public List<Address> indexAddressesByCountry(String country) {
		String query = "SELECT a FROM Address a WHERE country = :country";
		return em.createQuery(query, Address.class).setParameter("country", country).getResultList();
	}

	@Override
	public Address updateAddress(User actingUser, int addressId, String addressJson) {
		ObjectMapper mapper = new ObjectMapper();
		Address managedAddress = em.find(Address.class, addressId);
		Address newAddress = null;
		
		try {
			newAddress = mapper.readValue(addressJson, Address.class);
			managedAddress.setTitle(newAddress.getTitle());
			managedAddress.setDescription(newAddress.getDescription());
			managedAddress.setPublicVisibility(newAddress.getPublicVisibility());
			managedAddress.setStreet(newAddress.getStreet());
			managedAddress.setStreet2(newAddress.getStreet2());
			managedAddress.setCity(newAddress.getCity());
			managedAddress.setState(newAddress.getState());
			managedAddress.setZip(newAddress.getZip());
			managedAddress.setCountry(newAddress.getCountry());
			managedAddress.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			managedAddress.setLastUpdateUser(actingUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return managedAddress;
	}

	@Override
	public Boolean destroyAddress(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
