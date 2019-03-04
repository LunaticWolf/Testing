package com.btrs.model.entity;

public class StateTO 
{
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Fields  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	private String StateId;
	private String StateName;
	private CountryTO Country;

	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Constructors  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public StateTO() {}


	public StateTO(String stateId, String stateName, CountryTO country) 
	{
		super();
		StateId = stateId;
		StateName = stateName;
		Country = country;
	}


	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Getters & Setters  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public String getStateId() {
		return StateId;
	}


	public void setStateId(String stateId) {
		StateId = stateId;
	}


	public String getStateName() {
		return StateName;
	}


	public void setStateName(String stateName) {
		StateName = stateName;
	}


	public CountryTO getCountry() {
		return Country;
	}


	public void setCountry(CountryTO country) {
		Country = country;
	}
	
	
	
}
