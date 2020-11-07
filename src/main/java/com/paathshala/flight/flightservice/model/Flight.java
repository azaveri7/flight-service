package com.paathshala.flight.flightservice.model;

public class Flight {

	private int flightId;
	private String airlinesName;
	private String destinationName;
	private String boardingName;

	public Flight(int flightId, String airlinesName, String destinationName, String boardingName) {
		super();
		this.flightId = flightId;
		this.airlinesName = airlinesName;
		this.destinationName = destinationName;
		this.boardingName = boardingName;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getAirlinesName() {
		return airlinesName;
	}

	public void setAirlinesName(String airlinesName) {
		this.airlinesName = airlinesName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getBoardingName() {
		return boardingName;
	}

	public void setBoardingName(String boardingName) {
		this.boardingName = boardingName;
	}

}
