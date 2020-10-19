package com.pharmacy.service;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.pharmacy")
@SpringBootApplication
public class PharmacyServiceApplication {

	/**
	 * The method called when the application is launched.
	 *
	 * @param args No need to pass any arguments.
	 *
	 *             TODO : the port of can be an argument, if no args are porvided
	 *             the server can start on port 8080.
	 */
	public static void main(final String[] args) {

		// Creating the new SpringApplication object.
		final SpringApplication app = new SpringApplication(PharmacyServiceApplication.class);

		// Changing the default properties collection to configure the server to start
		// on port 8083.
		app.setDefaultProperties(Collections.singletonMap("server.port", "8181"));

		// Run the application.
		app.run(args);
	}

}