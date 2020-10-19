package com.pharmacy.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import com.pharmacy.model.Pharmacy;

/**
 * Class covering unit test for PharmacyUtils.
 * 
 * @author Shweta Parihar
 */
class PharmacyUtilsTest {

	/**
	 * Test the method to calculated distance.
	 */
	@Test
	void testDistance() {
		// Test the case where the longitude and latitudes are same.
		assertEquals(0.0, PharmacyUtils.distance(1.0, 2.0, 1.0, 2.0));
		// Test the case where longitudes are + and longitudes are -.
		assertEquals(2.2022781498861823, PharmacyUtils.distance(38.865987, -94.679613, 38.88323, -94.64518));
		// Test the case where longitudes are - and longitudes are -.
		assertEquals(2.2022781498861823, PharmacyUtils.distance(-38.865987, -94.679613, -38.88323, -94.64518));
		// Test the case where longitudes are + and longitudes are +.
		assertEquals(2.2022781498861823, PharmacyUtils.distance(38.865987, 94.679613, 38.88323, 94.64518));
		// Test the case where longitudes are - and longitudes are +.
		assertEquals(2.2022781498861823, PharmacyUtils.distance(-38.865987, 94.679613, -38.88323, 94.64518));
	}

	/**
	 * Test that readPharmacyDataFromCsv returns 0 size list for an empty file.
	 * 
	 * @throws FileNotFoundException if the csv file is not found.
	 */
	@Test
	void testReadPharmacyDataFromCsvWithEmptyfile() throws FileNotFoundException {
		final ArrayList<Pharmacy> pharmacyList = PharmacyUtils
				.readPharmacyDataFromCsv(ResourceUtils.getFile("classpath:csvfile1.csv"));
		assertEquals(0, pharmacyList.size());
	}

	/**
	 * Test that readPharmacyDataFromCsv returns the proper number of Pharmacy if
	 * the CSV file is valid.
	 * 
	 * @throws FileNotFoundException if the csv file is not found.
	 */
	@Test
	void testReadPharmacyDataFromCsv() throws FileNotFoundException {
		final ArrayList<Pharmacy> pharmacyList = PharmacyUtils
				.readPharmacyDataFromCsv(ResourceUtils.getFile("classpath:csvfile2.csv"));
		assertEquals(2, pharmacyList.size());

		assertEquals("WALGREENS", pharmacyList.get(0).getName());
		assertEquals("3696 SW TOPEKA BLVD", pharmacyList.get(0).getAddress());
		assertEquals("TOPEKA", pharmacyList.get(0).getCity());
		assertEquals("KS", pharmacyList.get(0).getState());
		assertEquals("66611", pharmacyList.get(0).getZipcode());
		assertEquals(39.00142300, pharmacyList.get(0).getLatitude());
		assertEquals(-95.68695000, pharmacyList.get(0).getLongitude());

		assertEquals("KMART PHARMACY", pharmacyList.get(1).getName());
		assertEquals("1740 SW WANAMAKER ROAD", pharmacyList.get(1).getAddress());
		assertEquals("TOPEKA", pharmacyList.get(1).getCity());
		assertEquals("KS", pharmacyList.get(1).getState());
		assertEquals("66604", pharmacyList.get(1).getZipcode());
		assertEquals(39.03504000, pharmacyList.get(1).getLatitude());
		assertEquals(-95.75870000, pharmacyList.get(1).getLongitude());
	}
}
