package com.pharmacy.service;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the class that contains the main method to run the SpringApplication.
 * 
 * @author Shweta Parihar
 */
@ComponentScan("com.pharmacy")
@SpringBootApplication
public class PharmacyServiceApplication {

	/**
	 * The method called when the application is launched.
	 *
	 * @param args No need to pass any arguments.
	 *
	 */
	public static void main(final String[] args) {

		// Creating the new SpringApplication object.
		final SpringApplication app = new SpringApplication(PharmacyServiceApplication.class);

		// Changing the default properties collection to configure the server to start
		// on port 8181.
		app.setDefaultProperties(Collections.singletonMap("server.port", "8181"));

		// Run the application.
		app.run(args);
	}

}