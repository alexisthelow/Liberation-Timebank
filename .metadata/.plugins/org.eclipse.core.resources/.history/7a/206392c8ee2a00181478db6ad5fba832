package controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminControllerInterface {
	
	//users
	
	public Boolean promoteUser(HttpSession session, HttpServletResponse res, @PathVariable int userId, @PathVariable int timebankId);
	public Boolean demoteUser(HttpSession session, HttpServletResponse res, @PathVariable int userId, @PathVariable int timebankId);
	public Boolean removeUserFromTimebank(HttpSession session, HttpServletResponse res, @PathVariable int userId, @PathVariable int timebankId);
	public Boolean banUser(HttpSession session, HttpServletResponse res, @PathVariable int userId);
	public Double alterUserHours(HttpSession session, HttpServletResponse res, @PathVariable int userId, @RequestBody String hourDifference);
	
	//deactivate services and items
	
	public Boolean closeServiceOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
	public Boolean closeServiceRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
	public Boolean closeItemTransferOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
	public Boolean closeItemTransferRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
	public Boolean closeItemLoanOffer(HttpSession session, HttpServletResponse res, @PathVariable int offerId);
	public Boolean closeItemLoanRequest(HttpSession session, HttpServletResponse res, @PathVariable int requestId);
	
	//hide activity
	
	public Boolean hideServiceOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
	public Boolean hideServiceRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
	public Boolean hideItemTransferOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
	public Boolean hideItemTransferRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
	public Boolean hideItemLoanOfferActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
	public Boolean hideItemLoanRequestActivity(HttpSession session, HttpServletResponse res, @PathVariable int activityId);
	
	//close transactions
	
	public Boolean closeServiceOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int offerId, @PathVariable int txId);
	public Boolean closeServiceRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId, @PathVariable int txId);
	public Boolean closeItemTransferOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int offerId, @PathVariable int txId);
	public Boolean closeItemTransferRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId, @PathVariable int txId);
	public Boolean closeItemLoanOfferTx(HttpSession session, HttpServletResponse res, @PathVariable int offerId, @PathVariable int txId);
	public Boolean closeItemLoanRequestTx(HttpSession session, HttpServletResponse res, @PathVariable int requestId, @PathVariable int txId);
	
	

}
