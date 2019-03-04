package com.btrs.service.persistance.bo;

import java.sql.SQLException;

import com.btrs.model.entity.RouteTO;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.dao.RouteDAO;


public class RouteBO implements RouteBOI
{
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD ROUTE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
		public boolean validateRouteEntry(RouteTO routeTO) throws  MVCApplicationException 
		{	
			
			boolean registerNewRoute = false;
			
			String routeFrom = routeTO.getRouteFrom();
			String routeTo = routeTO.getRouteTo();
			String travelCost = routeTO.getTravelCost();
			
			int count=0;
			
			String AlphaPattern = "^[a-zA-Z]*$";
			String NumberPattern = "^[0-9]{1,5}$";
			
			if( (routeFrom==null) || (routeFrom.isEmpty()) || (!(routeFrom.matches(AlphaPattern))) )
				count++;
			if( (routeTo==null) || (routeTo.isEmpty()) || (!(routeTo.matches(AlphaPattern))) )
				count++;
			if( (travelCost==null) || (travelCost.isEmpty()) || (!(travelCost.matches(NumberPattern))) )
				count++;
			
			System.out.println(count);
			if(!(count>0))
			{
				RouteDAO routeDAO = new RouteDAO();
				String routeId = routeDAO.generateRouteId(null);
				if(routeId!=null)
				{
					StringBuffer sb = new StringBuffer();
					sb.append("R").append(routeId);
					
					routeTO.setRouteId((sb.toString()));
					registerNewRoute = routeDAO.addNewRoute(routeTO);
				}
					
			}
						
			return registerNewRoute;
		}

}
