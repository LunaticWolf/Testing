package com.btrs.model.entity;

public class BusTypeTO 
{

	
	
	private String busType;
	private int maxSeatsAvaliable;
	private String strSeatsAvaliable;

	
	
	
	public BusTypeTO() {}
	
	
	
	public BusTypeTO(String busType, String strSeatsAvaliable) 
	{
		super();
		this.busType = busType;
		this.strSeatsAvaliable = strSeatsAvaliable;
	}

	
	
	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getMaxSeatsAvaliable() {
		return maxSeatsAvaliable;
	}

	public void setMaxSeatsAvaliable(int maxSeatsAvaliable) {
		this.maxSeatsAvaliable = maxSeatsAvaliable;
	}

	public String getStrSeatsAvaliable() {
		return strSeatsAvaliable;
	}

	public void setStrSeatsAvaliable(String strSeatsAvaliable) {
		this.strSeatsAvaliable = strSeatsAvaliable;
	}
	
	
	
	
	
}
