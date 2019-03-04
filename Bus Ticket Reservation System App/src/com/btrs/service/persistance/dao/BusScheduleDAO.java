/*package com.btrs.service.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.btrs.model.entity.BusScheduleTO;
import com.btrs.service.constants.QueryConstants;
import com.btrs.service.util.DBConnection;
import com.btrs.service.util.DBConnectionI;



public class BusScheduleDAO 
{

	static Connection myConn = null;
	static PreparedStatement pStmt = null;
	static ResultSet myRslt = null;
	
	
	public String getRouteId(BusScheduleTO busScheduleTO) throws SQLException
	{
		
		String routeId = null;
		
		DBConnectionI db = new DBConnection();
		myConn = db.getMySQLConnection();
	
		pStmt = myConn.prepareStatement(QueryConstants.GET_ROUTE_IDS);
		pStmt.setString(1, busScheduleTO.getRouteFrom());
		pStmt.setString(2, busScheduleTO.getRouteTo());
		
		myRslt = pStmt.executeQuery();
		
		while(myRslt.next())
		{
			 routeId = (String)myRslt.getString("route_id");
		}
		
		
		return routeId;
		
		
		
	}
	
	
}
*/