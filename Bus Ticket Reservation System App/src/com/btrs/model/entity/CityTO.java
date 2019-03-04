package com.btrs.model.entity;

public class CityTO 
{
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Fields  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	private String cityId;
	private String cityName;
	private CountryTO country;
	private StateTO state;
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Constructors  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public CityTO() {}

	public CityTO(String cityId, String cityName, CountryTO country,
			StateTO state) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.country = country;
		this.state = state;
	}



	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Getters & Setters  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public String getCityId() {
		return cityId;
	}



	public void setCityId(String cityId) {
		this.cityId = cityId;
	}



	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public CountryTO getCountry() {
		return country;
	}



	public void setCountry(CountryTO country) {
		this.country = country;
	}



	public StateTO getState() {
		return state;
	}



	public void setState(StateTO state) {
		this.state = state;
	}
	
	
}
