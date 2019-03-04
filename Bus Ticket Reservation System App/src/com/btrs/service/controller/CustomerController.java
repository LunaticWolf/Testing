package com.btrs.service.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btrs.model.entity.CityTO;
import com.btrs.model.entity.CountryTO;
import com.btrs.model.entity.CustomerTO;
import com.btrs.model.entity.CustomerTypeTO;
import com.btrs.model.entity.StateTO;
import com.btrs.model.entity.ZipCodeTO;
import com.btrs.service.constants.ErrorConstants;
import com.btrs.service.constants.SuccessConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.bo.CustomerBO;
import com.btrs.service.persistance.bo.CustomerBOI;
import com.btrs.service.persistance.bo.GPSBO;


public class CustomerController extends HttpServlet 
{
	
	
	private static final long serialVersionUID = 1L;
  
	static String page = null;
	
    public CustomerController() 
    {
        super();   
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String theCommand = request.getParameter("TheCommand");
		
		
		switch (theCommand) 
			{
				case "RegisterNewCustomer" : 	try {
														getInformation(request);
													} catch (MVCApplicationException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}	
												registerNewCustomer(request,response); 
					break;
					
				case "UpdateCustomerID" : updateExistingCustomerRecord(request,response);
					break;
					
				case "ViewCustomerID": 	viewCustomerRecord(request,response);
					break;
				
				case "ViewAllCustomer" :	page = SuccessConstants.VIEW_CUSTOMERS;
											try
											{
												System.out.println("View");
												viewCustomerRecords(request,response);
											}
											 catch (MVCApplicationException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} 
					break;
					
				case "DeleteCustomerRecord" : deleteExistingRecord(request,response);
					break;
	
			}
		
		deployPageRequest(request, response, page);
		
	}

	

	private void deleteExistingRecord(HttpServletRequest request, HttpServletResponse response) 
	{
		page = SuccessConstants.DELETE_CUSTOMER_ID;
		
	}


	private void registerNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		page = SuccessConstants.CUSTOMER_REGISTRATION_PAGE;
	}
	
	


	private void updateExistingCustomerRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		page = SuccessConstants.SEARCH_CUSTOMER_PAGE;
	}


	
	private void viewCustomerRecord(HttpServletRequest request, HttpServletResponse response) 
	{
		page = SuccessConstants.VIEW_CUSTOMER_ID;
	}

	

	
	
	
