package com.paathshala.flight.flightservice.model;

import java.util.List;

public class Flights {

	private List<Flight> flights;
	private String hostName;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
