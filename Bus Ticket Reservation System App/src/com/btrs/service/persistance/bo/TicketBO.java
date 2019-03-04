package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.btrs.model.entity.BusTO;
import com.btrs.model.entity.RouteTO;
import com.btrs.model.entity.TicketTO;
import com.btrs.service.constants.ErrorConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.exception.MVCBusinessException;
import com.btrs.service.persistance.dao.TicketDAO;

public class TicketBO 
{
	

	TicketDAO ticketDAO = new TicketDAO();
	
	
	
	
	static Map<String,String> errorMap = new HashMap<String,String>();
	
	public TicketBO()
	{	
		errorMap.put("ErrCustomerID","");
		errorMap.put("ErrFromCityID", "");
		errorMap.put("ErrToCityID", "");
		errorMap.put("ErrJourneyDate", "");
		errorMap.put("ErrBusID", "");
		errorMap.put("ErrBusSeatsAvaliablity", "");
		errorMap.put("ErrTimeDetails", "");
		errorMap.put("ErrTravelCost", "");
		
	}
	


	
	
	
//Step 1 - Verify Customer Booking ID for Tickets
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ID VERIFICATION  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
	
	
	
	public boolean verifyBookingID(String customerID) throws  MVCApplicationException, MVCBusinessException
	{
		boolean validateEligiblity = false;
		int count = validate(customerID);

		if(!(count>0))
		{
			validateEligiblity = ticketDAO.verifyBookingID(customerID);
			if(validateEligiblity==false)
			{
				errorMap.put("ErrCustomerID",ErrorConstants.CUSTOMER_ID_NOT_FOUND);
			}
			
		}
		else
		{
			exceptionHandler();
		}
		
		return validateEligiblity;
	}
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VALIDATE STEP - 1 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
	
	
	
	public int validate(String customerID)
	{
		int count = 0;
		String numberPattern = "^[0-9]{10}$";
		
		if( (customerID==null) || (customerID.isEmpty()) )
		{
			count++;
			errorMap.put("ErrCustomerID", ErrorConstants.EMPTY_CUSTOMER_ID);
		}
		
		if(!(customerID.matches(numberPattern)))
		{
			count++;
			errorMap.put("ErrCustomerID", ErrorConstants.INVALID_CUSTOMER_ID);
		}
		
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//Step 2
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Booking - Journey Dates >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	public List<TicketTO> getBookingDetails(TicketTO ticketTO) throws MVCApplicationException, MVCBusinessException
	{
		int count = validateCities(ticketTO);
		
		List<TicketTO> scheduleDetails = new ArrayList<TicketTO>();
		List<TicketTO> jDates = new ArrayList<TicketTO>();
		
		if(!(count>0))
		{
			TicketDAO ticketDAO = new TicketDAO();
			try 
			{
				scheduleDetails = ticketDAO.getSchedule(ticketDAO.getBookingDetails(ticketTO));
				for(TicketTO jDate : scheduleDetails)
				{
					jDates.add(ticketDAO.getJourneyDate(jDate));
				}
				
			} 
			catch (SQLException e) 
			{
				throw new MVCApplicationException();
			}
			
		
			
		}
		else
		{
			exceptionHandler();
		}
		
		
		return jDates;
	}
	
	
	
	
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VALIDATE STEP 2 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
	
	
	
	public int validateCities(TicketTO ticketTO)
	{
		int count = 0;
		String alphaPattern = "^[a-zA-Z]{0,5}$";
		
		
		String fromCity = ticketTO.getFromCity();
		String toCity = ticketTO.getToCity();
		
	
		if(!(fromCity.matches(alphaPattern)))
		{
			count++;
			if(fromCity.equals("-") || fromCity.isEmpty())
				errorMap.put("ErrFromCityID", ErrorConstants.EMPTY_FROM_CITY_ID);
			else
			errorMap.put("ErrFromCityID", ErrorConstants.INVALID_FROM_CITY_ID);
		}
		
		
		if(!(toCity.matches(alphaPattern)) || toCity.isEmpty())
		{
			count++;
			if(toCity.equals("-"))
				errorMap.put("ErrToCityID", ErrorConstants.EMPTY_TO_CITY_ID);
			else
			errorMap.put("ErrToCityID", ErrorConstants.INVALID_TO_CITY_ID);
		}
		
		return count;	
	}




	
	
	
	
	
//Step - 3 
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< BUS DETAILS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	public List<String> getTransportationDetails(TicketTO ticketTO) throws MVCApplicationException, MVCBusinessException 
	{
	
		String strJourneyDate = ticketTO.getStrJourneyDate();
		
		
		int count = validateDate(ticketTO);
		List<String> busSchedule = new ArrayList<>();
		if(!(count>0))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date journeyDate;
			try 
			{
				journeyDate = sdf.parse(strJourneyDate);
				ticketTO.setJourneyDate(journeyDate);
				
				TicketDAO ticketDAO = new TicketDAO();
				busSchedule = ticketDAO.getTransportationDetails(ticketTO);
			}
			catch (ParseException e) 
			{
				throw new MVCApplicationException(e);
			}
			
		}
		else
		{
			exceptionHandler();
		}
		
		
		return busSchedule;
		
	}
	


	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VALIDATE STEP 3 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	

	
	
	 public int validateDate(TicketTO ticketTO)
	 {
		 String date = ticketTO.getStrJourneyDate();
		 int count = 0;
		 
		 if(date.equals("-") || date.isEmpty())
		 {
			 count++;
			 errorMap.put("ErrJourneyDate", ErrorConstants.EMPTY_INVALID_JOURNEY_DATE);
		 }
		 
		 return count;
				 
	 }


	 
	 
		
		
		
//Step 4
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< BOOKING TICKETS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	 
	 
	 
	 
