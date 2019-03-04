package com.btrs.service.persistance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.btrs.model.entity.CustomerTypeTO;
import com.btrs.service.constants.QueryConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.util.DBConnection;
import com.btrs.service.util.DBConnectionI;

public class CustomerTypeDAO implements CustomerTypeDAOI
{	
	
	static Connection myConn = null;
	static Statement stmt = null;
	static ResultSet myRslt = null;
	
	
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Prefill >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	public List<CustomerTypeTO> getCustomerType(CustomerTypeTO customerTypeTO) throws  MVCApplicationException
	{
		
		DBConnectionI db = new DBConnection();
		
		List<CustomerTypeTO> customerTypeList = new ArrayList<CustomerTypeTO>();
		try
		{
			myConn = db.getMySQLConnection();
			
			stmt = myConn.createStatement();
			myRslt = stmt.executeQuery(QueryConstants.GET_CUSTOMER_TYPE);
			
			
			while(myRslt.next())
			{
				customerTypeTO = new CustomerTypeTO();
				customerTypeTO.setCustomerTypeId((String)myRslt.getString("customer_type_id"));
				customerTypeTO.setCustomerType((String)myRslt.getString("customer_type"));
				
				customerTypeList.add(customerTypeTO);
			}
		}
		catch(SQLException e)
		{
			throw new MVCApplicationException();
		}
		
		return customerTypeList;
		
	}
	
}
