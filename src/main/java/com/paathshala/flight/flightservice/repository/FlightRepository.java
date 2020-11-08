package com.paathshala.flight.flightservice.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.paathshala.flight.flightservice.model.Flight;
import com.paathshala.flight.flightservice.model.Message;
import com.paathshala.flight.flightservice.model.MessagePublish;

@Repository
public class FlightRepository {

	private static List<Flight> flights = new ArrayList<>();
	private static int idCounter = 0;

	private RestTemplate restTemplate;
	
	@Value("${message.service.url}")
    private String messageServiceUrl;

	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}

	static {
		flights.add(new Flight(++idCounter, "AIR INDIA", "Mumbai", "Pune"));
		flights.add(new Flight(++idCounter, "VISTARA", "Ahmedabad", "Pune"));
		flights.add(new Flight(++idCounter, "AIR INDIA", "Ooty", "Chennai"));
		flights.add(new Flight(++idCounter, "INDIGO", "Delhi", "Bangaluru"));
		flights.add(new Flight(++idCounter, "AIR INDIA", "Kolkata", "Nagpur"));
		flights.add(new Flight(++idCounter, "VISTARA", "Hyderabad", "Patna"));
		flights.add(new Flight(++idCounter, "AIR INDIA", "Rajkot", "Mysore"));
		flights.add(new Flight(++idCounter, "INDIGO", "Jaipur", "Bhubaneshwar"));
	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptableMediaTypes);
		return headers;
	}

	public List<Flight> getAllFlights() {
		return flights;
	}

	public MessagePublish bookFlight(Message request) {
		HttpEntity<MessagePublish> entity = new HttpEntity<>(getHttpHeaders());
		ResponseEntity<MessagePublish> response = 
				restTemplate.postForEntity(messageServiceUrl, request, MessagePublish.class);
		return response.getBody();
	}

}
