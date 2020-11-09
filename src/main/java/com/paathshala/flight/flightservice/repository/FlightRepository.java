package com.paathshala.flight.flightservice.repository;

import com.paathshala.flight.flightservice.model.Flight;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface FlightRepository extends CrudRepository<Flight, String> {
    Optional<Flight> findById(String id);
}
