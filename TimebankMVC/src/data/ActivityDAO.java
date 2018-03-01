package data;

import java.util.Set;

import interfaces.Activity;

public interface ActivityDAO {
	
	//create
	
	public Activity createItemTransferOfferActivity(int offerId, String activityJson);
	public Activity createItemTransferRequestActivity(int requestId, String activityJson);
	public Activity createItemLoanOfferActivity(int offerId, String activityJson);
	public Activity createItemLoanRequestActivity(int requestId, String activityJson);
	public Activity createServiceOfferActivity(int offerId, String activityJson);
	public Activity createServiceRequestActivity(int requestId, String activityJson);
	
	//read
	
		//all posts per service / item
	
	public Set<Activity> getAllItemTransferOfferActivity(int itemTransferOfferId);
	public Set<Activity> getAllItemTransferRequestActivity(int itemTransferRequestId);
	public Set<Activity> getAllItemLoanOfferActivity(int itemLoanOfferId);
	public Set<Activity> getAllItemLoanRequestActivity(int itemLoanRequestId);
	public Set<Activity> getAllServiceOfferActivity(int serviceOfferId);
	public Set<Activity> getAllServiceRequestActivity(int serviceRequestId);
	
	//update
	
	public Activity updateItemTransferOfferActivity(int userId, int activityId, String activityJson);
	public Activity updateItemTransferRequestActivity(int userId, int activityId, String activityJson);
	public Activity updateItemLoanOfferActivity(int userId, int activityId, String activityJson);
	public Activity updateItemLoanRequestActivity(int userId, int activityId, String activityJson);
	public Activity updateServiceOfferActivity(int userId, int activityId, String activityJson);
	public Activity updateServiceRequestActivity(int userId, int activityId, String activityJson);

	//destroy
	
		//TODO -- users should be able to hide posts and that should be tracked separate from mod hides

}