	public String getTickets(TicketTO ticketTO) throws MVCApplicationException, MVCBusinessException 
	{
		
			int count = validateEntries(ticketTO);
			
			String bookedTicket = null;
			if(!(count>0))
			{
				
				
				String jDate = ticketTO.getStrJourneyDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date;
				try 
				{
					date = sdf.parse(jDate);
				} 
				catch (ParseException e) 
				{
					throw new MVCApplicationException(e);
				}
				ticketTO.setJourneyDate(date);
				
				
				
				
				ticketTO.setNoOfTickets(Integer.parseInt(ticketTO.getStrNoOfTickets()));
				ticketTO.setCost(Double.parseDouble(ticketTO.getStrCost()));
				
				double cost = ticketTO.getNoOfTickets() * ticketTO.getCost();
				ticketTO.setCost(cost);
				
			
				
				ticketTO.setTicketID(generateTicketID(ticketTO));
				bookedTicket = ticketDAO.bookTickets(ticketTO);
			}
			else
			{
				exceptionHandler();
			}
				
	
			return bookedTicket;
			
			
	}



	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VALIDATE STEP 4 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
	
	
	
	
	
	private int validateEntries(TicketTO ticketTO) 
	{
		
		int count = 0;
		
	
		String numberPattern = "^[0-9]{0,5}$";
		String busIDPattern = "^[B]{1}[0-9]{3}$";
		
		
		String busID = ticketTO.getBus().getBusId();
		String seats = ticketTO.getStrNoOfTickets();
		String time = ticketTO.getTime();
		String cost = ticketTO.getStrCost();
		
		
		
		if(!(busID.matches(busIDPattern)))
		{
			count++;
			if((busID.equals("-")))
				errorMap.put("ErrBusID", ErrorConstants.EMPTY_BUS_ID);
			else
			errorMap.put("ErrBusID", ErrorConstants.INVALID_BUS_ID);
			
		}
		
			
		if(seats.equals("-"))
		{
			count++;
			
			errorMap.put("ErrBusSeatsAvaliablity", ErrorConstants.EMPTY_SEATS_ENTRY);
		}
		
		
		if(Integer.parseInt(seats)>4)
		{
			count++;
			errorMap.put("ErrBusSeatsAvaliablity", ErrorConstants.INVALID_SEATS_ENTRY);
		}
		
		if(time.equals("-"))
		{
			count++;
			
			errorMap.put("ErrTimeDetails", ErrorConstants.EMPTY_BUS_TIME_DETAILS);
		}
		
		
		if((!(cost.matches(numberPattern))) || cost==null)
		{
			count++;
			errorMap.put("ErrTravelCost", ErrorConstants.INVALID_TRAVEL_COST_DETAILS);
			
		}
			
			return count;
	
	}



		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GENERATE TICKET ID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
		
		
	
	
	
	
		private String generateTicketID(TicketTO ticketTO) throws  MVCApplicationException 
		{
		
			StringBuilder sb = new StringBuilder();
			sb.append(ticketTO.getBus().getBusId());
			
			 DateFormat dateFormat1 = new SimpleDateFormat("ddMMYY");
			 Date date = new Date();
			 sb.append(dateFormat1.format(date));
			 
			String ticketID = ticketDAO.generateTicketID(null);
			
			return sb.append(ticketID).toString();
		}



		
		
		
		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VIEW GENERATED TICKET >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
	
		
		
		
		
		
		public TicketTO viewTicketDetails(String ticketID) throws MVCApplicationException 
		{
			return ticketDAO.viewTicket(ticketID);	
		}
	 
	 
	 
	 

		
		
		 
		 
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Prefill Data  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 
		
		
		
		
	
		
		public List<String> getCostDetails(TicketTO ticketTO) throws MVCApplicationException 
		{
			return ticketDAO.getCostDetails(ticketTO);	
		}
	
	
	
		public List<BusTO> getBusDetails(String scheduleId) throws MVCApplicationException 
		{
			
			return ticketDAO.getBusDetails(scheduleId);
		}
	
	
	
		public List<String> getSeatsDetails(String scheduleId) throws MVCApplicationException 
		{
			return ticketDAO.getSeatsDetails(scheduleId);
		}
	
	
	
		public List<String> getScheduleTime(String scheduleId) throws MVCApplicationException
		{
			return ticketDAO.getScheduleTime(scheduleId);
		}

		
		
		
				
				
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Exception Handler >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
		
		public void exceptionHandler() throws MVCBusinessException
		{
			MVCBusinessException mbException = new MVCBusinessException();
			mbException.setErrorMap(errorMap);
			
			throw mbException;
		}
		
		
		
		
		
		
	 }
	




//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------























































/*import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.TicketTO;
import com.btrs.service.persistance.dao.TicketDAO;
import com.btrs.service.persistance.dao.TicketDAOI;

public class TicketBO implements TicketBOI
{	
	
	
	
	@Override
	public List<TicketTO> getTickets(String customerID) throws SQLException 
	{
	
		TicketDAOI ticketDAOI = (TicketDAOI) new TicketDAO();
		
		return ticketDAOI.getCustomerTickets(customerID);
	}





	@Override
	public boolean cancelReservation(String ticketID) throws SQLException 
	{
		
		TicketDAOI ticketDAOI = (TicketDAOI) new TicketDAO();
		
		return ticketDAOI.cancelReservation(ticketID);
		
	}





	@Override
	public boolean getTravelDetails(TicketTO ticketTO) {
		// TODO Auto-generated method stub
		return false;
	}



}
*/