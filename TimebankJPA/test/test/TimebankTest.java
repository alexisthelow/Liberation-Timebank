package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.ServiceOffer;
import entities.ServiceRequest;
import entities.Timebank;
import entities.User;

public class TimebankTest {

	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("timebank");
		em = emf.createEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	public void test_connection() {
		Timebank timebank = em.find(Timebank.class, 1);
		assertEquals("liberation timebank", timebank.getTitle());
	}
	
	@Test
	public void test_timebank_has_things() {
		Timebank timebank = em.find(Timebank.class, 1);
		List<ServiceOffer> serviceOffers = new ArrayList<>(timebank.getTimebankServiceOffers());
		List<ServiceRequest> serviceRequests = new ArrayList<>(timebank.getTimebankServiceRequests());
		assertNotNull(serviceOffers);
		assertNotNull(serviceRequests);
		assertEquals("alexis service offer", serviceOffers.get(0).getTitle());
		assertEquals("plz do a skill", serviceRequests.get(0).getTitle());
		
		List<User> users = new ArrayList<>(timebank.getTimebankUsers());
		assertNotNull(users);
		assertEquals("Alexis", users.get(0).getFirstName());
	}

}
