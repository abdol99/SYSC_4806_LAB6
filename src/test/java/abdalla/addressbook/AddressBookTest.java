package abdalla.addressbook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

	AddressBook book;
	BuddyInfo buddyInfo1;
	BuddyInfo buddyInfo2;

	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
		buddyInfo1 = new BuddyInfo("Abdalla", "6132122112");
		buddyInfo2 = new BuddyInfo("Tim", "6133339977");
	}

	@Test
	public void testAddBuddy() {
		assertEquals(0, book.getAddressBookSize());
		book.addBuddy(buddyInfo1);
		assertEquals(1, book.getAddressBookSize());
		book.addBuddy(buddyInfo2);
		assertEquals(2, book.getAddressBookSize());
	}
}
