package com.timebank.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.util.DuplicateElementException;

import entities.Address;
import entities.ItemLoanOffer;
import entities.ItemLoanOfferTx;
import entities.ItemLoanRequest;
import entities.ItemLoanRequestTx;
import entities.ItemTransferOffer;
import entities.ItemTransferOfferTx;
import entities.ItemTransferRequest;
import entities.ItemTransferRequestTx;
import entities.ServiceOffer;
import entities.ServiceOfferTx;
import entities.ServiceRequest;
import entities.ServiceRequestTx;
import entities.Timebank;
import entities.User;
import javassist.NotFoundException;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public User createUser(int timebankId, int addressId, String userJson) throws DuplicateElementException {
		ObjectMapper mapper = new ObjectMapper();
		String pwSalt = BCrypt.gensalt();
		Timestamp current = new Timestamp(System.currentTimeMillis());
		User newUser = null;
		
		try {
			newUser = mapper.readValue(userJson, User.class);
			
			//check for duplicates
			String query = "SELECT u FROM User u WHERE email = :email";
			List<User> duplicateCheck = em.createQuery(query, User.class).setParameter("email", newUser.getEmail()).getResultList();

			if (duplicateCheck.size() > 0) {
				throw new DuplicateElementException();
			}
			
			//no duplicates found
			newUser.setCreated(current);
			newUser.setLastLogin(current);
			String pwHash = BCrypt.hashpw(newUser.getPassword(), pwSalt);
			newUser.setPassword(pwHash);
			newUser.setPasswordSalt(pwSalt);
			newUser.setPasswordHashAlgorithm("blowfish");
			newUser.setActive(true);
			newUser.setUserAddress(em.find(Address.class, addressId));
			em.persist(newUser);
			em.flush();
			
			String update = "INSERT INTO timebank_user (user_id, timebank_id, hours) VALUES (:userId, :timebankId, :hours)";
			em.createNativeQuery(update).setParameter("userId", newUser.getId()).setParameter("timebankId", timebankId).setParameter("hours", 0.0).executeUpdate();
		}
		catch (DuplicateElementException e) {
			throw new DuplicateElementException("User already registered with email " + newUser.getEmail());
		}
		catch (Exception e) {
			System.err.println("Could not register user at UserDAOImpl.createUser()");
			System.err.println("User json: " + userJson);
			e.printStackTrace();
		}
		return em.find(User.class, newUser.getId());
	}

	@Override
	public User login(String userJson) throws NotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		User loginUser = null;
		String email = null;
		String password = null;
		
		try {
			loginUser = mapper.readValue(userJson, User.class);
			email = loginUser.getEmail();
			password = loginUser.getPassword();

			String query = "SELECT u FROM User u WHERE email = :email";
			User requestingUser = em.createQuery(query, User.class).setParameter("email", email).getResultList().get(0);
			
			if (requestingUser != null && BCrypt.checkpw(password + requestingUser.getPasswordSalt(), requestingUser.getPassword())) {
				return requestingUser;
			}
			else {
				throw new NotFoundException("User not found. Email: " + email);
			}
		}
		catch (NotFoundException nfe) {
			throw new NotFoundException("User not found. Email: " + email);
		}
		catch (Exception e) {
			System.err.println("Failed to login user at UserDAOImpl.login()");
			System.err.println("userJson: " + userJson);
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> getUsersByTimebank(int timebankId) {
		return new ArrayList<User>(em.find(Timebank.class, timebankId).getTimebankUsers());
	}

	@Override
	public List<User> getModeratorsByTimebank(int timebankId) {
		return new ArrayList<User>(em.find(Timebank.class, timebankId).getTimebankModeratorUsers());
	}

	@Override
	public User showUser(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public Double showUserHoursByUserId(int timebankId, int userId) {
		String query = "SELECT hours FROM timebank_user WHERE user_id = :userId AND timebank_id = :timebankId";
		return (Double) em.createNativeQuery(query).setParameter("userId", userId).setParameter("timebankId", timebankId).getResultList().get(0);
	}

	@Override
	public List<ServiceOffer> indexUserServiceOffers(int userId) {
		String query = "SELECT s FROM ServiceOffer s WHERE serviceOfferUser = :userId AND active = true";
		return em.createQuery(query, ServiceOffer.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ServiceRequest> indexUserServiceRequests(int userId) {
		String query = "SELECT s FROM ServiceRequest s WHERE serviceRequestUser = :userId AND active = true";
		return em.createQuery(query, ServiceRequest.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemTransferOffer> indexUserItemTransferOffers(int userId) {
		String query = "SELECT i FROM ItemTransferOffer i WHERE itemTransferOfferUser = :userId AND active = true";
		return em.createQuery(query, ItemTransferOffer.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemTransferRequest> indexUserItemTransferRequests(int userId) {
		String query = "SELECT i FROM ItemTransferRequest i WHERE itemTransferRequestUser = :userId AND active = true";
		return em.createQuery(query, ItemTransferRequest.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemLoanOffer> indexUserItemLoanOffers(int userId) {
		String query = "SELECT i FROM ItemLoanOffer i WHERE itemLoanOfferUser = :userId AND active = true";
		return em.createQuery(query, ItemLoanOffer.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemLoanRequest> indexUserItemLoanRequests(int userId) {
		String query = "SELECT i FROM ItemLoanRequest i WHERE itemLoanRequestUser = :userId AND active = true";
		return em.createQuery(query, ItemLoanRequest.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ServiceOfferTx> indexUserServiceOfferTxs(int userId) {
		String query = "SELECT s FROM ServiceOfferTx s WHERE serviceOfferRecipient = :userId AND moderatorClosed = false";
		return em.createQuery(query, ServiceOfferTx.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ServiceRequestTx> indexUserServiceRequestTxs(int userId) {
		String query = "SELECT s FROM ServiceRequestTx WHERE serviceRequestProvider = :userId AND moderatorClosed = false";
		return em.createQuery(query, ServiceRequestTx.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemTransferOfferTx> indexUserItemTransferOfferTxs(int userId) {
		String query = "SELECT i FROM ItemTransferOfferTx i WHERE itemTransferOfferTxRecipient = :userId AND moderatorClosed = false";
		return em.createQuery(query, ItemTransferOfferTx.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemTransferRequestTx> indexUserItemTransferRequestTxs(int userId) {
		String query = "SELECT i FROM ItemTransferRequestTx i WHERE itemTransferRequestTxProvider = :userId AND moderatorClosed = false";
		return em.createQuery(query, ItemTransferRequestTx.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemLoanOfferTx> indexUserItemLoanOfferTxs(int userId) {
		String query = "SELECT i FROM ItemLoanOfferTx i WHERE itemLoanOfferTxBorrower = :userId AND moderatorClosed = false";
		return em.createQuery(query, ItemLoanOfferTx.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public List<ItemLoanRequestTx> indexUserItemLoanRequestTxs(int userId) {
		String query = "SELECT i FROM ItemLoanRequestTx i WHERE itemLoanRequestTxProvider = :userId AND moderatorClosed = false";
		return em.createQuery(query, ItemLoanRequestTx.class).setParameter("userId", userId).getResultList();
	}

	@Override
	public Boolean updatePassword(User actingUser, User managedUser, String oldPassword, String newPassword) {
		String newSalt = BCrypt.gensalt();
		
		if (managedUser.getPassword() == BCrypt.hashpw(oldPassword, managedUser.getPasswordSalt())) {		//old passwords match
			managedUser.setPasswordSalt(newSalt);
			managedUser.setPassword(BCrypt.hashpw(newPassword, newSalt));
			return true;
		}
		else {		//old pwds don't match
			System.err.println("Failed at UserDAOImpl.updatePassword(): old password is different from record");
			return false;
		}
		
	}

//	@Override
//	public Boolean recoverPassword(String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public User updateUser(int actingUserId, int managedUserId, int updatedAddressId, String userJson) {
		ObjectMapper mapper = new ObjectMapper();
		User managedUser = em.find(User.class, managedUserId);
		User actingUser = em.find(User.class, actingUserId);
		Address updatedAddress = em.find(Address.class, updatedAddressId);
		User newUser = null;
		
		try {
			newUser = mapper.readValue(userJson, User.class);
			managedUser.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			managedUser.setLastUpdateUser(actingUser);
			managedUser.setFirstName(newUser.getFirstName());
			managedUser.setLastName(newUser.getLastName());
			managedUser.setUserAddress(updatedAddress);
			managedUser.setEmail(newUser.getEmail());
		}
		catch (Exception e) {
			System.err.println("Failed at UserDAOImpl.updateUser()");
			System.err.println("userJson: " + userJson);
			e.printStackTrace();
		}
		return em.find(User.class, managedUser.getId());
	}	

	@Override
	public Double updateUserHours(int timebankId, int updateUserId, Double hourDifference) {
		String query = "SELECT hours FROM timebank_user WHERE timebank_id = :timebankId "
				+ "AND user_id = :userId";
		Double userHours = (Double) em.createNativeQuery(query).setParameter("timebankId", timebankId).setParameter("userId", updateUserId).getResultList().get(0);
		userHours += hourDifference;
		String update = "INSERT INTO timebank_user (hours) VALUES (:userHours) WHERE timebank_id = :timebankId "
				+ "AND user_id = :userId";
		em.createNativeQuery(update).setParameter("userHours", userHours).setParameter("timebankId", timebankId).setParameter("userId", updateUserId).executeUpdate();
		return (Double) em.createNativeQuery(query).setParameter("timebankId", timebankId).setParameter("userId", updateUserId).getResultList().get(0);
	}

	@Override
	public Boolean deactivateUser(User actingUser, User managedUser) {
		managedUser.setActive(false);
		return !em.find(User.class, managedUser.getId()).getActive();
	}
	
}