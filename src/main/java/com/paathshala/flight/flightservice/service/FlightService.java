package com.paathshala.flight.flightservice.service;

import com.paathshala.flight.flightservice.model.Booking;
import com.paathshala.flight.flightservice.model.Flight;
import com.paathshala.flight.flightservice.model.Flights;
import com.paathshala.flight.flightservice.model.Message;
import com.paathshala.flight.flightservice.model.MessagePublish;
import com.paathshala.flight.flightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FlightService {

	@Autowired
	private FlightRepository repository;

	@Autowired
	private Environment env;

	private RestTemplate restTemplate;

	@Value("${message.service.url}")
	private String messageServiceUrl;

	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}


	public Flights getAllFlights() {
		Iterable<Flight> flightsSaved = repository
				.findAll();
		List<Flight> flightList = StreamSupport.stream(flightsSaved
				.spliterator(), false)
				.collect(Collectors.toList());
		Flights flights = new Flights();
		flights.setFlights(flightList);
		flights.setHostName(
				env.getProperty("local.server.host") + " is running on " + env.getProperty("local.server.port"));
		return flights;
	}

	public Booking bookFlight(Flight flight) {
		Booking booking = new Booking();
		Message request = new Message();
		request.setFlight(flight);
		request.setEmailId("azaveri7@gmail.com");
		MessagePublish response = bookFlight(request);
		booking.setFlight(flight);
		booking.setMessage("SUCCESS");
		booking.setHostName(
				env.getProperty("local.server.host") + " is running on " + env.getProperty("local.server.port"));
		return booking;
	}

	private MessagePublish bookFlight(Message request) {
		HttpEntity<MessagePublish> entity = new HttpEntity<>(getHttpHeaders());
		ResponseEntity<MessagePublish> response =
				restTemplate.postForEntity(messageServiceUrl, request, MessagePublish.class);
		return response.getBody();
	}

	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptableMediaTypes);
		return headers;
	}

}
