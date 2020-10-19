package com.pharmacy.model;

/**
 * The model class that describes all attributes of a Pharmacy.
 * 
 * @author Shweta Parihar
 */
public class Pharmacy {

	private String address;
	private String city;
	private double latitude;
	private double longitude;
	private String name;
	private String state;
	private String zipcode;

	/**
	 * Constructor.
	 * 
	 * @param name      The name of the pharmacy.
	 * @param address   The address of the pharmacy.
	 * @param city      The city in which the pharmacy is located.
	 * @param state     The state in which the pharmacy is located.
	 * @param zipcode   The zip code at which the pharmacy is located.
	 * @param latitude  The latitude of the pharmacy location in radians.
	 * @param longitude The longitude of the pharmacy location in radians.
	 */
	public Pharmacy(String name, String address, String city, String state, String zipcode, double latitude,
			double longitude) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
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
	 * @return The latitude(in radians) where the pharmacy is located.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return The longitude(in radians) where the pharmacy is located.
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return The name of the pharmacy.
	 */
	public String getName() {
		return name;
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
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Overriding the toString to print the details about the pharmacy.
	 */
	@Override
	public String toString() {
		return "Pharmacy [name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
