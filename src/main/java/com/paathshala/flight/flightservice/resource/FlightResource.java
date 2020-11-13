package com.paathshala.flight.flightservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paathshala.flight.flightservice.model.Booking;
import com.paathshala.flight.flightservice.model.Flight;
import com.paathshala.flight.flightservice.model.Flights;
import com.paathshala.flight.flightservice.service.FlightService;

@RestController
public class FlightResource {

	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flights")
	public Flights getAllFlights(){
		return flightService.getAllFlights();
	}
	
	@PostMapping("/booking")
	public Booking bookFlight(Flight flight){
		return flightService.bookFlight(flight);
	}

	@PostMapping("/add")
	public Flight add(@RequestBody Flight flight){
		return flightService.addFlight(flight);
	}
}
