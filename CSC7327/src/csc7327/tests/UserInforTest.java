/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import csc7327.objects.UserInfor;

/**
 * @author luongnv89
 * 
 */
public class UserInforTest {
	UserInfor user;
	UserInfor userKO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		user = new UserInfor("264088306", 32, 82, 1);
		userKO = new UserInfor("UserID", -9, 10, -1);
	}

	/**
	 * Test method for {@link csc7327.objects.UserInfor#getUserID()}.
	 */
	@Test
	public void testGetUserID() {
		assertTrue(user.getUserID().equals("264088306"));
	}

	/**
	 * Test method for {@link csc7327.objects.UserInfor#getFollowingCount()}.
	 */
	@Test
	public void testGetFollowingCount() {
		assertTrue(user.getFollowerCount() == 82);
	}

	/**
	 * Test method for {@link csc7327.objects.UserInfor#getFollowerCount()}.
	 */
	@Test
	public void testGetFollowerCount() {
		assertTrue(user.getFollowingCount() == 32);
	}

	/**
	 * Test method for {@link csc7327.objects.UserInfor#getGender()}.
	 */
	@Test
	public void testGetGender() {
		assertTrue(user.getGender() == 1);
	}

	/**
	 * Test method for {@link csc7327.objects.UserInfor#invariant()}.
	 */
	@Test
	public void testInvariant() {
		assertTrue(user.invariant());
		assertFalse(userKO.invariant());
	}

}
