/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc7327.analysis.DataAnalysis;

/**
 * @author luongnv89
 * 
 */
public class DataAnalysisTest {
	DataAnalysis tokyoDataSet;
	String cityName = "Tokyo";
	String dataURL = "data/tokyo_test.txt";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tokyoDataSet = new DataAnalysis(cityName, dataURL);
	}

	/**
	 * Test method for {@link csc7327.analysis.DataAnalysis#getCityName()}.
	 */
	@Test
	public void testGetCityName() {
		assertTrue(tokyoDataSet.getCityName().equals("Tokyo"));
	}

	/**
	 * Test method for {@link csc7327.analysis.DataAnalysis#getCheckInCollections()}.
	 */
	@Test
	public void testGetCheckInCollections() {
		assertFalse(tokyoDataSet.getCheckInCollections().isEmpty());
	}

	/**
	 * Test method for {@link csc7327.analysis.DataAnalysis#toString()}.
	 */
	@Test
	public void testToString() {
		System.out.println(tokyoDataSet.toString());
	}

}
