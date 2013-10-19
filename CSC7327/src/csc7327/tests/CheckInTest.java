/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc7327.objects.CheckIn;
import csc7327.objects.CheckInTime;
import csc7327.objects.GPSCoordinate;
import csc7327.objects.Gender;
import csc7327.objects.UserInfor;
import csc7327.objects.Venue;

/**
 * @author luongnv89
 *
 */
public class CheckInTest {
	UserInfor user;
	Venue venue;
	GPSCoordinate gps;
	CheckInTime checkInTime;
	CheckIn checkin;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		user = new UserInfor("userID", 10, 120, Gender.FEMALE);
		venue = new Venue("venueID", "Coffee shop");
		gps = new GPSCoordinate(12.10f, -11.12f);
		checkInTime = new CheckInTime(120, "Tue Apr 03 18:17:18 2012");
		checkin = new CheckIn("userID	10	120	female	venueID	Coffee shop	12.10	-11.12	120	Tue Apr 03 18:17:18 2012");
	}

	/**
	 * Test method for {@link csc7327.objects.CheckIn#getUser()}.
	 */
	@Test
	public void testGetUser() {
		assertTrue(checkin.getUser().getUserID().equals(user.getUserID()));
	}

	/**
	 * Test method for {@link csc7327.objects.CheckIn#getVenue()}.
	 */
	@Test
	public void testGetVenue() {
		assertTrue(checkin.getVenue().equals(venue));
	}

	/**
	 * Test method for {@link csc7327.objects.CheckIn#getGpsCoordinates()}.
	 */
	@Test
	public void testGetGpsCoordinates() {
		assertTrue(checkin.getGpsCoordinates().equals(gps));
	}

	/**
	 * Test method for {@link csc7327.objects.CheckIn#getCheckInTime()}.
	 */
	@Test
	public void testGetCheckInTime() {
		System.out.println(checkInTime.getCityTime());
	}

}
