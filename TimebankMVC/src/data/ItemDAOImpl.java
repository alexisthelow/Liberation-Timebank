package data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.ItemLoanOffer;
import entities.ItemLoanOfferTx;
import entities.ItemLoanRequest;
import entities.ItemLoanRequestTx;
import entities.ItemTransferOffer;
import entities.ItemTransferOfferTx;
import entities.ItemTransferRequest;
import entities.ItemTransferRequestTx;
import entities.User;

@Transactional
@Repository
public class ItemDAOImpl implements ItemDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public ItemTransferOffer createItemTransferOffer(int userId, int timebankId, String itemTransferOfferJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemTransferOffer newItemTransferOffer = null;
		
		try {
			newItemTransferOffer = mapper.readValue(itemTransferOfferJson, ItemTransferOffer.class);
			newItemTransferOffer.setCreated(new Timestamp(System.currentTimeMillis()));
			em.persist(newItemTransferOffer);
			em.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return newItemTransferOffer;
	}

	@Override
	public ItemTransferRequest createItemTransferRequest(int userId, int timebankId, String itemTransferRequestJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemTransferRequest newItemTransferRequest = null;
		
		try {
			newItemTransferRequest = mapper.readValue(itemTransferRequestJson, ItemTransferRequest.class);
			newItemTransferRequest.setCreated(new Timestamp(System.currentTimeMillis()));
			em.persist(newItemTransferRequest);
			em.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return newItemTransferRequest;
	}

	@Override
	public ItemLoanOffer createItemLoanOffer(int userId, int timebankId, String itemLoanOfferJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemLoanOffer newItemLoanOffer = null;
		
		try {
			newItemLoanOffer = mapper.readValue(itemLoanOfferJson, ItemLoanOffer.class);
			newItemLoanOffer.setCreated(new Timestamp(System.currentTimeMillis()));
			em.persist(newItemLoanOffer);
			em.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return newItemLoanOffer;
	}

	@Override
	public ItemLoanRequest createItemLoanRequest(int userId, int timebankId, String itemLoanRequestJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemLoanRequest newItemLoanRequest = null;
		
		try {
			newItemLoanRequest = mapper.readValue(itemLoanRequestJson, ItemLoanRequest.class);
			newItemLoanRequest.setCreated(new Timestamp(System.currentTimeMillis()));
			em.persist(newItemLoanRequest);
			em.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return newItemLoanRequest;
	}

 	@Override
	public List<ItemTransferOffer> getGlobalItemTransferOffers() {
		String query = "SELECT i FROM ItemTransferOffer i WHERE globalVisibility = 1";
		return em.createQuery(query, ItemTransferOffer.class).getResultList();
	}

	@Override
	public List<ItemTransferRequest> getGlobalItemTransferRequests() {
		String query = "SELECT i FROM ItemTransferRequest i WHERE globalVisibility = 1";
		return em.createQuery(query, ItemTransferRequest.class).getResultList();
	}

	@Override
	public List<ItemLoanOffer> getGlobalItemLoanOffers() {
		String query = "SELECT i FROM ItemLoanOffer i WHERE globalVisibility = 1";
		return em.createQuery(query, ItemLoanOffer.class).getResultList();
	}

	@Override
	public List<ItemLoanRequest> getGlobalItemLoanRequests() {
		String query = "SELECT i FROM ItemLoanRequest i WHERE globalVisibility = 1";
		return em.createQuery(query, ItemLoanRequest.class).getResultList();
	}

	@Override
	public List<ItemTransferOffer> getItemTransferOffersByCategory(int timebankId, int categoryId) {
		String query = "SELECT i FROM ItemTransferOffer i WHERE itemTransferOfferCategory = :id";
		return em.createQuery(query, ItemTransferOffer.class).setParameter("id", categoryId).getResultList();
	}

	@Override
	public List<ItemTransferRequest> getItemTransferRequestsByCategory(int timebankId, int categoryId) {
		String query = "SELECT i FROM ItemTransferRequest i WHERE itemTransferRequestCategory = :id";
		return em.createQuery(query, ItemTransferRequest.class).setParameter("id", categoryId).getResultList();
	}

	@Override
	public List<ItemLoanOffer> getItemLoanOffersByCategory(int timebankId, int categoryId) {
		String query = "SELECT i FROM ItemLoanOffer i WHERE itemLoanOfferCategory = :id";
		return em.createQuery(query, ItemLoanOffer.class).setParameter("id", categoryId).getResultList();
	}

	@Override
	public List<ItemLoanRequest> getItemLoanRequestByCategory(int timebankId, int categoryId) {
		String query = "SELECT i FROM ItemLoanRequest i WHERE itemLoanRequestCategory = :id";
		return em.createQuery(query, ItemLoanRequest.class).setParameter("id", categoryId).getResultList();
	}

	@Override
	public List<ItemTransferOffer> getItemTransferOfferBySubcategory(int timebankId, int subcategoryId) {
		String query = "SELECT i FROM ItemTransferOffer i WHERE itemTransferOfferSubcategory = :id";
		return em.createQuery(query, ItemTransferOffer.class).setParameter("id", subcategoryId).getResultList();
	}

	@Override
	public List<ItemTransferRequest> getItemTransferRequestBySubcategory(int timebankId, int subcategoryId) {
		String query = "SELECT i FROM ItemTransferRequest i WHERE itemTransferRequestSubcategory = :id";
		return em.createQuery(query, ItemTransferRequest.class).setParameter("id", subcategoryId).getResultList();
	}

	@Override
	public List<ItemLoanOffer> getItemLoanOfferBySubcategory(int timebankId, int subcategoryId) {
		String query = "SELECT i FROM ItemLoanOffer i WHERE itemLoanOfferSubcategory = :id";
		return em.createQuery(query, ItemLoanOffer.class).setParameter("id", subcategoryId).getResultList();
	}

	@Override
	public List<ItemLoanRequest> getItemLoanRequestBySubcategory(int timebankId, int subcategoryId) {
		String query = "SELECT i FROM ItemLoanRequest i WHERE itemLoanRequestSubcategory = :id";
		return em.createQuery(query, ItemLoanRequest.class).setParameter("id", subcategoryId).getResultList();
	}

	@Override
	public List<ItemTransferOffer> searchItemTransferOffers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemTransferRequest> searchItemTransferRequests(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemLoanOffer> searchItemLoanOffers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemLoanRequest> searchItemLoanRequests(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemTransferOffer getItemTransferOfferById(int itemTransferOfferId) {
		return em.find(ItemTransferOffer.class, itemTransferOfferId);
	}

	@Override
	public ItemTransferRequest getItemTransferRequestById(int itemTransferRequestId) {
		return em.find(ItemTransferRequest.class, itemTransferRequestId);
	}

	@Override
	public ItemLoanOffer getItemLoanOfferById(int itemLoanOfferId) {
		return em.find(ItemLoanOffer.class, itemLoanOfferId);
	}

	@Override
	public ItemLoanRequest getItemLoanRequestById(int itemLoanRequestId) {
		return em.find(ItemLoanRequest.class, itemLoanRequestId);
	}

	@Override
	public ItemTransferOffer updateItemTransferOffer(int userId, int itemTransferOfferId, String itemTransferOfferJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemTransferOffer managedOffer = em.find(ItemTransferOffer.class, itemTransferOfferId);
		ItemTransferOffer newOffer = null;
		
		try {
			newOffer = mapper.readValue(itemTransferOfferJson, ItemTransferOffer.class);
			managedOffer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			managedOffer.setLastUpdateUser(em.find(User.class, userId));
			managedOffer.setItemTransferOfferCategory(newOffer.getItemTransferOfferCategory());
			managedOffer.setItemTransferOfferSubcategory(newOffer.getItemTransferOfferSubcategory());
			managedOffer.setTitle(newOffer.getTitle());
			managedOffer.setDescription(newOffer.getDescription());
			managedOffer.setActive(newOffer.getActive());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return managedOffer;
	}

	@Override
	public ItemTransferRequest updateItemTransferRequest(int userId, int itemTransferRequestId, String itemTransferRequestJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemTransferRequest managedRequest = em.find(ItemTransferRequest.class, itemTransferRequestId);
		ItemTransferRequest newRequest = null;
		
		try {
			newRequest = mapper.readValue(itemTransferRequestJson, ItemTransferRequest.class);
			managedRequest.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			managedRequest.setLastUpdateUser(em.find(User.class, userId));
			managedRequest.setItemTransferRequestCategory(newRequest.getItemTransferRequestCategory());
			managedRequest.setItemTransferRequestSubcategory(newRequest.getItemTransferRequestSubcategory());
			managedRequest.setTitle(newRequest.getTitle());
			managedRequest.setDescription(newRequest.getDescription());
			managedRequest.setActive(newRequest.getActive());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return managedRequest;
	}

	@Override
	public ItemLoanOffer updateItemLoanOffer(int userId, int itemLoanOfferId, String itemLoanOfferJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemLoanOffer managedOffer = em.find(ItemLoanOffer.class, itemLoanOfferId);
		ItemLoanOffer newOffer = null;
		
		try {
			newOffer = mapper.readValue(itemLoanOfferJson, ItemLoanOffer.class);
			managedOffer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			managedOffer.setLastUpdateUser(em.find(User.class, userId));
			managedOffer.setItemLoanOfferCategory(newOffer.getItemLoanOfferCategory());
			managedOffer.setItemLoanOfferSubcategory(newOffer.getItemLoanOfferSubcategory());
			managedOffer.setTitle(newOffer.getTitle());
			managedOffer.setDescription(newOffer.getDescription());
			managedOffer.setActive(newOffer.getActive());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return managedOffer;
	}

	@Override
	public ItemLoanRequest updateItemLoanRequest(int userId, int itemLoanRequestId, String itemLoanRequestJson) {
		ObjectMapper mapper = new ObjectMapper();
		ItemLoanRequest managedRequest = em.find(ItemLoanRequest.class, itemLoanRequestId);
		ItemLoanRequest newRequest = null;
		
		try {
			newRequest = mapper.readValue(itemLoanRequestJson, ItemLoanRequest.class);
			managedRequest.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			managedRequest.setLastUpdateUser(em.find(User.class, userId));
			managedRequest.setItemLoanRequestCategory(newRequest.getItemLoanRequestCategory());
			managedRequest.setItemLoanRequestSubcategory(newRequest.getItemLoanRequestSubcategory());
			managedRequest.setTitle(newRequest.getTitle());
			managedRequest.setDescription(newRequest.getDescription());
			managedRequest.setActive(newRequest.getActive());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return managedRequest;
	}

	@Override
	public Boolean deactivateItemTransferOffer(int userId, int itemTransferOfferId) {
		ItemTransferOffer managedOffer = em.find(ItemTransferOffer.class, itemTransferOfferId);
		managedOffer.setActive(false);
		managedOffer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		managedOffer.setLastUpdateUser(em.find(User.class, userId));
		return em.find(ItemTransferOffer.class, itemTransferOfferId).getActive() == false;
	}

	@Override
	public Boolean deactivateItemTransferRequest(int userId, int itemTransferRequestId) {
		ItemTransferRequest managedRequest = em.find(ItemTransferRequest.class, itemTransferRequestId);
		managedRequest.setActive(false);
		managedRequest.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		managedRequest.setLastUpdateUser(em.find(User.class, userId));
		return em.find(ItemTransferRequest.class, itemTransferRequestId).getActive() == false;
	}

	@Override
	public Boolean deactivateItemLoanOffer(int userId, int itemLoanOfferId) {
		ItemLoanOffer managedOffer = em.find(ItemLoanOffer.class, itemLoanOfferId);
		managedOffer.setActive(false);
		managedOffer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		managedOffer.setLastUpdateUser(em.find(User.class, userId));
		return em.find(ItemLoanOffer.class, itemLoanOfferId).getActive() == false;
	}

	@Override
	public Boolean deactivateItemLoanRequest(int userId, int itemLoanRequestId) {
		ItemLoanRequest managedRequest = em.find(ItemLoanRequest.class, itemLoanRequestId);
		managedRequest.setActive(false);
		managedRequest.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		managedRequest.setLastUpdateUser(em.find(User.class, userId));
		return em.find(ItemLoanRequest.class, itemLoanRequestId).getActive() == false;
	}

	@Override
	public ItemTransferOfferTx createItemTransferOfferTx(int userId, int offerId) {
		ItemTransferOfferTx newTx = new ItemTransferOfferTx();
		newTx.setCreated(new Timestamp(System.currentTimeMillis()));
		newTx.setItemTransferOfferTxParent(em.find(ItemTransferOffer.class, offerId));
		newTx.setItemTransferOfferTxRecipient(em.find(User.class, userId));
		em.persist(newTx);
		em.flush();
		return em.find(ItemTransferOfferTx.class, newTx.getId());
	}

	@Override
	public ItemTransferRequestTx createItemTransferRequestTx(int userId, int requestId) {
		ItemTransferRequestTx newTx = new ItemTransferRequestTx();
		newTx.setCreated(new Timestamp(System.currentTimeMillis()));
		newTx.setItemTransferRequestTxParent(em.find(ItemTransferRequest.class, requestId));
		newTx.setItemTransferRequestTxProvider(em.find(User.class, userId));
		em.persist(newTx);
		em.flush();
		return em.find(ItemTransferRequestTx.class, newTx.getId());
	}

	@Override
	public ItemLoanOfferTx createItemLoanOfferTx(int userId, int offerId) {
		ItemLoanOfferTx newTx = new ItemLoanOfferTx();
		newTx.setCreated(new Timestamp(System.currentTimeMillis()));
		newTx.setItemLoanOfferTxParent(em.find(ItemLoanOffer.class, offerId));
		newTx.setItemLoanOfferTxBorrower(em.find(User.class, userId));
		em.persist(newTx);
		em.flush();
		return em.find(ItemLoanOfferTx.class, newTx.getId());
	}

	@Override
	public ItemLoanRequestTx createItemLoanRequestTx(int userId, int requestId) {
		ItemLoanRequestTx newTx = new ItemLoanRequestTx();
		newTx.setCreated(new Timestamp (System.currentTimeMillis()));
		newTx.setItemLoanRequestTxParent(em.find(ItemLoanRequest.class, requestId));
		newTx.setItemLoanRequestTxLender(em.find(User.class, userId));
		em.persist(newTx);
		em.flush();
		return em.find(ItemLoanRequestTx.class, newTx.getId());
	}

	@Override
	public ItemTransferOfferTx getItemTransferOfferTx(int txId) {
		return em.find(ItemTransferOfferTx.class, txId);
	}

	@Override
	public ItemTransferRequestTx getItemTransferRequestTx(int txId) {
		return em.find(ItemTransferRequestTx.class, txId);
	}

	@Override
	public ItemLoanOfferTx getItemLoanOfferTx(int txId) {
		return em.find(ItemLoanOfferTx.class, txId);
	}

	@Override
	public ItemLoanRequestTx getItemLoanRequestTx(int txId) {
		return em.find(ItemLoanRequestTx.class, txId);
	}

	@Override
	public ItemLoanRequestTx renewItemLoanRequest(int txId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemLoanOfferTx renewItemLoanOffer(int txId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
