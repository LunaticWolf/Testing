package com.btrs.model.entity;

import java.util.Date;

public class BusScheduleTO
{
	
	private String scheduleId;
	private String routeFrom;
	private String routeTo;
	private String busId;
	private String Time;
	
	private String strJourneyDate;
	private Date journeyDate;
	
	private String strNoOfTickets;
	private int noOfTickets;
	
	
	public BusScheduleTO() {}

	
	
	
	

	public BusScheduleTO(String routeFrom, String routeTo,
			String busId, String time, String strJourneyDate,
			String strNoOfTickets) {
		super();
		
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.busId = busId;
		Time = time;
		this.strJourneyDate = strJourneyDate;
		this.strNoOfTickets = strNoOfTickets;
	}


	public String getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
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


	public String getBusId() {
		return busId;
	}


	public void setBusId(String busId) {
		this.busId = busId;
	}


	public String getTime() {
		return Time;
	}


	public void setTime(String time) {
		Time = time;
	}


	public String getStrJourneyDate() {
		return strJourneyDate;
	}


	public void setStrJourneyDate(String strJourneyDate) {
		this.strJourneyDate = strJourneyDate;
	}


	public Date getJourneyDate() {
		return journeyDate;
	}


	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}


	public String getStrNoOfTickets() {
		return strNoOfTickets;
	}


	public void setStrNoOfTickets(String strNoOfTickets) {
		this.strNoOfTickets = strNoOfTickets;
	}


	public int getNoOfTickets() {
		return noOfTickets;
	}


	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	
	

}
