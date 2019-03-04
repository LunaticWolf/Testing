package com.btrs.service.persistance.bo;


import java.util.List;

import com.btrs.model.entity.CustomerTO;
import com.btrs.model.entity.CustomerTypeTO;
import com.btrs.service.exception.MVCApplicationException;

public interface CustomerBOI 
{

	//Prefill Record
	public List<CustomerTypeTO> getCustomerType(CustomerTypeTO customerTypeTO) throws  MVCApplicationException;
	
	
	//Generate ID
	public void generateCustomerId(CustomerTO customerTO) throws MVCApplicationException;


	//ADD Customer Entry
	public boolean addCustomer(CustomerTO customerTO) throws MVCApplicationException;
	
	
	//Get Update ID/Specific Record
	public CustomerTO getRequestedCustomerRecord(String customerId) throws  MVCApplicationException;
	
	//Update - U
	public boolean updateCustomer(CustomerTO customerTO) throws MVCApplicationException;
	
	
	//View All Records - R
	public List<CustomerTO> getCustomerRecords(CustomerTO customerTO) throws MVCApplicationException;
	
	
	//Delete Record
	public CustomerTO deleteCustomer(String customerId) throws MVCApplicationException;
	
	
	
}
