package com.pharmacy.controllers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pharmacy.model.Pharmacy;

/**
 * The Pharmacy Util class that contains helper methods.
 * 
 * @author Shweta Parihar
 */
public class PharmacyUtils {
	
	//Logger for the class.
	private static final Logger logger = LoggerFactory.getLogger(PharmacyUtils.class);


	/**
	 * Calculates the distance in meter between two longitude and latitudes
	 * coordinates using the
	 * Haversine_formula(https://en.wikipedia.org/wiki/Haversine_formula).
	 * 
	 * @param lon1 The first longitude.
	 * @param lat1 The first latitude.
	 * @param lon2 The second longitude.
	 * @param lat2 The second latitude.
	 * 
	 * @return The distance between the two coordinates in meters.
	 */
	public static double distance(double lat1, double lon1, double lat2, double lon2) {
		if (lat1 == lat2 && lon1 == lon2) {
			return 0;
		}

		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return 3958.8 * c;
	}

	/**
	 * Reads the content of the pharmacies.csv file and turns them in to an
	 * ArrayList of type Pharmacy.
	 * 
	 * @param csvFile the CSV file from where the pharmacy data needs to be read.
	 * 
	 * @return An ArrayList of the Pharmacies read from the CSV file or null if an
	 *         exception is caught.
	 */
	public static ArrayList<Pharmacy> readPharmacyDataFromCsv(final File csvFile) {

		try {

			final CSVReader csvReader = new CSVReader(new FileReader(csvFile));

			final ArrayList<Pharmacy> pharmacies = new ArrayList<Pharmacy>();

			String[] pharmDetail = null;

			// Ignoring the first line in CSV to ignore titles of the columns.
			csvReader.readNext();

			// Fetching pharmacy details one line at a time and adding to the ArrayList.
			while ((pharmDetail = csvReader.readNext()) != null) {
				final Pharmacy pharm = new Pharmacy(pharmDetail[0], pharmDetail[1], pharmDetail[2], pharmDetail[3],
						pharmDetail[4], Double.parseDouble(pharmDetail[5]), Double.parseDouble(pharmDetail[6]));
				pharmacies.add(pharm);
			}
			return pharmacies;
		} catch (final IOException ioe) {
			logger.error("An IOException is caught while reading the Pharmacy data from CSV file.",ioe);
		} catch (final CsvValidationException cve) {
			logger.error("A CsvValidationException is caught while reading the Pharmacy data from CSV file. ",cve);
		}
		return null;
	}
}
