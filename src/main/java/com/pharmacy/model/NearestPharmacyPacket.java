package com.pharmacy.model;

/**
 * The output packet that contains the information returned for the nearest
 * pharmacy.
 * 
 * @author Shweta Parihar
 */
public class NearestPharmacyPacket {
	private String address;
	private String city;
	private double distance;
	private String pharmacyName;
	private String state;
	private String zipCode;

	/**
	 * Constructor.
	 * 
	 * @param pharmacy the Pharmacy object for the closest pharmacy.
	 * @param distance the distance to the closest pharmacy.
	 */
	public NearestPharmacyPacket(Pharmacy pharmacy, double distance) {
		this.pharmacyName = pharmacy.getName();
		this.address = pharmacy.getAddress();
		this.city = pharmacy.getCity();
		this.zipCode = pharmacy.getZipcode();
		this.state = pharmacy.getState();
		this.distance = distance;

	}

	/**
	 * @return The address of the pharmacy.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return The city where the pharmacy is located.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the distance in meters to the nearest pharmacy.
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @return The pharmacy name.
	 */
	public String getPharmacyName() {
		return pharmacyName;
	}

	/**
	 * @return The state where the pharmacy is located.
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return The zip code where the pharmacy is located.
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Overring the toString method to return String containing information of the
	 * NearestPharmacyPacket.
	 */
	@Override
	public String toString() {
		return "NearestPharmacyPacket [address=" + address + ", city=" + city + ", distance=" + distance
				+ ", pharmacyName=" + pharmacyName + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
}
