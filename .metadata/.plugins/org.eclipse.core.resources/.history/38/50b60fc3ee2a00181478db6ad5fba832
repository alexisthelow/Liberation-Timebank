package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.ActivityDAO;
import data.AddressDAO;
import data.ServiceDAO;
import entities.ServiceOffer;
import entities.ServiceOfferActivity;
import entities.ServiceOfferDestination;
import entities.ServiceOfferOrigin;
import entities.ServiceOfferSchedule;
import entities.ServiceOfferTx;
import entities.ServiceRequest;
import entities.ServiceRequestActivity;
import entities.ServiceRequestDestination;
import entities.ServiceRequestOrigin;
import entities.ServiceRequestTimeWindow;
import entities.ServiceRequestTx;

@RestController
public class ServiceControllerImpl implements ServiceControllerInterface {
	
	@Autowired
	ServiceDAO serviceDAO;
	
	@Autowired
	ActivityDAO activityDAO;
	
	@Autowired
	AddressDAO addressDAO;

	@Override
	@RequestMapping(path = "/so/create/{timebankId}", method = RequestMethod.POST)
	public ServiceOffer createServiceOffer(HttpSession session, HttpServletResponse res, 
			@PathVariable int timebankId, @RequestBody String offerJson) {
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/schedule", method = RequestMethod.POST)
	public ServiceOfferSchedule createServiceOfferSchedule(HttpSession session, HttpServletResponse res, int offerId,
			String scheduleJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/origin", method = RequestMethod.POST)
	public ServiceOfferOrigin createServiceOfferOrigin(HttpSession session, HttpServletResponse res, int offerId,
			int addressId, String originJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/destination", method = RequestMethod.POST)
	public ServiceOfferDestination createServiceOfferDestination(HttpSession session, HttpServletResponse res,
			int offerId, int addressId, String destinationJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/tx", method = RequestMethod.POST)
	public ServiceOfferTx createServiceOfferTx(HttpSession session, HttpServletResponse res, int offerId,
			String txJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/activity", method = RequestMethod.POST)
	public ServiceOfferActivity createServiceOfferActivity(HttpSession session, HttpServletResponse res, int offerId,
			String activityJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/create/{timebankId}", method = RequestMethod.POST)
	public ServiceRequest createServiceRequest(HttpSession session, HttpServletResponse res, 
			@PathVariable int timebankId, String requestJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/window", method = RequestMethod.POST)
	public ServiceRequestTimeWindow createServiceRequestTimeWindow(HttpSession session, HttpServletResponse res,
			int requestId, String windowJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/origin", method = RequestMethod.POST)
	public ServiceRequestOrigin createServiceRequestOrigin(HttpSession session, HttpServletResponse res, int requestId,
			int addressId, String originJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/destination", method = RequestMethod.POST)
	public ServiceRequestDestination createServiceRequestDestination(HttpSession session, HttpServletResponse res,
			int requestId, int addressId, String destinationJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/tx", method = RequestMethod.POST)
	public ServiceRequestTx createServiceRequestTx(HttpSession session, HttpServletResponse res, int requestId,
			String txJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/activity", method = RequestMethod.POST)
	public ServiceRequestActivity createServiceRequestActivity(HttpSession session, HttpServletResponse res,
			int requestId, String activityJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}", method = RequestMethod.GET)
	public ServiceOffer showServiceOffer(HttpSession session, HttpServletResponse res, int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/schedule", method = RequestMethod.GET)
	public ServiceOfferSchedule showServiceOfferSchedule(HttpSession session, HttpServletResponse res, int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/origin/{originId}", method = RequestMethod.GET)
	public ServiceOfferOrigin showServiceOfferOrigin(HttpSession session, HttpServletResponse res, int offerId,
			int originId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/destination/{destinationId}", method = RequestMethod.GET)
	public ServiceOfferDestination showServiceOfferDestination(HttpSession session, HttpServletResponse res,
			int offerId, int destinationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/activity/{activityId}", method = RequestMethod.GET)
	public ServiceOfferActivity showServiceOfferActivity(HttpSession session, HttpServletResponse res, int offerId,
			int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}", method = RequestMethod.GET)
	public ServiceRequest showServiceRequest(HttpSession session, HttpServletResponse res, int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/window/{windowId}", method = RequestMethod.GET)
	public ServiceRequestTimeWindow showServiceRequestTimeWindow(HttpSession session, HttpServletResponse res,
			int requestId, int windowId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/origin/{originId}", method = RequestMethod.GET)
	public ServiceRequestOrigin showServiceRequestOrigin(HttpSession session, HttpServletResponse res, int requestId,
			int originId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/destination/{destinationId}", method = RequestMethod.GET)
	public ServiceRequestDestination showServiceRequestDestination(HttpSession session, HttpServletResponse res,
			int requestId, int destinationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/activity/{activityId}", method = RequestMethod.GET)
	public ServiceRequestActivity showServiceRequestActivity(HttpSession session, HttpServletResponse res,
			int requestId, int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/origin", method = RequestMethod.GET)
	public Set<ServiceOfferOrigin> getAllServiceOfferOrigins(HttpSession session, HttpServletResponse res,
			int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/destination", method = RequestMethod.GET)
	public Set<ServiceOfferDestination> getAllServiceOfferDestinations(HttpSession session, HttpServletResponse res,
			int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/activity", method = RequestMethod.GET)
	public Set<ServiceOfferActivity> getAllServiceOfferActivity(HttpSession session, HttpServletResponse res,
			int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/window", method = RequestMethod.GET)
	public Set<ServiceRequestTimeWindow> getAllServiceRequestTimeWindows(HttpSession session, HttpServletResponse res,
			int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/origin", method = RequestMethod.GET)
	public Set<ServiceRequestOrigin> getAllServiceRequestOrigins(HttpSession session, HttpServletResponse res,
			int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/destination", method = RequestMethod.GET)
	public Set<ServiceRequestDestination> getAllServiceRequestDestinations(HttpSession session, HttpServletResponse res,
			int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/activity", method = RequestMethod.GET)
	public Set<ServiceRequestActivity> getAllServiceRequestActivity(HttpSession session, HttpServletResponse res,
			int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/user/{userId}", method = RequestMethod.GET)
	public Set<ServiceOffer> getServiceOffersByUser(HttpSession session, HttpServletResponse res, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/user/{userId}", method = RequestMethod.GET)
	public Set<ServiceRequest> getServiceRequestsByUser(HttpSession session, HttpServletResponse res, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/timebank/{timebankId}", method = RequestMethod.GET)
	public Set<ServiceOffer> getServiceOffersByTimebank(HttpSession session, HttpServletResponse res, int timebankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/timebank/{timebankId}", method = RequestMethod.GET)
	public Set<ServiceRequest> getServiceRequestsByTimebank(HttpSession session, HttpServletResponse res,
			int timebankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/global", method = RequestMethod.GET)
	public Set<ServiceOffer> getGlobalServiceOffers(HttpSession session, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/global", method = RequestMethod.GET)
	public Set<ServiceRequest> getGlobalServiceRequests(HttpSession session, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}", method = RequestMethod.PUT)
	public ServiceOffer updateServiceOffer(HttpSession session, HttpServletResponse res, int offerId,
			String offerJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/schedule/{scheduleId}", method = RequestMethod.PUT)
	public ServiceOfferSchedule updateServiceOfferSchedule(HttpSession session, HttpServletResponse res, int offerId,
			String scheduleJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/origin/{originId}", method = RequestMethod.PUT)
	public ServiceOfferOrigin updateServiceOfferOrigin(HttpSession session, HttpServletResponse res, int offerId,
			int addressId, String originJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/destination/{destinationId}", method = RequestMethod.PUT)
	public ServiceOfferDestination updateServiceOfferDestination(HttpSession session, HttpServletResponse res,
			int offerId, int addressId, String destinationJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/activity/{activityId}", method = RequestMethod.PUT)
	public ServiceOfferActivity updateServiceOfferActivity(HttpSession session, HttpServletResponse res, int offerId,
			int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/providerAccept", method = RequestMethod.GET)
	public ServiceOfferTx serviceOfferProviderAccept(HttpSession session, HttpServletResponse res, int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/providerReject", method = RequestMethod.GET)
	public ServiceOfferTx serviceOfferProviderReject(HttpSession session, HttpServletResponse res, int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/recipientComplete", method = RequestMethod.GET)
	public ServiceOfferTx serviceOfferRecipientComplete(HttpSession session, HttpServletResponse res, int offerId,
			String txJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/providerComplete", method = RequestMethod.GET)
	public ServiceOfferTx serviceOfferProviderComplete(HttpSession session, HttpServletResponse res, int offerId,
			String txJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}", method = RequestMethod.PUT)
	public ServiceRequest updateServiceRequest(HttpSession session, HttpServletResponse res, int requestId,
			String requestJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/window/{windowId}", method = RequestMethod.PUT)
	public ServiceRequestTimeWindow updateServiceRequestTimeWindow(HttpSession session, HttpServletResponse res,
			int requestId, String windowJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/origin/{originId}", method = RequestMethod.PUT)
	public ServiceRequestOrigin updateServiceRequestOrigin(HttpSession session, HttpServletResponse res, int requestId,
			int addressId, String originJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/destination/{destinationId}", method = RequestMethod.PUT)
	public ServiceRequestDestination updateServiceRequestDestination(HttpSession session, HttpServletResponse res,
			int requestId, int addressId, String destinationJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/activity/{activityId}", method = RequestMethod.PUT)
	public ServiceRequestActivity updateServiceRequestActivity(HttpSession session, HttpServletResponse res,
			int requestId, int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/recipientAccept", method = RequestMethod.GET)
	public ServiceRequestTx serviceRequestRecipientAccept(HttpSession session, HttpServletResponse res, int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/recipientReject", method = RequestMethod.GET)
	public ServiceRequestTx serviceRequestRecipientReject(HttpSession session, HttpServletResponse res, int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/recipientComplete", method = RequestMethod.GET)
	public ServiceRequestTx serviceRequestRecipientComplete(HttpSession session, HttpServletResponse res, int requestId,
			String txJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/providerComplete", method = RequestMethod.GET)
	public ServiceRequestTx serviceRequestProviderComplete(HttpSession session, HttpServletResponse res, int requestId,
			String txJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/so/{offerId}/deactivate", method = RequestMethod.GET)
	public Boolean deactivateServiceOffer(HttpSession session, HttpServletResponse res, int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/sr/{requestId}/deactivate", method = RequestMethod.GET)
	public Boolean deactivateServiceRequest(HttpSession session, HttpServletResponse res, int requestId) {
		// TODO Auto-generated method stub
		return null;
	}

}