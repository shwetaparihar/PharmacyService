package com.pharmacy.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class covering unit test for Pharmacy.
 * 
 * @author Shweta Parihar
 */
class PharmacyTest {

	private Pharmacy pharmacy = new Pharmacy("CVS", "123 Main St", "some city", "XX", "12345", 2.3, 2.4);

	/**
	 * Test the getAddress method.
	 */
	@Test
	void testGetAddress() {
		assertEquals("123 Main St", pharmacy.getAddress());
	}

	/**
	 * Test the getCity method.
	 */
	@Test
	void testGetCity() {
		assertEquals("some city", pharmacy.getCity());
	}

	/**
	 * Test the getLatitude method.
	 */
	@Test
	void testGetLatitude() {
		assertEquals(2.3, pharmacy.getLatitude());
	}

	/**
	 * Test the getLongitude method.
	 */
	@Test
	void testGetLongitude() {
		assertEquals(2.4, pharmacy.getLongitude());
	}

	/**
	 * Test the getName method.
	 */
	@Test
	void testGetName() {
		assertEquals("CVS", pharmacy.getName());
	}

	/**
	 * Test the getState method.
	 */
	@Test
	void testGetState() {
		assertEquals("XX", pharmacy.getState());
	}

	/**
	 * Test the getZipcode method.
	 */
	@Test
	void testGetZipcode() {
		assertEquals("12345", pharmacy.getZipcode());
	}

	/**
	 * Test the toString method.
	 */
	@Test
	void testToString() {
		assertEquals(
				"Pharmacy [name=CVS, address=123 Main St, city=some city, state=XX, zipcode=12345, latitude=2.3, longitude=2.4]",
				pharmacy.toString());
	}

}
