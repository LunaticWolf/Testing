package com.btrs.service.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.btrs.model.entity.BusTO;
import com.btrs.model.entity.CityTO;
import com.btrs.model.entity.CustomerTO;
import com.btrs.model.entity.TicketTO;
import com.btrs.service.constants.ErrorConstants;
import com.btrs.service.constants.SuccessConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.exception.MVCBusinessException;
import com.btrs.service.persistance.bo.BusBOI;
import com.btrs.service.persistance.bo.BusBO;
import com.btrs.service.persistance.bo.GPSBO;
import com.btrs.service.persistance.bo.TicketBO;



public class TicketController extends HttpServlet 
{
	
	
		private static final long serialVersionUID = 1L;
	          
		String page = null;
		
	    public TicketController() 
	    {
	        super();   
	    }

	
    
    
    
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GET METHODS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String theCommand = request.getParameter("TheCommand");
	
		
		switch (theCommand) 
		{
			case "BOOKTICKET": 
								bookedBy(request,response);
				break;
		}
		

		deployPageRequest(request, response, page);
		
	}

	

	
	
	private void bookedBy(HttpServletRequest request, HttpServletResponse response) 
	{
		page = SuccessConstants.TICKETS_BOOKED_BY;
	}
	
	

	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< POST METHODS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String theCommand = request.getParameter("TheCommand");
		
		
		switch (theCommand) 
		{
		
		
		
			case "VERIFYBOOKER" : 
									try 
									{
										verifyBooker(request,response);
									} 
									catch (MVCApplicationException | MVCBusinessException e) 
									{
										e.printStackTrace();
									}
				break;
				
				
				
				
				
				
			case "CHECKBOOKING" : 
									try 
									{
										getRouteInformation(request);
										getBookingDetails(request,response);
									} 
									catch (MVCApplicationException | MVCBusinessException e) 
									{
										e.printStackTrace();
									}
				break;
				
				
				
				
				
				
				
			case "TRANSPORTATIONDETAILS":	try 
											{
												getTransportDetails(request,response);
											} 
											catch (MVCApplicationException | MVCBusinessException e) 
											{
												e.printStackTrace();
											}
				break;
				
				
				
				
				
				
				
			case "BOOKTICKETS" : 			try 
											{
												bookTickets(request,response);
											} 
											catch (MVCApplicationException | MVCBusinessException e) 
											{
												e.printStackTrace();
											}
			break;
				
		}
		
		
		
		
		
		deployPageRequest(request, response, page);
		
		
		
	}

	
	
	
	
	
	
	
	
	//Step 1 - Verify Customer Booking ID-------------------------------------------------------------------------------------------------------------------------------
	
	
	private void verifyBooker(HttpServletRequest request, HttpServletResponse response) throws  MVCApplicationException, MVCBusinessException 
	{
	
		String customerID = request.getParameter("CustomerID");
		
		try
		{
			TicketBO ticketBO = new TicketBO();
			boolean verifyEligiblity = ticketBO.verifyBookingID(customerID);
		
			if(verifyEligiblity)
			{
				request.setAttribute("BOOKINGID", customerID);
				getRouteInformation(request);
				page = SuccessConstants.BOOKING_DETAILS;
			}
			else
			{
				throw new MVCApplicationException();
			}
		}
		catch (MVCApplicationException e) 
		{
			page = ErrorConstants.TICKETS_BOOKED_BY;
		}
		catch (MVCBusinessException e) 
		{
			request.setAttribute("ERRORMAP", e.getErrorMap());
			page = ErrorConstants.TICKETS_BOOKED_BY;
		}
	}
	
	
	
	
	
	
	//Step 2 - Get Journey Dates-------------------------------------------------------------------------------------------------------------------------------

	private void getBookingDetails(HttpServletRequest request, HttpServletResponse response) throws MVCApplicationException, MVCBusinessException 
	{
		
		
		
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String customerID = request.getParameter("CustomerID");
		
		TicketTO ticketTO = new TicketTO(fromCity, toCity);
		request.setAttribute("CUSTOMER_DETAILS", customerID);
		request.setAttribute("SELECTEDCITIES", ticketTO);
		
		TicketBO ticketBO = new TicketBO();
		
		try
		{
			List<TicketTO> travelDetails = ticketBO.getBookingDetails(ticketTO);
			if(travelDetails!=null)
			{
				page = SuccessConstants.AVALIABLE_JOURNEY_DATES;
				request.setAttribute("AVALIABLEJOURNEYDATES", travelDetails);
			
			}
			
		}
		catch(MVCApplicationException e)
		{
			page = ErrorConstants.TRAVEL_DETAILS;
		}
		catch(MVCBusinessException e)
		{
			request.setAttribute("ERRORMAP", e.getErrorMap());
			page = ErrorConstants.TRAVEL_DETAILS;
		}
		
		
		
		
	}
	
	
	
	
	//Step 3 - GET Transportation Details-------------------------------------------------------------------------------------------------------------------------------
	
	private void getTransportDetails(HttpServletRequest request, HttpServletResponse response) throws MVCApplicationException, MVCBusinessException   
	{
	
		String customerID = request.getParameter("CustomerID");
		String fromCity = request.getParameter("FromCity");
		String toCity = request.getParameter("ToCity");
		String strJourneyDate = request.getParameter("JourneyDate");
		
		TicketTO ticketTO = new TicketTO(fromCity, toCity);
		request.setAttribute("CUSTOMER_DETAILS" , customerID);
		request.setAttribute("ROUTEDETAILS", ticketTO);
		
		
		TicketBO ticketBO = new TicketBO();
		
		try
		{
			List<String> costInfo = ticketBO.getCostDetails(ticketTO);
			request.setAttribute("COSTDETAILS", costInfo);
			
			ticketTO.setStrJourneyDate(strJourneyDate);
			request.setAttribute("JOURNEYDATE", strJourneyDate);
		
	
		
			List<String> scheduleDetails = ticketBO.getTransportationDetails(ticketTO);
		
			if(scheduleDetails!=null)
			{
				page=SuccessConstants.BOOK_TICKETS;
			
				for(String scheduleId : scheduleDetails)
				{
						
					request.setAttribute("BUSNAME", ticketBO.getBusDetails(scheduleId));
					request.setAttribute("SEATSAVALIABLITY", ticketBO.getSeatsDetails(scheduleId));
					request.setAttribute("TIMINGDETAILS", ticketBO.getScheduleTime(scheduleId));
				
				}
			
			}
			else
			{
				throw new MVCApplicationException();
			}
			
		}
		catch(MVCApplicationException e)
		{
			page = ErrorConstants.CHECK_TICKETS;
		}
		catch(MVCBusinessException e)
		{
			request.setAttribute("ERRORMAP", e.getErrorMap());
			page = ErrorConstants.CHECK_TICKETS;
		}
	}
	
	
	
	
	
	
	
	//BOOK TICKETS-------------------------------------------------------------------------------------------------------------------------------
	
	private void bookTickets(HttpServletRequest request,
			HttpServletResponse response) throws  MVCApplicationException, MVCBusinessException 
	{
	
		
		String customerID = request.getParameter("CustomerID");
		String fromCity = request.getParameter("FromCity");
		String toCity = request.getParameter("ToCity");
		String strJourneyDate = request.getParameter("JourneyDate");
		
		String busID = request.getParameter("BusName");
		String strNoOfTickets = request.getParameter("SeatsAvaliable");
		String time = request.getParameter("TimeDetails");
		String strCost = request.getParameter("CostDetails");
		
		
		
		CustomerTO customerTO = new CustomerTO();
		customerTO.setCustomerId(customerID);
		BusTO bus = new BusTO();
		bus.setBusId(busID);
		TicketTO ticketTO = new TicketTO(fromCity, toCity, strJourneyDate, bus, strNoOfTickets, time, strCost);
		ticketTO.setCustomer(customerTO);
		
		TicketBO ticketBO = new TicketBO();
		
		try
		{
		
			String ticketID = ticketBO.getTickets(ticketTO);
			if(ticketID!=null)
			{
				
				request.setAttribute("VIEWTICKET",ticketBO.viewTicketDetails(ticketID));
				getRouteInformation(request);
				
				BusBOI busBOI = new BusBO();
				request.setAttribute("BUSDETAILS", busBOI.getBusses());
				page = SuccessConstants.VIEW_GENERATED_TICKET;
			}
			else
			{
				throw new MVCApplicationException();
				
			}
		
		}
		catch(MVCApplicationException e)
		{
			request.setAttribute("TICKETERR", ErrorConstants.TICKET_ERR);
			page=ErrorConstants.BOOK_TICKETS;
		}
		catch (MVCBusinessException e) 
		{
			request.setAttribute("ERRORMAP", e.getErrorMap());
			page=ErrorConstants.BOOK_TICKETS;
		}
	}











	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PRE_FILLED DATA >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	private void getRouteInformation(HttpServletRequest request) throws MVCApplicationException  
	{
	
		CityTO cityTO = new CityTO();
		GPSBO gpsBO = new GPSBO();
		
		request.setAttribute("CITIES", gpsBO.getCities(cityTO));
		
	}
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DISPATCHER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	




	public void deployPageRequest(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static final long serialVersionUID = 1L;

    
	String page = null;
	
    public TicketController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String theCommand = request.getParameter("TheCommand");
		
		switch (theCommand) 
		{
	
				
				
			case "CANCELRESERVATION": checkCustomerReservation(request,response);
				break;
				
			case "CANCELTICKETS":	
				break;
		}
		
		
		deployPageRequest(request, response, page);
		
	}

	


	private void checkCustomerReservation(HttpServletRequest request,HttpServletResponse response) 
	{
	
		page = SuccessConstants.CANCEL_RESERVATION_PAGE;
		
	}
	
	
	//======================================================= POST METHODS ========================================================================
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String theCommand = request.getParameter("TheCommand");	
		
		switch(theCommand)
		{
			case "CANCELTICKETS":	try 
									{
										page = SuccessConstants.CANCEL_TICKETS_PAGE;
										checkCustomerTicket(request,response);
									} 
									catch (SQLException e) 
									{
										e.printStackTrace();
									}
				break;

		
			case "CANCELRESERVEDTICKET":	page = SuccessConstants.HOME_PAGE; 
										try 
											{
												cancelReservation(request,response);
											} 
										catch (SQLException e) 
										{
											e.printStackTrace();
										}
				break;
				
					
		}
		deployPageRequest(request, response, page);

	}
	
	


	private void cancelReservation(HttpServletRequest request,HttpServletResponse response) throws SQLException 
	{
		
		String customerID = request.getParameter("CustomerId");
		String ticketID = request.getParameter("TicketID");
		
		TicketBOI ticketBOI = new TicketBO();
		boolean ticketCancelled = ticketBOI.cancelReservation(ticketID);
		
		if(ticketCancelled)
		{
			
		}
	}


	private void checkCustomerTicket(HttpServletRequest request,HttpServletResponse response) throws SQLException 
	{
		
		String customerID = request.getParameter("CustomerId");
		
		CustomerBOI customerBOI = new CustomerBO();
		CustomerTO customerTO = customerBOI.getRequestedCustomerRecord(customerID);
		
		if(customerTO!=null)
		{
			TicketBOI ticketBOI = new TicketBO();
			List<TicketTO>  customerTickets = ticketBOI.getTickets(customerID); 
			
			request.setAttribute("RESERVEDTICKETS", customerTickets);
			request.setAttribute("CUSTOMER", customerID);
		}
		else
		{
			page = ErrorConstants.HOME_PAGE;
			request.setAttribute("NOCUSTOMERAVALIABLE", "ERROR MESSAGE");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PREFILL - INFORMATION >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void getRouteInfoList(HttpServletRequest request) throws SQLException
	{
		CityTO cityTO = new CityTO();
		GPSDAOI gpsDAO = new GPSDAO(); 
	
		request.setAttribute("ROUTES", gpsDAO.getCities(cityTO));
		
	}
	
	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Request Dispatcher  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	void deployPageRequest(HttpServletRequest request,HttpServletResponse response, String page) throws ServletException, IOException   
	{
		
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);	
		
	}
	
	
}
*/