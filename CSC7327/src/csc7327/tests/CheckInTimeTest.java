/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc7327.objects.CheckInTime;

/**
 * @author luongnv89
 *
 */
public class CheckInTimeTest {
	CheckInTime checkInTimeOK;
	CheckInTime checkInTimeKO1;
	CheckInTime checkInTimeKO2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		checkInTimeOK = new CheckInTime(540, "Tue Apr 03 18:17:18 +0000 2012");
		checkInTimeKO1 = new CheckInTime(940, "Tue Apr 03 18:17:18 +0000 2012");
		checkInTimeKO2 = new CheckInTime(540, "Tue Apr 03 18:17:18 +0000 2014");
	}

	/**
	 * Test method for {@link csc7327.objects.CheckInTime#getCityTime(java.lang.String)}.
	 */
	@Test
	public void testGetCityTime() {
		System.out.println(checkInTimeOK.getCityTime());
	}

	/**
	 * Test method for {@link csc7327.objects.CheckInTime#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(checkInTimeOK.invariant());
		assertFalse(checkInTimeKO1.invariant());
		assertFalse(checkInTimeKO2.invariant());
	}

}
