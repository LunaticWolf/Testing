	
	package com.btrs.service.persistance.dao;

	import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.btrs.model.entity.CustomerTO;
import com.btrs.service.constants.QueryConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.util.DBConnection;
import com.btrs.service.util.DBConnectionI;


	public class CustomerDAO implements CustomerDAOI
	{
		
		static Connection myConn=null;
		static Statement stmt=null;
		static PreparedStatement pStmt = null;
		static ResultSet myRslt = null; 
		
		static CustomerTO customerTO = null;
		
		
		
		
		
		
		
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Generate Customer-ID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		
		
		
		public String getId(String id) throws MVCApplicationException
		{
			
			DBConnectionI db = new DBConnection();
			
			try
			{
				myConn = db.getMySQLConnection();
				stmt = myConn.createStatement();
				myRslt = stmt.executeQuery(QueryConstants.GET_CUSTOMER_ID);
				
				if(myRslt.next())
				{
					id = myRslt.getString("max(customer_id)");
				}
			}
			catch (SQLException e) 
			{
				throw new MVCApplicationException(e);
			}
			
			
			return id;
		}
		
		
		
		
		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD CUSTOMER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
		
		
		
		
		
		
		//Register- Customer
		public boolean addCustomer(CustomerTO customerTO) throws  MVCApplicationException
		{
			
			boolean customerRegistered = false;
			
			DBConnection db = new DBConnection();
			
			try
			{
				myConn = db.getMySQLConnection();
				
				pStmt = myConn.prepareStatement(QueryConstants.REGISTER_NEW_CUSTOMER);
				
				pStmt.setString(1, customerTO.getCustomerId());
				pStmt.setString(2, customerTO.getCustomerName());
				pStmt.setString(3, customerTO.getCustomerAddress());
				pStmt.setString(4, customerTO.getCustomerCountryId());
				pStmt.setString(5, customerTO.getCustomerStateId());
				pStmt.setString(6, customerTO.getCustomerCityId());
				pStmt.setString(7, customerTO.getCustomerZipCode());
				pStmt.setString(8,customerTO.getCustomerEmail());
				pStmt.setString(9, customerTO.getCustomerGender());
				pStmt.setLong(10, customerTO.getCustomerContactNumber());	
				pStmt.setDate(11, new Date(customerTO.getCustomerDOB().getTime()));
				pStmt.setString(12, customerTO.getCustomerType());
				pStmt.setString(13, customerTO.getCustomerPassword());
				
				
				int n = pStmt.executeUpdate();
				
				if(n==1)
					customerRegistered = true;
				
			}
			catch (SQLException e) 
			{
				throw new MVCApplicationException(e);
			}
			
			
			return customerRegistered;
			
		}
		
		
		
		
		
		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  GET CUSTOMER INFO  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		
		
		public CustomerTO getCustomerId(String customerId) throws  MVCApplicationException
		{
			
			DBConnection db = new DBConnection();
			
			try
			{
				myConn = db.getMySQLConnection();
				
				pStmt = myConn.prepareStatement(QueryConstants.UPDATE_CUSTOMER_ID);
				pStmt.setString(1, customerId);
				
				myRslt = pStmt.executeQuery();
				while(myRslt.next())
				{
					
					String customerName = myRslt.getString("customer_name");
					String customerAddress = myRslt.getString("customer_address");
					String customerCityId = myRslt.getString("customer_city_id");
					String customerStateId = myRslt.getString("customer_state_id");
					String customerCountryId = myRslt.getString("customer_country_id");
					String customerZipCode = myRslt.getString("customer_loc_zip_code");
					String customerEmail = myRslt.getString("customer_email");
					String customerGender = myRslt.getString("customer_gender");
					long customerContactNumber = myRslt.getLong("customer_contact_no");
					String strCustomerContactNumber = Long.toString(customerContactNumber);
					String strCustomerDOB = myRslt.getString("customer_dob");
					String customerType = myRslt.getString("customer_type");
					
					customerTO = new CustomerTO(customerName, customerAddress, customerCountryId, customerStateId, customerCityId, customerZipCode, customerEmail, customerGender, strCustomerContactNumber, strCustomerDOB, customerType);
					
					if(customerTO!=null)
					{
						customerTO.setCustomerId(customerId);
					}
				}
				
			}
			catch (SQLException e) 
			{
				throw new MVCApplicationException(e);
			}
			
				
			return customerTO;
		}
		
		
		
		
		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  UPDATE CUSTOMER INFO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		
		
		public boolean updateCustomer(CustomerTO customerTO) throws   MVCApplicationException
		{
			
			boolean customerUpdated = false;
			
			DBConnection db = new DBConnection();
			
			
			try
			{
				myConn = db.getMySQLConnection();
				
				pStmt = myConn.prepareStatement(QueryConstants.UPDATE_CUSTOMER);
				
				pStmt.setString(1, customerTO.getCustomerName());
				pStmt.setString(2, customerTO.getCustomerAddress());
				pStmt.setString(3, customerTO.getCustomerCountryId());
				pStmt.setString(4, customerTO.getCustomerStateId());
				pStmt.setString(5, customerTO.getCustomerCityId());
				pStmt.setString(6, customerTO.getCustomerZipCode());
				pStmt.setString(7, customerTO.getCustomerEmail());
				
				pStmt.setString(8, customerTO.getCustomerId());
				
				int n = pStmt.executeUpdate();
				
				
				if(n==1)
					customerUpdated=true;
			}
			catch (SQLException e) 
			{
				throw new MVCApplicationException(e);
			}
			
				
			return customerUpdated;
		}
		
		
	
		
		

		
		

		
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  VIEW CUSTOMERS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		public List<CustomerTO> getCustomerRecords(CustomerTO customerTO) throws  MVCApplicationException 
		{
			
			
			DBConnection db = new DBConnection();
			List<CustomerTO> customerRecords = new ArrayList<CustomerTO>();
			try
			{
				myConn = db.getMySQLConnection();
				
				stmt = myConn.createStatement();
				
				myRslt = stmt.executeQuery(QueryConstants.VIEW_CUSTOMER_RECORDS);
				
				while(myRslt.next())
				{
					
					String customerId = myRslt.getString("customer_id");
					String customerName = myRslt.getString("customer_name");
					String customerAddress = myRslt.getString("customer_address");
					String customerCityId = myRslt.getString("customer_city_id");
					String customerStateId = myRslt.getString("customer_state_id");
					String customerCountryId = myRslt.getString("customer_country_id");
					String customerZipCode = myRslt.getString("customer_loc_zip_code");
					String customerEmail = myRslt.getString("customer_email");
					long customerContactNumber = myRslt.getLong("customer_contact_no");
					String strCustomerContactNumber = Long.toString(customerContactNumber);
					String customerGender = myRslt.getString("customer_gender");
					String strCustomerDOB = myRslt.getString("customer_dob");
					String customerType = myRslt.getString("customer_type");
					
					
					customerTO = new CustomerTO(customerName, customerAddress, customerCountryId, customerStateId, customerCityId, customerZipCode, customerEmail, customerGender, strCustomerContactNumber, strCustomerDOB, customerType);
					
					if(customerTO!=null)
					{
						customerTO.setCustomerId(customerId);
						customerRecords.add(customerTO);
					}
				}
			}
			catch (SQLException e) 
			{
				throw new MVCApplicationException(e);
			}
			
				
			return customerRecords;
			
			
		}
		
		
		
		
		
		
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  DELETE CUSTOMER  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>		
		
		
	
		
		
		public CustomerTO deleteCustomer(String customerId) throws  MVCApplicationException
		{
			
			DBConnection db = new DBConnection();
			
			
			try
			{
				myConn = db.getMySQLConnection();
				
				pStmt = myConn.prepareStatement(QueryConstants.DELETE_EXISTING_CUSTOMER,Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, customerId);
				
				int n = pStmt.executeUpdate();
				
				if(n==1)
				{
					myRslt = pStmt.getGeneratedKeys();
					
					customerTO.setCustomerId((String)myRslt.getString(1));
				}
				
				
				return customerTO;
				
			}
			catch (SQLException e) 
			{
				throw new MVCApplicationException(e);
			}
			
			
			
		}
		
	}

	
	
	
