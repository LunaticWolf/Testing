package com.btrs.service.persistance.bo;

/*import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.SheetCollate;

import com.btrs.model.entity.BusScheduleTO;
import com.btrs.service.persistance.dao.BusScheduleDAO;

public class BusScheduleBO 
{

	public boolean getSchedule(BusScheduleTO busScheduleTO) throws ParseException, SQLException
	{
		boolean validSchedule = false;		
		validSchedule = validateEntries(busScheduleTO);
				if(validSchedule)
				{
					BusScheduleDAO busScheduleDAO = new BusScheduleDAO();
					String routeId = getRouteId(busScheduleTO);
					String scheduleId = busScheduleDAO.setSchedule(busScheduleTO);
					
					
				}	
				
				return validSchedule;
	}
	
	
	
	public String getRouteId(BusScheduleTO busScheduleTO) throws SQLException
	{
		BusScheduleDAO busScheduleDAO = new BusScheduleDAO();
		return busScheduleDAO.getRouteId(busScheduleTO);
		
	}
	
	public boolean validateEntries(BusScheduleTO busScheduleTO) throws ParseException
	{
		
		
		String fromCity = busScheduleTO.getRouteFrom();
		String toCity = busScheduleTO.getRouteTo();
		String busId = busScheduleTO.getBusId();
		String time = busScheduleTO.getTime();
		String strJourneyDate = busScheduleTO.getStrJourneyDate();
		String strNoOfTickets = busScheduleTO.getStrNoOfTickets();
		
		String AlphaPattern = "^[a-zA-Z ]*$";
		String NumberPattern = "^[0-9]$";
		String BusIdPattern = "^[B][0,1]{4}$";
		String TimeFormat = "";
		
		int count = 0;
		boolean valid = false;
		if((fromCity.isEmpty()) || (fromCity==null) || (!(fromCity.matches(AlphaPattern))))
		{
			count++;
		}
		if((toCity.isEmpty()) || (toCity==null) || (!(toCity.matches(AlphaPattern))))
		{
			count++;
		}
		
		if((busId.isEmpty()) || (busId==null) || (!(busId.matches(BusIdPattern))) || busId.length()!=4)
		{
			count++;
		}
	
		
		if((time==null) || (time.isEmpty()) || time.matches(TimeFormat))
		{
			count++;
		}
		
		if((strJourneyDate.isEmpty()) || (strJourneyDate==null))
			count++;
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			busScheduleTO.setJourneyDate(sdf.parse(strJourneyDate));
		}
		
		
		if((strNoOfTickets==null) || (strNoOfTickets.isEmpty()) || (!(strNoOfTickets.matches(NumberPattern))) || Integer.parseInt(strNoOfTickets)>4)
		{
			count++;
		}
		
		
		if(!(count>0))
		{
			valid = true;
		}
		
		return valid;
		
	}
	
	
	

	
	
	
}
*/