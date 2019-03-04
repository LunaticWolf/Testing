package com.btrs.service.persistance.bo;

import java.sql.SQLException;

import com.btrs.model.entity.RouteTO;
import com.btrs.service.exception.MVCApplicationException;

public interface RouteBOI 
{

	public boolean validateRouteEntry(RouteTO routeTO) throws  MVCApplicationException;
	
	
}
