package data;

import java.util.Set;

import entities.ItemLoanOffer;
import entities.ItemLoanRequest;
import entities.ItemTransferOffer;
import entities.ItemTransferRequest;
import entities.ServiceOffer;
import entities.ServiceRequest;
import entities.User;
import interfaces.Offer;
import interfaces.Request;
import interfaces.Transaction;

public interface UserDAO {
	
	//create

		//user
	
	public User createUser(int timebankId, int addressId, String userJson);
	
	//read 
	
		//check login

	public User login(String email, String password);
	
		//indices
	
	public Set<User> getUsersByTimebank(int timebankId);
	public Set<User> getModeratorsByTimebank(int timebankId);
	
		//single objects
	
	public User showUser(int userId);
	public Double showUserHoursByUserId(int timebankId, int userId);
	
		//offers + requests
	
	public Set<Offer> indexUserOffers(int userId);
	public Set<Request> indexUserRequests(int userId);
	
	public Set<ServiceOffer> indexUserServiceOffers(int userId);
	public Set<ServiceRequest> indexUserServiceRequests(int userId);
	public Set<ItemTransferOffer> indexUserItemTransferOffers(int userId);
	public Set<ItemTransferRequest> indexUserItemTransferRequests(int userId);
	public Set<ItemLoanOffer> indexUserItemLoanOffers(int userId);
	public Set<ItemLoanRequest> indexUserItemLoanRequests(int userId);
	
		//transactions
	
	public Set<Transaction> indexUserTransactions(int userId);
	
	public Set<Transaction> indexUserServiceOfferTxs(int userId);
	public Set<Transaction> indexUserServiceRequestTxs(int userId); 
	public Set<Transaction> indexUserItemTransferOfferTxs(int userId);
	public Set<Transaction> indexUserItemTransferRequestTxs(int userId);
	public Set<Transaction> indexUserItemLoanOfferTxs(int userId);
	public Set<Transaction> indexUserItemLoanRequestTxs(int userId);
	
	//update
	
	public Boolean updatePassword(int actingUserId, int userId, String oldPassword, String newPassword);
	public Boolean recoverPassword(String email);
	public Boolean updateEmail(int actingUserId, int userId, String email);
	public User updateUser(int actingUserId, int userId, int addressId, String userJson);
	public Double updateUserHours(int timebankId, int userId, Double hourDifference);
	
	//destroy
	
	public Boolean deactivateUser(int userId, int actingUserId);

}
