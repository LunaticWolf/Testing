package com.btrs.model.entity;

public class ZipCodeTO 
{
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Fields >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	private String zipCodeId;
	private String zipCode;
	private CityTO city;
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Constructors >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public ZipCodeTO() {}
	
	public ZipCodeTO(String zipCodeId, String zipCode, CityTO city) 
	{
		super();
		this.zipCodeId = zipCodeId;
		this.zipCode = zipCode;
		this.city = city;
	}

	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Getters & Setters >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	public String getZipCodeId() {
		return zipCodeId;
	}

	public void setZipCodeId(String zipCodeId) {
		this.zipCodeId = zipCodeId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public CityTO getCity() {
		return city;
	}

	public void setCity(CityTO city) {
		this.city = city;
	}
	
	
	
	
	
	
}
