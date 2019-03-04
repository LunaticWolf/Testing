package com.btrs.model.entity;

import java.util.Date;

public class TicketTO
{

	
	private String ticketID;
	private CustomerTO customer;
	
	
	private String fromCity;
	private String toCity;
	private RouteTO routeTO;
	
	private String strJourneyDate;
	private Date JourneyDate;
	
	private BusTO bus;
	
	private String strNoOfTickets;
	private int noOfTickets;
	
	private String time;
	
	private String strCost;
	private double cost;
	
	private BusScheduleTO busScheduleTO;
	
	public TicketTO() {}
	
	
	public TicketTO(String fromCity, String toCity) 
	{
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
	}



	
	public TicketTO(String fromCity, String toCity, String strJourneyDate, BusTO bus, String strNoOfTickets, String time, String strCost) 
	{
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.strJourneyDate = strJourneyDate;
		this.bus = bus;
		this.strNoOfTickets = strNoOfTickets;
		this.time = time;
		this.strCost = strCost;
	}

	



	
	

	public TicketTO(CustomerTO customer, String fromCity, String toCity,
			String strJourneyDate, BusTO bus, String strNoOfTickets,
			String time, String strCost) {
		super();
		this.customer = customer;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.strJourneyDate = strJourneyDate;
		this.bus = bus;
		this.strNoOfTickets = strNoOfTickets;
		this.time = time;
		this.strCost = strCost;
	}


	public String getTicketID() {
		return ticketID;
	}


	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}


	public CustomerTO getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}


	public String getFromCity() {
		return fromCity;
	}


	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}


	public String getToCity() {
		return toCity;
	}


	public void setToCity(String toCity) {
		this.toCity = toCity;
	}


	public RouteTO getRouteTO() {
		return routeTO;
	}


	public void setRouteTO(RouteTO routeTO) {
		this.routeTO = routeTO;
	}


	public String getStrJourneyDate() {
		return strJourneyDate;
	}


	public void setStrJourneyDate(String strJourneyDate) {
		this.strJourneyDate = strJourneyDate;
	}


	public Date getJourneyDate() {
		return JourneyDate;
	}


	public void setJourneyDate(Date journeyDate) {
		JourneyDate = journeyDate;
	}


	public BusTO getBus() {
		return bus;
	}


	public void setBus(BusTO bus) {
		this.bus = bus;
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


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getStrCost() {
		return strCost;
	}


	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public BusScheduleTO getBusScheduleTO() {
		return busScheduleTO;
	}


	public void setBusScheduleTO(BusScheduleTO busScheduleTO) {
		this.busScheduleTO = busScheduleTO;
	}

	
	
	
	
}
