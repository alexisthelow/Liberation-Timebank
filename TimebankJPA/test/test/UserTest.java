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
import entities.User;

public class UserTest {

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
		User alexis = em.find(User.class, 1);
		assertEquals("Alexis", alexis.getFirstName());
		User hana = em.find(User.class, 2);
		assertEquals("Hana", hana.getFirstName());
	}
	
	@Test
	public void test_user_has_service_objects() {
		User alexis = em.find(User.class, 1);
		List<ServiceOffer> serviceOffers = new ArrayList<>(alexis.getUserServiceOffers());
		assertNotNull(serviceOffers);
		assertEquals("alexis service offer", serviceOffers.get(0).getTitle());
	}
	
	@Test
	public void test_user_has_item_transfer_objects() {
		
	}
	
	@Test
	public void test_user_has_item_loan_objects() {
		
	}
	
	@Test
	public void test_user_has_messages() {
		
	}
	
}
