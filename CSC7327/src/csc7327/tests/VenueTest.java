/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc7327.objects.Venue;

/**
 * @author luongnv89
 *
 */
public class VenueTest {
	
	Venue venue;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		venue = new Venue("4a5c42f9f964a52038bc1fe3", "Restaurant");
	}

	/**
	 * Test method for {@link csc7327.objects.Venue#getVenueID()}.
	 */
	@Test
	public void testGetVenueID() {
		System.out.println(venue.getVenueID());
		assertTrue(venue.getVenueID().equals("4a5c42f9f964a52038bc1fe3"));
	}

	/**
	 * Test method for {@link csc7327.objects.Venue#getVenueCategory()}.
	 */
	@Test
	public void testGetVenueCategory() {
		System.out.println(venue.getVenueCategory());
		assertTrue(venue.getVenueCategory().equals("Restaurant"));
	}
	
	/**
	 * Test method for {@link csc7327.objects.Venue#equals(Venue)}.
	 */
	@Test
	public void testEquals() {
		assertTrue(venue.equals(venue));
		assertFalse(venue.equals(null));
	}
}
