package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.BusTO;
import com.btrs.model.entity.BusTypeTO;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.dao.BusDAO;
import com.btrs.service.persistance.dao.BusDAOI;


//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD BUS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


public class BusBO implements BusBOI
{

	public boolean validateBusEntry(BusTO busTO) throws  MVCApplicationException 
	{
	
		boolean registerNewBus=false;
		
		String busName = busTO.getBusName();
		String busType = busTO.getBusType();
		String busSeatAvaliablity = busTO.getAvaliableSeats();
		int seatsAvaliable = 0;
		
		
		int count=0;
		
		String AlphaPattern = "^[a-zA-Z ]*$";
		String AplhaSpacesSlash = "^[a-zA-Z/ ]*$";
		String NumberPattern = "^[0-9]{1,2}$";
		
		
	
		
		
		
		if( (busName==null) || (busName.isEmpty()) || (!(busName.matches(AlphaPattern))) )
			{
				System.out.println("Bus Name" + busName);
				count++;
			}
		
		if( (busType==null) || (busType.isEmpty()) || (!(busType.matches(AplhaSpacesSlash))) )
			{
				System.out.println("No bus type" + busType);
				count++;
			}
		else
		{
			BusTypeBO busTypeBO =  new BusTypeBO();
			
			BusTypeTO busTypeTO = new BusTypeTO();
			List<BusTypeTO> busTypeList = busTypeBO.getBusTypes(busTypeTO);
			
			for(BusTypeTO bus : busTypeList)
			{
				if(busType.equals(bus.getBusType()))
				{
					 seatsAvaliable = Integer.parseInt(bus.getStrSeatsAvaliable());
					 System.out.println("Max Seats - " + seatsAvaliable);
				}
				
			}
		}
		
		if( (busSeatAvaliablity==null) || (busSeatAvaliablity.isEmpty()) ||(!(busSeatAvaliablity.matches(NumberPattern))) || (!(Integer.parseInt(busSeatAvaliablity)<50)) || (Integer.parseInt(busSeatAvaliablity)>seatsAvaliable))
			{
				count++;
				System.out.println("No seats  "+count);
			}
		
		
		System.out.println("Total = " + count);
		if(!(count>0))
		{
			BusDAO busDAO = new BusDAO();
			String busId = busDAO.generateBusId(null);
			if(busId!=null)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("B").append(busId);
				
				busTO.setBusId(sb.toString());
				registerNewBus = busDAO.addNewBus(busTO);
			}
				
		}
		
		return registerNewBus;
	}

	
	
	
	
	
	public List<BusTO> getBusses() throws  MVCApplicationException
	{
		
		BusDAOI busDAOI = new BusDAO();
		return busDAOI.getBusses();
		
	}
	
}
