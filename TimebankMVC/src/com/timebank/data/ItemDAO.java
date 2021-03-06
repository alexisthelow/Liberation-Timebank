package com.timebank.data;

import java.util.List;

import entities.ItemLoanOffer;
import entities.ItemLoanOfferTx;
import entities.ItemLoanRequest;
import entities.ItemLoanRequestTx;
import entities.ItemTransferOffer;
import entities.ItemTransferOfferTx;
import entities.ItemTransferRequest;
import entities.ItemTransferRequestTx;
import entities.Timebank;
import entities.User;
import interfaces.Loan;
import interfaces.Transaction;

public interface ItemDAO {
	
	//create
	
		//single objects
	
	public ItemTransferOffer createItemTransferOffer(Timebank timebank, User user, String itemTransferOfferJson);
	public ItemTransferRequest createItemTransferRequest(Timebank timebank, User user, String itemTransferRequestJson);
	public ItemLoanOffer createItemLoanOffer(Timebank timebank, User user, String itemLoanOfferJson);
	public ItemLoanRequest createItemLoanRequest(Timebank timebank, User user, String itemLoanRequestJson);
	
	public ItemTransferOfferTx createItemTransferOfferTx(User user, int offerId);
	public ItemTransferRequestTx createItemTransferRequestTx(User user, int requestId);
	public ItemLoanOfferTx createItemLoanOfferTx(User user, int offerId);
	public ItemLoanRequestTx createItemLoanRequestTx(User user, int requestId);
	
	//read
	
		//global indices
	
	public List<ItemTransferOffer> getGlobalItemTransferOffers();
	public List<ItemTransferRequest> getGlobalItemTransferRequests();
	public List<ItemLoanOffer> getGlobalItemLoanOffers();
	public List<ItemLoanRequest> getGlobalItemLoanRequests();
	
		//category indices
	
	public List<ItemTransferOffer> getItemTransferOffersByCategory(int timebankId, int categoryId);
	public List<ItemTransferRequest> getItemTransferRequestsByCategory(int timebankId, int categoryId);
	public List<ItemLoanOffer> getItemLoanOffersByCategory(int timebankId, int categoryId);
	public List<ItemLoanRequest> getItemLoanRequestByCategory(int timebankId, int categoryId);

		//subcategory indices
	
	public List<ItemTransferOffer> getItemTransferOfferBySubcategory(int timebankId, int subcategoryId);	
	public List<ItemTransferRequest> getItemTransferRequestBySubcategory(int timebankId, int subcategoryId);	
	public List<ItemLoanOffer> getItemLoanOfferBySubcategory(int timebankId, int subcategoryId);	
	public List<ItemLoanRequest> getItemLoanRequestBySubcategory(int timebankId, int subcategoryId);	
	
		//search indices
	
//	public Set<ItemTransferOffer> searchItemTransferOffers(String searchTerm);
//	public Set<ItemTransferRequest> searchItemTransferRequests(String searchTerm);
//	public Set<ItemLoanOffer> searchItemLoanOffers(String searchTerm);
//	public Set<ItemLoanRequest> searchItemLoanRequests(String searchTerm);
	
		//single objects
	
	public ItemTransferOffer showItemTransferOffer(int itemTransferOfferId);
	public ItemTransferRequest showItemTransferRequest(int itemTransferRequestId);
	public ItemLoanOffer showItemLoanOffer(int itemLoanOfferId);
	public ItemLoanRequest showItemLoanRequest(int itemLoanRequestId);
	
		//tx
	
	public ItemTransferOfferTx showItemTransferOfferTx(int txId);
	public ItemTransferRequestTx showItemTransferRequestTx(int txId);
	public ItemLoanOfferTx showItemLoanOfferTx(int txId);
	public ItemLoanRequestTx showItemLoanRequestTx(int txId);
	
		//tx index
	
	public List<Transaction> indexItemTransferOfferTx(int offerId);
	public List<Transaction> indexItemTransferRequestTx(int requestId);
	public List<Transaction> indexItemLoanOfferTx(int offerId);
	public List<Transaction> indexItemLoanRequestTx(int requestId);
	
	//update
	
		//single objects
	
	public ItemTransferOffer updateItemTransferOffer(User actingUser, ItemTransferOffer managedOffer, String itemTransferOfferJson);
	public ItemTransferRequest updateItemTransferRequest(User actingUser, ItemTransferRequest managedRequest, String itemTransferRequestJson);
	public ItemLoanOffer updateItemLoanOffer(User actingUser, ItemLoanOffer managedOffer, String itemLoanOfferJson);
	public ItemLoanRequest updateItemLoanRequest(User actingUser, ItemLoanRequest managedRequest, String itemLoanRequestJson);
	
	public Transaction parentUserAccept(User actingUser, Transaction transaction);
	public Transaction parentUserReject(User actingUser, Transaction transaction);
	public Transaction parentUserComplete(User actingUser, Transaction transaction);
	public Transaction ownerComplete(User actingUser, Transaction transaction);
	public Loan determineLoanDates(Loan loan);
	public Loan renewLoan(User actingUser, Loan loan, Integer renewDays);
	
	//destroy
		
		//single objects
	
	public Boolean deactivateItemTransferOffer(User actingUser, int itemTransferOfferId);
	public Boolean deactivateItemTransferRequest(User actingUser, int itemTransferRequestId);
	public Boolean deactivateItemLoanOffer(User actingUser, int itemLoanOfferId);
	public Boolean deactivateItemLoanRequest(User actingUser, int itemLoanRequestId);
	
}