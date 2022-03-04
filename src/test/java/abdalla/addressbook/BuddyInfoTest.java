package abdalla.addressbook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
	BuddyInfo buddyInfo;

	@Before
	public void setUp() throws Exception {
		buddyInfo = new BuddyInfo("Abdalla","6132223333");
	}

	@Test
	public void testGetName() {
		assertEquals("Abdalla", buddyInfo.getName());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("6132223333", buddyInfo.getPhoneNumber());
	}
}
