package com.btrs.service.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btrs.model.entity.BusScheduleTO;
import com.btrs.model.entity.BusTO;
import com.btrs.model.entity.BusTypeTO;
import com.btrs.model.entity.CityTO;
import com.btrs.model.entity.RouteTO;
import com.btrs.service.constants.SuccessConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.bo.BusTypeBO;
import com.btrs.service.persistance.bo.BusTypeBOI;
import com.btrs.service.persistance.bo.BusBO;
import com.btrs.service.persistance.bo.RouteBO;
import com.btrs.service.persistance.bo.RouteBOI;
import com.btrs.service.persistance.dao.GPSDAO;
import com.btrs.service.persistance.dao.GPSDAOI;


public class MasterDataController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	static String page = null;
   
    public MasterDataController() 
    {
        super();    
    }

    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String theCommand = request.getParameter("TheCommand");
		

		switch (theCommand) 
		{
			case "RegisterNewBus": 
								try 
								{
									addBus(request,response);
									getBusInfoList(request);
								} 
								catch (MVCApplicationException | SQLException e1) 
								{
									e1.printStackTrace();
								}
				break;
			
				
				
			case "RegisterNewRoute": 
								try 
								{
								
									addRoute(request,response);
			
									getRouteInfoList(request);
								}
								catch (MVCApplicationException | SQLException e) 
							
								{
									e.printStackTrace();
								}
				break;
				
				
				
			case "RegisterNewSchedule":	
									try 
									{
										addSchedule(request,response);
										getRouteInfoList(request);
										
									}
									catch (MVCApplicationException | SQLException e) 
									{
										
										e.printStackTrace();
									}
				break;
		}
		
	
		getDeployPage(request, response, page);
		
	}

	
	
	
	
	private void addBus(HttpServletRequest request, HttpServletResponse response) 
	{
		page = SuccessConstants.ADD_NEW_BUS;
		
	}




	private void addRoute(HttpServletRequest request, HttpServletResponse response) 
	{
		page = SuccessConstants.ADD_NEW_ROUTE;
		
	}




	private void addSchedule(HttpServletRequest request, HttpServletResponse response) throws  MVCApplicationException, SQLException 
	{
		page = SuccessConstants.ADD_NEW_SCHEDULE;
		
		BusBO busesBO = new BusBO();
		request.setAttribute("BUSLIST", busesBO.getBusses());
		getRouteInfoList(request);
		
		
	}

	
	
	
	
	
	
	//============================================================  POST METHODS  =================================================================
	
	
	
	
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	

		String theCommand = request.getParameter("TheCommand");
		

		switch (theCommand) 
		{
			case "ADDNEWBUS": page = SuccessConstants.HOME_PAGE;
									try {
										addNewBus(request,response);
									} catch (MVCApplicationException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								
				break;
			
			case "ADDROUTE": page = SuccessConstants.HOME_PAGE;
									 try {
										addNewRoute(request,response);
									} catch (MVCApplicationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
				break;
				
			case "ADDSCHEDULE":	addNewSchedule(request,response);
				break;
		}
		
		
		getDeployPage(request, response, page);
		
		
		
	}

	
	
	
	private void addNewBus(HttpServletRequest request, HttpServletResponse response) throws  MVCApplicationException 
	{
	
		boolean validateBusEntry = false;
		
		
		String busName = request.getParameter("BusName");
		String busTypeId = request.getParameter("BusType");
		String  busSeatCapacity = request.getParameter("BusSeatCapacity");
		
		BusTO busTO = new BusTO(busName, busTypeId, busSeatCapacity);
	
		
		BusBO busBO = new BusBO();
		validateBusEntry = busBO.validateBusEntry(busTO);
				
				if(validateBusEntry)
				{
					//request.setAttribute("BUSADDED", SuccessConstants.BUS_ADDED_SUCCESSFULLY);
				}
				else
				{
					//request.setAttribute("BUSERRORMSG", ErrorConstants.ADD_BUS_ERROR);
					//requestDispatcher = request.getRequestDispatcher(ErrorConstants.ADD_BUS_HOMEPAGE);
				}	
		
		
				//requestDispatcher.forward(request, response);
		
		
	}




	private void addNewRoute(HttpServletRequest request, HttpServletResponse response) throws  MVCApplicationException 
	{

		boolean validateRouteEntry = false;
		
		
		String routeFrom = request.getParameter("routeFrom");
		String routeTo = request.getParameter("routeTo");
		String  travelCost = request.getParameter("travelCost");
		
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher(SuccessConstants.ADMIN_HOMEPAGE);
		
		RouteTO routeTO = new RouteTO(routeFrom, routeTo, travelCost);
		
		RouteBOI routeBOI = new RouteBO();
		validateRouteEntry = routeBOI.validateRouteEntry(routeTO);
				
				if(validateRouteEntry)
				{
					
			//		request.setAttribute("ROUTEADDED", SuccessConstants.ROUTE_ADDED_SUCCESSFULLY);
				}
				else
				{
					//request.setAttribute("BUSERRORMSG", ErrorConstants.ADD_ROUTE_ERROR);
				//	requestDispatcher = request.getRequestDispatcher(ErrorConstants.ADD_ROUTE_HOMEPAGE);
				}	
		
		
				//requestDispatcher.forward(request, response);
		
	}




	private void addNewSchedule(HttpServletRequest request, HttpServletResponse response) 
	{
	
		String fromCity = request.getParameter("");
		String toCity = request.getParameter("");
		String busId = request.getParameter("");
		String time = request.getParameter("");
		String strJourneyDate = request.getParameter("");
		String strNoOfTickets = request.getParameter("");
		
		
		BusScheduleTO busScheduleTO = new BusScheduleTO(fromCity, toCity, busId, time, strJourneyDate, strNoOfTickets);
		
		
		
		
		
		
		
		
		
		
	}




	
	
	
	
	
	//=======================================================================================================================
	
	
	
	public void getBusInfoList(HttpServletRequest request) throws SQLException, MVCApplicationException  
	{
		BusTypeTO busTypeTO = new BusTypeTO();
		BusTypeBOI busTypeBOI =  new BusTypeBO();
		
		request.setAttribute("BUSTYPE", busTypeBOI.getBusTypes(busTypeTO));
	}
	
	
	public void getRouteInfoList(HttpServletRequest request) throws SQLException, MVCApplicationException
	{
		CityTO cityTO = new CityTO();
		GPSDAOI gpsDAO = new GPSDAO(); 
	
		request.setAttribute("ROUTES", gpsDAO.getCities(cityTO));
		
	}
	
	
	
	public void getDeployPage(HttpServletRequest request,HttpServletResponse response,String page) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}
	
}
