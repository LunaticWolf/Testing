package com.btrs.service.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.btrs.model.entity.BusTO;
import com.btrs.service.constants.QueryConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.util.DBConnection;
import com.btrs.service.util.DBConnectionI;


public class BusDAO  implements BusDAOI
{

	
	
	static Connection myConn=null;
	static PreparedStatement pStmt = null;	
	static ResultSet myRslt = null;
	static Statement stmt = null;
	
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  GENERATE BUS ID  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	//Generate BusId
	public String generateBusId(String id) throws MVCApplicationException
	{
		
		DBConnectionI db =  new DBConnection();
		
		try
		{
			myConn = db.getMySQLConnection();
		
			stmt = myConn.createStatement();
			myRslt = stmt.executeQuery(QueryConstants.GET_BUS_ID);
			
			if(myRslt.next())
			{
				id = myRslt.getString("bus_id");
			}
			
			return id;
		}
		catch(SQLException e)
		{
			throw new MVCApplicationException(e);
		}
		
	}
	
	
	
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD NEW BUS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
	
	
	

	public boolean addNewBus(BusTO busTO) throws  MVCApplicationException
	{
		
		
		DBConnectionI db = new DBConnection();
		boolean registered = false;
		
		try
		{
			
			myConn = db.getMySQLConnection();
			
			pStmt = myConn.prepareStatement(QueryConstants.ADD_NEW_BUS);
			
			pStmt.setString(1, busTO.getBusId());
			pStmt.setString(2, busTO.getBusName());
			pStmt.setString(3, busTO.getBusType());
			pStmt.setString(4, busTO.getAvaliableSeats());
			
			
			int n = pStmt.executeUpdate();
			
			if(n==1)
				registered = true;
			
		}
		catch(SQLException e)
		{
			throw new MVCApplicationException(e);
		}
		
			
			
		return registered;
	}

	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GET BUSSES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	
	
	
	
	@Override
	public List<BusTO> getBusses() throws MVCApplicationException 
	{
		
		DBConnectionI db = new DBConnection();
		List<BusTO> busList = new ArrayList<BusTO>();
		
		try
		{
			myConn = db.getMySQLConnection();
			
			stmt = myConn.createStatement();
			myRslt = stmt.executeQuery(QueryConstants.GET_BUSSES);
			
			
			while(myRslt.next())
			{
				BusTO busTO = new BusTO();
				String busId = myRslt.getString("bus_id");
				String busName = myRslt.getString("bus_name");
				
				busTO.setBusId(busId);
				busTO.setBusName(busName);
			
				busList.add(busTO);
			}
			
		}
		catch(SQLException e)
		{
			throw new MVCApplicationException(e);
		}
		
		
		
		return busList;
		
		
	}
	
}