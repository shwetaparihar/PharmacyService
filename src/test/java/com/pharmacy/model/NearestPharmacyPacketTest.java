package com.pharmacy.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Class covering unit test for NearestPharmacyPacket.
 * 
 * @author Shweta Parihar
 */
class NearestPharmacyPacketTest {

	private NearestPharmacyPacket nearestPharmacyPacket = new NearestPharmacyPacket(
			new Pharmacy("Walgreens", "123 main st", "Leawood", "Kansas", "66209", 55.6, 66.89), 10.5);

	/**
	 * Test the getAddress method.
	 */
	@Test
	void testGetAddress() {
		assertEquals("123 main st", nearestPharmacyPacket.getAddress());
	}

	/**
	 * Test the getCity method.
	 */
	@Test
	void testGetCity() {
		assertEquals("Leawood", nearestPharmacyPacket.getCity());
	}

	/**
	 * Test the getDistance method.
	 */
	@Test
	void testGetDistance() {
		assertEquals(10.5, nearestPharmacyPacket.getDistance());
	}

	/**
	 * Test the getPharmacyName method.
	 */
	@Test
	void testGetPharmacyName() {
		assertEquals("Walgreens", nearestPharmacyPacket.getPharmacyName());
	}

	/**
	 * Test the getState method.
	 */
	@Test
	void testGetState() {
		assertEquals("Kansas", nearestPharmacyPacket.getState());
	}

	/**
	 * Test the getZipCode method.
	 */
	@Test
	void testGetZipCode() {
		assertEquals("66209", nearestPharmacyPacket.getZipCode());
	}

	/**
	 * Test the toString method.
	 */
	@Test
	void testToString() {
		assertEquals("NearestPharmacyPacket [address=123 main st, city=Leawood, distance=10.5, pharmacyName=Walgreens, state=Kansas, zipCode=66209]", nearestPharmacyPacket.toString());
	}
}
