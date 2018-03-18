package com.timebank.data;

import java.util.List;

import entities.ItemLoanOfferActivity;
import entities.ItemLoanRequestActivity;
import entities.ItemTransferOfferActivity;
import entities.ItemTransferRequestActivity;
import entities.ServiceOfferActivity;
import entities.ServiceRequestActivity;
import entities.User;
import interfaces.Activity;

public interface ActivityDAO {
	
	//create
	
	public Activity createItemTransferOfferActivity(int offerId, User user, String activityJson);
	public Activity createItemTransferRequestActivity(int requestId, User user, String activityJson);
	public Activity createItemLoanOfferActivity(int offerId, User user, String activityJson);
	public Activity createItemLoanRequestActivity(int requestId, User user, String activityJson);
	public Activity createServiceOfferActivity(int offerId, User user, String activityJson);
	public Activity createServiceRequestActivity(int requestId, User user, String activityJson);
	
	//read
	
		//all posts per service / item
	
	public List<ItemTransferOfferActivity> indexItemTransferOfferActivity(int offerId);
	public List<ItemTransferRequestActivity> indexItemTransferRequestActivity(int requestId);
	public List<ItemLoanOfferActivity> indexItemLoanOfferActivity(int offerId);
	public List<ItemLoanRequestActivity> indexItemLoanRequestActivity(int requestId);
	public List<ServiceOfferActivity> indexServiceOfferActivity(int offerId);
	public List<ServiceRequestActivity> indexServiceRequestActivity(int requestId);
	
	//update
	
	public Activity updateItemTransferOfferActivity(int activityId, User actingUser, String activityJson);
	public Activity updateItemTransferRequestActivity(int activityId, User actingUser, String activityJson);
	public Activity updateItemLoanOfferActivity(int activityId, User actingUser, String activityJson);
	public Activity updateItemLoanRequestActivity(int activityId, User actingUser, String activityJson);
	public Activity updateServiceOfferActivity(int activityId, User actingUser, String activityJson);
	public Activity updateServiceRequestActivity(int activityId, User actingUser, String activityJson);

	//destroy
	
		//TODO -- users should be able to hide posts and that should be tracked separate from mod hides

}
