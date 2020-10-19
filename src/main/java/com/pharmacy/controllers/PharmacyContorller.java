package com.pharmacy.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.model.NearestPharmacyPacket;
import com.pharmacy.model.Pharmacy;

/**
 * The REST controller for the Pharmacy.
 * 
 * @author Shweta Parihar
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/pharmacy")
public class PharmacyContorller {
	
	//Logger for the class.
	private static final Logger logger = LoggerFactory.getLogger(PharmacyContorller.class);

	/**
	 * Takes in the current longitude and latitude and finds the nearest pharmacy
	 * and its distance.
	 * 
	 * @param currentLog The current longitude.
	 * @param currentLat The current latitude.
	 * @return A ResponseEntity<NearestPharmacyPacket> That contains the
	 *         name,address,city,state, the distance between two points and the http
	 *         response of success or error.
	 */
	@GetMapping()
	public ResponseEntity<NearestPharmacyPacket> findNearestPharmacy(@RequestParam final double currentLog,
			@RequestParam final double currentLat) {

		final ArrayList<Pharmacy> pharmacies;
		try {
			// read the Pharmacy data from a CSV file from resource.
			pharmacies = PharmacyUtils.readPharmacyDataFromCsv(ResourceUtils.getFile("classpath:pharmacies.csv"));
		} catch (final FileNotFoundException fnfe) {
			logger.error("An FileNotFoundException is caught while reading the pharmacy CSV file.",fnfe);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

		if (pharmacies != null && !pharmacies.isEmpty()) {

			// Get the first pharmacy from the list.
			final Pharmacy firstPharmacy = pharmacies.get(0);

			// Initialize the minimum distance to the distance between the current longitude
			// and latitude and the first pharmacy's longitude and latitude.
			double minDistance = PharmacyUtils.distance(currentLog, currentLat, firstPharmacy.getLongitude(),
					firstPharmacy.getLatitude());

			// Initialize the nearest pharmacy as the first pharmacy as well.
			Pharmacy nearestPharmacy = firstPharmacy;

			// Loop through all pharmacies to find the minimum distance. For each pass if a
			// lower distance is calculated the minDistance and nearestPharmacy are updated
			// to reflect it.
			for (final Pharmacy pharmacy : pharmacies) {
				final double pharmaDistance = PharmacyUtils.distance(currentLog, currentLat, pharmacy.getLongitude(),
						pharmacy.getLatitude());
				if (pharmaDistance < minDistance) {
					minDistance = pharmaDistance;
					nearestPharmacy = pharmacy;
				}

			}
			logger.info("Nearest Pharmacy was found!");
			// Build the NearestPharmacyPacket object and return only the necessary
			// information needed.
			return ResponseEntity.ok(new NearestPharmacyPacket(nearestPharmacy, minDistance));
		}
		logger.error("An issue occured while reading the pharmacy data from CSV source.");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
