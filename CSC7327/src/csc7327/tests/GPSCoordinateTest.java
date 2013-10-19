/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc7327.objects.GPSCoordinate;

/**
 * @author luongnv89
 * 
 */
public class GPSCoordinateTest {
	GPSCoordinate gps;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gps = new GPSCoordinate(12.11f, -12.89f);
	}

	/**
	 * Test method for {@link csc7327.objects.GPSCoordinate#getLatitude()}.
	 */
	@Test
	public void testGetLatitude() {
		assertTrue(gps.getLatitude() == 12.11f);
	}

	/**
	 * Test method for {@link csc7327.objects.GPSCoordinate#getLongitude()}.
	 */
	@Test
	public void testGetLongitude() {
		assertTrue(gps.getLongitude() == -12.89f);
	}

	/**
	 * Test method for
	 * {@link csc7327.objects.GPSCoordinate#equals(GPSCoordinate)}.
	 */
	@Test
	public void testEquals() {
		assertTrue(gps.equals(gps));
		assertFalse(gps.equals(new GPSCoordinate(-10.0f, -11.12f)));
	}

	/**
	 * Test method for {@link csc7327.objects.GPSCoordinate#getLongitude()}.
	 */
	@Test
	public void testToString() {
		System.out.println(gps.toString());
	}

}
