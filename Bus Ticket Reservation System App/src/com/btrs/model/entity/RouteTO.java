package com.btrs.model.entity;

public class RouteTO 
{
	
	private String routeId;
	private String routeFrom;
	private String routeTo;
	private String travelCost;
	
	
	public RouteTO() {}
	
	
	
	
	
	public RouteTO(String routeFrom, String routeTo) {
		super();
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
	}


	public RouteTO(String routeFrom, String routeTo, String routeCost) {
		super();
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.travelCost = routeCost;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getTravelCost() {
		return travelCost;
	}

	public void setTravelCost(String travelCost) {
		this.travelCost = travelCost;
	}

	
	
	
	
	
}
