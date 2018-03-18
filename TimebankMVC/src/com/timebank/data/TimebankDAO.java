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
import entities.ServiceOffer;
import entities.ServiceOfferTx;
import entities.ServiceRequest;
import entities.ServiceRequestTx;
import entities.Timebank;

public interface TimebankDAO {
	
	//create
	
	public Timebank create(String timebankJson);
	
	//read
	
		//specific timebank
	
	public Timebank show(int timebankId);
	
		//all timebanks
	
	public List<Timebank> index();
	
		//timebank possessions
	
	public List<ServiceOffer> indexServiceOffers(int timebankId);
	public List<ServiceRequest> indexServiceRequests(int timebankId);
	
	public List<ServiceOfferTx> indexServiceOfferTxs(int timebankId);
	public List<ServiceRequestTx> indexServiceRequestTxs(int timebankId);
	
	public List<ItemTransferOffer> indexItemTransferOffers(int timebankId);
	public List<ItemTransferRequest> indexItemTransferRequests(int timebankId);
	public List<ItemLoanOffer> indexItemLoanOffers(int timebankId);
	public List<ItemLoanRequest> indexItemLoanRequests(int timebankId);
	
	public List<ItemTransferOfferTx> indexItemTransferOfferTxs(int timebankId);
	public List<ItemTransferRequestTx> indexItemTransferRequestTxs(int timebankId);
	public List<ItemLoanOfferTx> indexItemLoanOfferTxs(int timebankId);
	public List<ItemLoanRequestTx> indexItemLoanRequestTxs(int timebankId);
	
	//update
	
		//specific timebank
	
	public Timebank update(int timebankId, String timebankJson);
	
	//destroy
	
		//TODO -- just deactivate them although i think you shouldn't even be able to do that

}
