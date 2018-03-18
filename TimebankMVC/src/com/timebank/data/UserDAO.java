package com.timebank.data;

import java.util.List;

import com.mchange.util.DuplicateElementException;

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
import entities.User;
import javassist.NotFoundException;

public interface UserDAO {
	
	//create

		//user
	
	public User createUser(int timebankId, int addressId, String userJson) throws DuplicateElementException;
	
	//read 
	
		//check login

	public User login(String userJson) throws NotFoundException;
	
		//indices
	
	public List<User> getUsersByTimebank(int timebankId);
	public List<User> getModeratorsByTimebank(int timebankId);
	
		//single objects
	
	public User showUser(int userId);
	public Double showUserHoursByUserId(int timebankId, int userId);
	
		//offers + requests
	
//	public List<Offer> indexUserOffers(int userId);
//	public List<Request> indexUserRequests(int userId);
	
	public List<ServiceOffer> indexUserServiceOffers(int userId);
	public List<ServiceRequest> indexUserServiceRequests(int userId);
	public List<ItemTransferOffer> indexUserItemTransferOffers(int userId);
	public List<ItemTransferRequest> indexUserItemTransferRequests(int userId);
	public List<ItemLoanOffer> indexUserItemLoanOffers(int userId);
	public List<ItemLoanRequest> indexUserItemLoanRequests(int userId);
	
		//transactions
	
//	public List<Transaction> indexUserTransactions(int userId);
	
	public List<ServiceOfferTx> indexUserServiceOfferTxs(int userId);
	public List<ServiceRequestTx> indexUserServiceRequestTxs(int userId); 
	public List<ItemTransferOfferTx> indexUserItemTransferOfferTxs(int userId);
	public List<ItemTransferRequestTx> indexUserItemTransferRequestTxs(int userId);
	public List<ItemLoanOfferTx> indexUserItemLoanOfferTxs(int userId);
	public List<ItemLoanRequestTx> indexUserItemLoanRequestTxs(int userId);
	
	//update
	
	public Boolean updatePassword(User actingUser, User managedUser, String oldPassword, String newPassword);
//	public Boolean recoverPassword(String email);
	public User updateUser(int actingUserId, int updateUserId, int updatedAddressId, String userJson);
	public Double updateUserHours(int timebankId, int updateUserId, Double hourDifference);
	
	//destroy
	
	public Boolean deactivateUser(User actingUser, User managedUser);

}
