package data;

import java.util.List;

import entities.ServiceOffer;
import entities.ServiceOfferDestination;
import entities.ServiceOfferOrigin;
import entities.ServiceOfferSchedule;
import entities.ServiceOfferTx;
import entities.ServiceRequest;
import entities.ServiceRequestDestination;
import entities.ServiceRequestOrigin;
import entities.ServiceRequestTimeWindow;
import entities.ServiceRequestTx;

public interface ServiceDAO {
	
	//create
	
		//service offer 
	
	public ServiceOffer createServiceOffer(int timebankId, int userId, String offerJson);
	public ServiceOfferSchedule createServiceOfferSchedule(int offerId, String scheduleJson);
	public ServiceOfferOrigin createServiceOfferOrigin(int offerId, int addressId, String originJson);
	public ServiceOfferDestination createServiceOfferDestination(int offerId, int addressId, String destinationJson);

		//service request 
	
	public ServiceRequest createServiceRequest(int timebankId, int userId, String requestJson);
	public ServiceRequestTimeWindow createServiceRequestTimeWindow(int requestId, String timeWindowJson);
	public ServiceRequestOrigin createServiceRequestOrigin(int requestId, int addressId, String originJson);
	public ServiceRequestDestination createServiceRequestDestination(int requestId, int addressId, String destinationJson);

		//tx
	
	public ServiceOfferTx createServiceOfferTx(int userId, int offerId);
	public ServiceRequestTx createServiceRequestTx(int userId, int requestId);
	
	//read
	
		//all global services

	public List<ServiceOffer> getAllGlobalServiceOffers();
	public List<ServiceRequest> getAllGlobalServiceRequests();
	
		//specific services
	
	public ServiceOffer showServiceOffer(int offerId);
	public ServiceRequest showServiceRequest(int requestId);
	
		//origins by service
	
	public List<ServiceOfferOrigin> getServiceOfferOrigins(int offerId);
	public List<ServiceRequestOrigin> getServiceRequestOrigins(int requestId);
	
		//destinations by service

	public List<ServiceOfferDestination> getServiceOfferDestinations(int offerId);
	public List<ServiceRequestDestination> getServiceRequestDestinations(int requestId);
	
		//tx
	
	public ServiceOfferTx getServiceOfferTx(int txId);
	public ServiceRequestTx getServiceRequestTx(int txId);
	
	//update
	
		//service offer
	
	public ServiceOffer updateServiceOffer(int actingUserId, int offerId, String offerJson);
	public ServiceOfferSchedule updateServiceOfferSchedule(int actingUserId, int scheduleId, String scheduleJson);
	public ServiceOfferOrigin updateServiceOfferOrigin(int actingUserId, int originId, String originJson);
	public ServiceOfferDestination updateServiceOfferDestination(int actingUserId, int destinationId, String destinationJson);

		//service request 
		
	public ServiceRequest updateServiceRequest(int actingUserId, int requestId, String requestJson);
	public ServiceRequestTimeWindow updateServiceRequestTimeWindow(int actingUserId, int windowId, String windowJson);
	public ServiceRequestOrigin updateServiceRequestOrigin(int actingUserId, int originId, String originJson);
	public ServiceRequestDestination updateServiceRequestDestination(int actingUserId, int destinationId, String destinationJson);
	
	//destroy
	
		//just deactivate
	
	public Boolean deactivateServiceOffer(int actingUserId, int offerId);
	public Boolean deactivateServiceRequest(int actingUserId, int requestId);

}
