package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import entities.ItemLoanOffer;
import entities.ItemLoanOfferActivity;
import entities.ItemLoanOfferTx;
import entities.ItemLoanRequest;
import entities.ItemLoanRequestActivity;
import entities.ItemLoanRequestTx;
import entities.ItemTransferOffer;
import entities.ItemTransferOfferActivity;
import entities.ItemTransferOfferTx;
import entities.ItemTransferRequest;
import entities.ItemTransferRequestActivity;
import entities.ItemTransferRequestTx;

public interface ItemControllerInterface {
	
	//create
	
		public ItemTransferOffer createItemTransferOffer(HttpSession session, HttpServletResponse res, @RequestBody String offerJson);
		public ItemTransferOfferActivity createItemTransferOfferActivity(HttpSession session, HttpServletResponse res, @RequestBody String activityJson);
		public ItemTransferOfferTx createItemTransferOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		
		public ItemTransferRequest createItemTransferRequest(HttpSession session, HttpServletResponse res, @RequestBody String requestJson);
		public ItemTransferRequestActivity createItemTransferRequestActivity(HttpSession session, HttpServletResponse res, @RequestBody String activityJson);
		public ItemTransferRequestTx createItemTransferRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
		public ItemLoanOffer createItemLoanOffer(HttpSession session, HttpServletResponse res, @RequestBody String offerJson);
		public ItemLoanOfferActivity createItemLoanOfferActivity(HttpSession session, HttpServletResponse res, @RequestBody String activityJson);
		public ItemLoanOfferTx createItemLoanOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		
		public ItemLoanRequest createItemLoanRequest(HttpSession session, HttpServletResponse res, @RequestBody String requestJson);
		public ItemLoanRequestActivity createItemLoanRequestActivity(HttpSession session, HttpServletResponse res, @RequestBody String activityJson);
		public ItemLoanRequestTx createItemLoanRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
	//read

		//just one
		
		public ItemTransferOffer showItemTransferOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemTransferOfferActivity showItemTransferOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
		public ItemTransferOfferTx showItemTransferOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int txId);
		
		public ItemTransferRequest showItemTransferRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemTransferRequestActivity showItemTransferRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
		public ItemTransferRequestTx showItemTransferRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int txId);
		
		public ItemLoanOffer showItemLoanOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemLoanOfferActivity showItemLoanOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
		public ItemLoanOfferTx showItemLoanOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int txId);
		
		public ItemLoanRequest showItemLoanRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemLoanRequestActivity showItemLoanRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
		public ItemLoanRequestTx showItemLoanRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int txId);
		
		//index of parts
		
		public Set<ItemTransferOfferActivity> showAllItemTransferOfferActivity();
		public Set<ItemTransferOfferTx> showAllItemTransferOfferTx();
		
		public Set<ItemTransferRequestActivity> showAllItemTransferRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public Set<ItemTransferRequestTx> showAllItemTransferRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
		public Set<ItemLoanOfferActivity> showAllItemLoanOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public Set<ItemLoanOfferTx> showAllItemLoanOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
		public Set<ItemLoanRequestActivity> showAllItemLoanRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public Set<ItemLoanRequestTx> showAllItemLoanRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
		//index by user
		
		public Set<ItemTransferOffer> showUserItemTransferOffers(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemTransferOfferTx> showUserItemTransferOfferTxs(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemTransferRequest> showUserItemTransferRequests(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemTransferRequestTx> showUserItemTransferRequestTxs(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemLoanOffer> showUserItemLoanOffers(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemLoanOfferTx> showUserItemLoanOfferTxs(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemLoanRequest> showUserItemLoanRequests(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		public Set<ItemLoanRequestTx> showUserItemLoanRequestTxs(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
		
		//index by timebank
		
		public Set<ItemTransferOffer> showTimebankItemTransferOffers(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
		public Set<ItemTransferRequest> showTimebankItemTransferRequests(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
		public Set<ItemLoanOffer> showTimebankItemLoanOffers(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
		public Set<ItemLoanRequest> showTimebankItemLoanRequests(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
		
	//update
		
		//just one
		
		public ItemTransferOffer updateItemTransferOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemTransferOfferActivity updateItemTransferOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemTransferOfferTx itemTransferOfferProviderAccept(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemTransferOfferTx itemTransferOfferProviderReject(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemTransferOfferTx itemTransferOfferProviderComplete(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemTransferOfferTx itemTransferOfferRecipientComplete(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		
		public ItemTransferRequest updateItemTransferRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemTransferRequestActivity updateItemTransferRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemTransferRequestTx itemTransferRequestRecipientAccept(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemTransferRequestTx itemTransferRequestRecipientReject(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemTransferRequestTx itemTransferRequestRecipientComplete(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemTransferRequestTx itemTransferRequestProviderComplete(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
		public ItemLoanOffer updateItemLoanOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemLoanOfferActivity updateItemLoanOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemLoanOfferTx itemLoanOfferLenderAccept(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemLoanOfferTx itemLoanOfferLenderReject(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemLoanOfferTx itemLoanOfferLenderComplete(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public ItemLoanOfferTx itemLoanOfferBorrowerComplete(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		
		public ItemLoanRequest updateItemLoanRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemLoanRequestActivity updateItemLoanRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemLoanRequestTx itemLoanRequestBorrowerAccept(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemLoanRequestTx itemLoanRequestBorrowerReject(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemLoanRequestTx itemLoanRequestBorrowerComplete(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public ItemLoanRequestTx itemLoanRequestLenderComplete(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		
	//destroy
		
		//deactivate things
		
		public Boolean deactivateItemTransferOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public Boolean deactivateItemTransferRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
		public Boolean deactivateItemLoanOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
		public Boolean deactivateItemLoanRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);

}
