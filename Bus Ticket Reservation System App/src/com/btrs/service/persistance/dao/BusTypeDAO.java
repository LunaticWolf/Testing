package com.btrs.service.persistance.dao;

import java.nio.charset.MalformedInputException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.btrs.model.entity.BusTypeTO;
import com.btrs.service.constants.QueryConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.util.DBConnection;
import com.btrs.service.util.DBConnectionI;

public class BusTypeDAO implements BusTypeDAOI
{

	static Connection myConn = null;
	static Statement stmt = null;
	static ResultSet myResultSet = null;
	
	
	public List<BusTypeTO> getBusTypes(BusTypeTO busTypeTO) throws MVCApplicationException
	{
		
		DBConnectionI  db = new DBConnection();
		List<BusTypeTO> busTypeList = new ArrayList<BusTypeTO>();
		
		try
		{
			myConn = db.getMySQLConnection();
		
			stmt = myConn.createStatement();
			myResultSet = stmt.executeQuery(QueryConstants.GET_BUS_TYPES);
			
			
			
			while(myResultSet.next())
			{
				String busType = myResultSet.getString("bus_type");
				String seatsAvaliable = myResultSet.getString("max_seats");
				
				busTypeTO = new BusTypeTO(busType, seatsAvaliable);
				busTypeList.add(busTypeTO);
			}
		}
		catch(SQLException e)
		{
			throw new MVCApplicationException(e);
		}
		
		return busTypeList;
		
		
	}
	
}