//===================================================================  VIEW ALL RECORDS =======================================================================	
	
	
	private void viewCustomerRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MVCApplicationException 
	{
		
		CustomerTO customerTO = new CustomerTO();
		CustomerBOI customerBOI = new CustomerBO();
		
		
		System.out.println("Into view BO");
		List<CustomerTO> getCustomers = customerBOI.getCustomerRecords(customerTO);

		System.out.println("Size" + getCustomers.size());
		if(getCustomers.size()==0)
		{
			System.out.println("NULLLLLLLLLLLLL");
			page = ErrorConstants.NO_RECORDS_AVALIABLE;
			//Set Attribute for no records avaliable
		}
		else
			request.setAttribute("CUSTOMERRECORDS", getCustomers);
	}

	

	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< POST METHODS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		String theCommand = request.getParameter("TheCommand").toUpperCase();
		
		
		switch (theCommand) 
		{
			case "REGISTERCUSTOMERRECORD": try {
													registerCustomerRecord(request,response);
												} catch (MVCApplicationException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
				break;
					
				
			case "GETCUSTOMERUPDATEID":	page = SuccessConstants.UPDATE_EXISTING_CUSTOMER;
										try {
											getInformation(request);
											getCustomerInformation(request,response);
										} catch (MVCApplicationException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										
									
				break;
				
			case "UPDATECUSTOMERRECORD": page = SuccessConstants.HOME_PAGE;
											//HttpSession session = request.getSession();
												try {
													updateCustomerRecord(request,response);
												} catch (MVCApplicationException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
				break;
				
				
			case "VIEWCUSTOMERID" : page = SuccessConstants.VIEW_CUSTOMER_RECORD;
									
									try {
										getCustomerInformation(request, response);
									} catch (MVCApplicationException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}	
									
				break;
				
			case "DELETECUSTOMERID":	page = SuccessConstants.HOME_PAGE;
										try {
											deleteCustomerRecord(request, response);
										} catch (MVCApplicationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
				break;					
					
		}
	
		
		
			deployPageRequest(request, response, page);
		
	}


	
	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD a NEW CUSTOMER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		

		private void registerCustomerRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MVCApplicationException 
		{
		
			
			boolean registered = false;
			
			String customerName = request.getParameter("CustomerName");
			String customerAddress = request.getParameter("CustomerAddress");
			String customerCountryId = request.getParameter("CustomerCountry");
			String customerStateId = request.getParameter("CustomerState");
			String customerCityId = request.getParameter("CustomerCity");
			String customerZipCode = request.getParameter("CustomerAddressCode");
			String customerEmail = request.getParameter("CustomerEmail");
			String customerGender = request.getParameter("CustomerGender");
			String strCustomerContactNumber = request.getParameter("CustomerContactNumber");
			String strCustomerDOB = request.getParameter("CustomerDOB");
			System.out.println("DAte - " + strCustomerDOB);
			String customerType = request.getParameter("CustomerType");
			String customerPassword = request.getParameter("CustomerPassword");
			
			CustomerTO customerTO = new CustomerTO(customerName, customerAddress, customerCountryId, customerStateId, customerCityId, customerZipCode, customerEmail, customerGender, strCustomerContactNumber, strCustomerDOB, customerType, customerPassword);
			CustomerBOI customerBO = new CustomerBO();
			
			registered = customerBO.addCustomer(customerTO);
			if(registered)
				{
					page = SuccessConstants.HOME_PAGE;
					//Goes to hompage with a success attribute(Customer ID);		
				}
			else
				{
					page = ErrorConstants.CUSTOMER_REGISTRATION_PAGE;
					//goes back to registration page with respective error.
					//handle exception and  add map error from BO and DAO
				} 
			
		}
		
		
		
		
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GET ID INFORMATION >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		

		private void getCustomerInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MVCApplicationException
		{
			
			
			String customerId = request.getParameter("CustomerId");
			
			
			CustomerBO customerBO = new CustomerBO();
			CustomerTO customerTO = customerBO.getRequestedCustomerRecord(customerId);
			if(customerTO!=null)
			{
				System.out.println("Update Avaliable");
				request.setAttribute("CUSTOMER_DETAILS", customerTO);
			}
			else
			{
				System.out.println("Update Not Avaliable");
				page = ErrorConstants.UPDATE_CUSTOMER_ID;
				//request.setAttribute("UpdateError", ErrorConstants.CUSTOMER_UPDATION_NOT_AVALIABLE);
			}
			
			
		}
		
		
		
		
		
	
	
	
	
	
	
	
	

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< UPDATE CUSTOMER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
		
		
		
	
	private void updateCustomerRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, MVCApplicationException 
	{
	
		boolean customerUpdated = false;

		String customerName = request.getParameter("CustomerName");
		String customerAddress = request.getParameter("CustomerAddress");
		String customerCountryId = request.getParameter("CustomerCountry");
		String customerStateId = request.getParameter("CustomerState");
		String customerCityId = request.getParameter("CustomerCity");
		String customerZipCode = request.getParameter("CustomerAddressCode");
		String customerEmail = request.getParameter("CustomerEmail");
		String customerId = request.getParameter("CustomerId");
		
		
		System.out.println(customerCountryId + customerCountryId.length());
	
		CustomerTO customerTO = new CustomerTO(customerName, customerAddress, customerCountryId, customerStateId, customerCityId, customerZipCode, customerEmail);

		CustomerBO customerBo = new CustomerBO();		
		
		
			customerTO.setCustomerId(customerId);
			customerUpdated = customerBo.updateCustomer(customerTO);
			
			if(customerUpdated)
			{
				//request.setAttribute("UpadationSuccessfull", SuccessConstants.CUSTOMER_SUCCESSFULLY_UPDATED);
			}
			else
			{
				//request.setAttribute("Updation Error", ErrorConstants.UPDATION_ERROR);
				page = ErrorConstants.UPDATE_CUSTOMER_ID;
			}
		
			
		
	}
		
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DELETE CUSTOMER RECORD >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	private void deleteCustomerRecord(HttpServletRequest request,HttpServletResponse response) throws  MVCApplicationException 
	{
	
		String customerId = request.getParameter("CustomerId");

		CustomerTO customerTO = new CustomerTO();
		CustomerBOI customerBOI = new CustomerBO();
		
		customerTO = customerBOI.deleteCustomer(customerId);
		
		if(customerTO!=null)
		{
			request.setAttribute("DELETED", customerTO);
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("Not Avaliable");
			request.setAttribute("UNABLETODELETE", customerTO);
		}
		
		
		

	}

	
	
	
	
	
	
	//================================================================================================================================================================================
		
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GET PREFILLS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	
	
	
	private void getInformation(HttpServletRequest request) throws MVCApplicationException  
	{
		
		
		CountryTO countryTO = new CountryTO();
		StateTO stateTO = new StateTO();
		CityTO cityTO = new CityTO();
		ZipCodeTO zipCodeTO = new ZipCodeTO();	
		CustomerTypeTO customerTypeTO = new CustomerTypeTO();
		
		
		GPSBO gpsBO = new GPSBO();
		CustomerBO customerBO = new CustomerBO();
		
		request.setAttribute("COUNTRIES", gpsBO.getCountries(countryTO));
		request.setAttribute("STATES", gpsBO.getStates(stateTO));
		request.setAttribute("CITIES", gpsBO.getCities(cityTO));
		request.setAttribute("ZIPCODES", gpsBO.getZipCodes(zipCodeTO));
		request.setAttribute("CUSTOMERTYPE", customerBO.getCustomerType(customerTypeTO));
		
	}

	
	
	
	
	public void deployPageRequest(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}
	
	
	
	
	

}
