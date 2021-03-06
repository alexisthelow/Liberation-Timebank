package com.timebank.data;

import entities.User;

public interface ModeratorDAO {
	
	//users
	
	public Boolean promoteUser(int timebankId, User promoteUser);
	public Boolean demoteUser(int timebankId, User demoteUser);
	public Boolean removeUserFromTimebank(int timebankId, User removeUser);
	public Boolean banUser(User banUser);
	public Double alterUserHours(int timebankId, User changeUser, Double hourDifference);
	
	//deactivate services + items
	
	public Boolean closeServiceOffer(int offerId, User actingUser);
	public Boolean closeServiceRequest(int requestId, User actingUser);
	public Boolean closeItemTransferOffer(int offerId, User actingUser);
	public Boolean closeItemTransferRequest(int requestId, User actingUser);
	public Boolean closeItemLoanOffer(int offerId, User actingUser);
	public Boolean closeItemLoanRequest(int requestId, User actingUser);
	
	//hide activity
	
	public Boolean hideServiceOfferActivity(int activityId, User actingUser);
	public Boolean hideServiceRequestActivity(int activityId, User actingUser);
	public Boolean hideItemTransferOfferActivity(int activityId, User actingUser);
	public Boolean hideItemTransferRequestActivity(int activityId, User actingUser);
	public Boolean hideItemLoanOfferActivity(int activityId, User actingUser);
	public Boolean hideItemLoanRequestActivity(int activityId, User actingUser);
	
	//close transactions
	
	public Boolean closeServiceOfferTx(int offerTxId, User actingUser);
	public Boolean closeServiceRequestTx(int requestTxId, User actingUser);
	public Boolean closeItemTransferOfferTx(int offerTxId, User actingUser);
	public Boolean closeItemTransferRequestTx(int requestTxId, User actingUser);
	public Boolean closeItemLoanOfferTx(int offerTxId, User actingUser);
	public Boolean closeItemLoanRequestTx(int requestTxId, User actingUser);
	
}
