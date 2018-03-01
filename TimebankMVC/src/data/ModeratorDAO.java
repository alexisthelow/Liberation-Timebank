package data;

import entities.User;

public interface ModeratorDAO {
	
	//users
	
	public User promoteUser(int actingUserId, int timebankId, int userId);
	public User demoteUser(int actingUserId, int timebankId, int userId);
	public Boolean removeUserFromTimebank(int actingUserId, int timebankId, int userId);
	public Boolean banUser(int actingUserId, int userId);
	public Double alterUserHours(int actingUserId, int timebankId, int userId, Double hourDifference);
	
	//deactivate services + items
	
	public Boolean closeServiceOffer(int actingUserId, int offerId, int userId);
	public Boolean closeServiceRequest(int actingUserId, int requestId, int userId);
	public Boolean closeItemTransferOffer(int actingUserId, int offerId, int userId);
	public Boolean closeItemTransferRequest(int actingUserId, int requestId, int userId);
	public Boolean closeItemLoanOffer(int actingUserId, int offerId, int userId);
	public Boolean closeItemLoanRequest(int actingUserId, int requestId, int userId);
	
	//hide activity
	
	public Boolean hideServiceOfferActivity(int actingUserId, int activityId, int moderatorId);
	public Boolean hideServiceRequestActivity(int actingUserId, int activityId, int moderatorId);
	public Boolean hideItemTransferOfferActivity(int actingUserId, int activityId, int moderatorId);
	public Boolean hideItemTransferRequestActivity(int actingUserId, int activityId, int moderatorId);
	public Boolean hideItemLoanOfferActivity(int actingUserId, int activityId, int moderatorId);
	public Boolean hideItemLoanRequestActivity(int actingUserId, int activityId, int moderatorId);
	
	//close transactions
	
	public Boolean closeServiceOfferTx(int actingUserId, int offerTxId, int userId);
	public Boolean closeServiceRequestTx(int actingUserId, int requestTxId, int userId);
	public Boolean closeItemTransferOfferTx(int actingUserId, int offerTxId, int userId);
	public Boolean closeItemTransferRequestTx(int actingUserId, int requestTxId, int userId);
	public Boolean closeItemLoanOfferTx(int actingUserId, int offerTxId, int userId);
	public Boolean closeItemLoanRequestTx(int actingUserId, int requestTxId, int userId);
	
}
