package com.btrs.model.entity;

public class BusTO 
{

	
	private String busId;
	private String busName;
	private String busType;
	private String avaliableSeats;
	
	
	
	
	public BusTO() {}
	
	public BusTO(String busName, String busType, String avaliableSeats) {
		super();
		this.busName = busName;
		this.busType = busType;
		this.avaliableSeats = avaliableSeats;
	}

	public BusTO(String busId, String busName) {
		super();
		this.busId = busId;
		this.busName = busName;
	}
	
	
	
	
	
	public String getBusId() {
		return busId;
	}

	

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getAvaliableSeats() {
		return avaliableSeats;
	}

	public void setAvaliableSeats(String avaliableSeats) {
		this.avaliableSeats = avaliableSeats;
	}

	
	
	
	
}


