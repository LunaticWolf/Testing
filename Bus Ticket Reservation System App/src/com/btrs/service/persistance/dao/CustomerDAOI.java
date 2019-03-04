package com.btrs.service.persistance.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.btrs.model.entity.CustomerTO;
import com.btrs.service.exception.MVCApplicationException;

public interface CustomerDAOI 
{

	//Getting Customer ID
	public String getId(String id) throws  MVCApplicationException;
	
	//Adding Customer to DB
	public boolean addCustomer(CustomerTO customerTO) throws MVCApplicationException;
	

	//Updating Customer to DB
	public boolean updateCustomer(CustomerTO customerTO) throws   MVCApplicationException;
	
	//Get CustomerInfo
	public CustomerTO getCustomerId(String customerId) throws   MVCApplicationException;
	
	//View All Customer
	public List<CustomerTO> getCustomerRecords(CustomerTO customerTO) throws  MVCApplicationException;
	
	
	//Delete Customer
	public CustomerTO deleteCustomer(String customerId) throws  MVCApplicationException;

	
	
}
