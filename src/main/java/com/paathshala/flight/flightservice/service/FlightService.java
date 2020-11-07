package com.paathshala.flight.flightservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.paathshala.flight.flightservice.model.Booking;
import com.paathshala.flight.flightservice.model.Flight;
import com.paathshala.flight.flightservice.model.Flights;
import com.paathshala.flight.flightservice.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private Environment env;

	public Flights getAllFlights() {
		List<Flight> flightList = flightRepository.getAllFlights();
		Flights flights = new Flights();
		flights.setFlights(flightList);
		flights.setHostName(
				env.getProperty("local.server.host") + " is running on " + env.getProperty("local.server.port"));
		return flights;
	}

	public Booking bookFlight(Flight flight) {
		Booking booking = new Booking();
		String message = flightRepository.bookFlight(flight);
		booking.setFlight(flight);
		booking.setMessage(message);
		booking.setHostName(
				env.getProperty("local.server.host") + " is running on " + env.getProperty("local.server.port"));
		return booking;
	}

}
