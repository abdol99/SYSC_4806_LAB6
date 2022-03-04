package abdalla.addressbook;

import abdalla.addressbook.AddressBook;
import abdalla.addressbook.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class JPATest {
	AddressBook addressBook;
	BuddyInfo buddyInfo;
	BuddyInfo buddyInfo2;

	@Before
	public void setUp() throws Exception {
		//create abdalla.addressbook.AddressBook
		addressBook = new AddressBook();

		//creating objects to represent some buddies
		buddyInfo = new BuddyInfo();
		buddyInfo2 = new BuddyInfo();

		buddyInfo.setName("Abdalla El Nakla");
		buddyInfo.setPhoneNumber("61309897654");

		buddyInfo2.setPhoneNumber("6131234567");
		buddyInfo2.setName("Ashton");
	}

	@Test
	public void testBuddyInfo() {
		// Connecting to the database through EntityManagerFactory
		// connection details loaded from persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();

		// Creating a new transaction
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// Persisting the buddy entity objects
		em.persist(buddyInfo);
		em.persist(buddyInfo2);

		tx.commit();

		// Querying the contents of the database using JPQL query
		Query q = em.createQuery("SELECT buddy FROM abdalla.addressbook.BuddyInfo buddy");

		@SuppressWarnings("unchecked")
		List<BuddyInfo> results = q.getResultList();

		System.out.println("List of products\n----------------");

		for (BuddyInfo buddy : results) System.out.println(buddy.getName() + " (id=" + buddy.getId() + ")");

		// Closing connection
		em.close();
		emf.close();
	}

	@Test
	public void testAddressBook() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();

		BuddyInfo buddyInfo = new BuddyInfo();
		BuddyInfo buddyInfo2 = new BuddyInfo();

		buddyInfo.setName("Abdalla El Nakla");
		buddyInfo.setPhoneNumber("61309897654");

		buddyInfo2.setPhoneNumber("6131234567");
		buddyInfo2.setName("Ashton");
		addressBook.addBuddy(buddyInfo);
		addressBook.addBuddy(buddyInfo2);

		// Creating a new transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(buddyInfo);
		em.persist(buddyInfo2);
		// Persisting the product entity objects
		em.persist(addressBook);

		tx.commit();

		// Querying the contents of the database using JPQL query
		Query q = em.createQuery("SELECT addressBook FROM abdalla.addressbook.AddressBook addressBook");

		@SuppressWarnings("unchecked")
		List<AddressBook> results = q.getResultList();

		System.out.println("List of products\n----------------");

		for (AddressBook addressBook : results) {
			System.out.println("Address book: (id=" + addressBook.getId() + ")");
			System.out.println("abdalla.addressbook.AddressBook buddies: " + addressBook.getBuddyList());
		}

		// Closing connection
		em.close();
		emf.close();
	}

}




