package com.btrs.service.persistance.bo;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.btrs.model.entity.CustomerTO;
import com.btrs.model.entity.CustomerTypeTO;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.dao.CustomerDAO;
import com.btrs.service.persistance.dao.CustomerDAOI;
import com.btrs.service.persistance.dao.CustomerTypeDAO;


public class CustomerBO implements CustomerBOI 
{
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Pre-fill Form >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	
	//Customer Types for Customer-Registration Page
	public List<CustomerTypeTO> getCustomerType(CustomerTypeTO customerTypeTO) throws  MVCApplicationException
	{
		CustomerTypeDAO customerTypeDAO = new CustomerTypeDAO();
		return customerTypeDAO.getCustomerType(customerTypeTO);
	}
	
	
	
	
	
	
	
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADD CUSTOMER(REGISTRATION) >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	public boolean addCustomer(CustomerTO customerTO) throws  MVCApplicationException
	{
		int count = validateCustomerEntries(customerTO);
		
		boolean validateCustomer = false;
		
		if(!(count>0))
		{
			CustomerDAOI customerDAOI = new CustomerDAO();
			generateCustomerId(customerTO);
			validateCustomer = customerDAOI.addCustomer(customerTO);
		}
		
		return validateCustomer;
		
	}
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GENERATE CUSTOMER_ID >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	
	public void generateCustomerId(CustomerTO customerTO) throws  MVCApplicationException
	{  
		//System.out.println("Generate Id");
		CustomerDAOI customerDAOI = new CustomerDAO();
		  String id = customerDAOI.getId(null);
		  String customerId = null;
		  if(id == null)
		  {
			 // System.out.println("ID Null");
			  DateFormat dateFormat1 = new SimpleDateFormat("YYYY");
			  DateFormat dateFormat2 = new SimpleDateFormat("MM");
			  //System.out.println(Calendar.getInstance().getTime());
			  //Date date = Calendar.getInstance().getTime();  
			  
			  Date date = new Date();
			  customerId = dateFormat1.format(date);
			  //System.out.println(customerId);
			  customerId+= dateFormat2.format(date);
			  System.out.println(customerId);
			  customerId+="0001";
		  }
		  else
		  {
			  
			  DateFormat dateFormatM = new SimpleDateFormat("MM");
			  Date date = Calendar.getInstance().getTime(); 
			  long currentMonth = Long.parseLong(dateFormatM.format(date));
			  long month = Long.parseLong(id.substring(4, 6));
			  
			  if(currentMonth==month)
			  {
				  long newId = Long.parseLong(id) +1 ;
				  customerId = Long.toString(newId);
			  }
			  else
			  {
				  DateFormat dateFormatY = new SimpleDateFormat("YYYY");
				  customerId = dateFormatY.format(date) + dateFormatM.format(date) + "0001";
			  }
				  
			
				  
		  }
		  
		  System.out.println("Generated ID -  " + customerId);
		  customerTO.setCustomerId(customerId);
	}
	
	
	
	
	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GET CUSTOMER RECORD >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	
	//GET SPECIFIC ID
	public CustomerTO getRequestedCustomerRecord(String customerId) throws  MVCApplicationException
	{
		CustomerDAOI customerDAOI = new CustomerDAO();
		return customerDAOI.getCustomerId(customerId);
	
	}
	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  UPDATE CUSTOMER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	public boolean updateCustomer(CustomerTO customerTO) throws MVCApplicationException
	{
		boolean validateCustomerUpdate = false;
		int count = validateUpdationEntries(customerTO);
		
		if(!(count>0))
		{
			CustomerDAOI customerDAOI = new CustomerDAO();
			validateCustomerUpdate = customerDAOI.updateCustomer(customerTO);
		}				
				
		return validateCustomerUpdate;
		
	}

	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VIEW RECORDS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	
	
	
	
	
		public List<CustomerTO> getCustomerRecords(CustomerTO customerTO) throws MVCApplicationException 
		{
			System.out.println("Into DAO");
			CustomerDAOI customerDAOI = new CustomerDAO();
			List<CustomerTO> customerRecords =  customerDAOI.getCustomerRecords(customerTO);
			
			return customerRecords;
		}
		
	
	
	
	
		
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DELETE RECORD >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
		
		
		
		
		
		public CustomerTO deleteCustomer(String customerId) throws MVCApplicationException
		{
			CustomerDAOI customerDAOI = new CustomerDAO();
			return customerDAOI.deleteCustomer(customerId);
		}
	
	
	
	
	
	
	//==============================================================<<  VALIDATORS  >>===================================================================================
	
		
		
		

	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VALIDATE NEW CUSTOMER ENTRY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	public int validateCustomerEntries(CustomerTO customerTO) throws MVCApplicationException
	{
		
		int count = 0;
		
		String customerName = customerTO.getCustomerName();
		String customerAddress = customerTO.getCustomerAddress();
	    String customerCountryId = customerTO.getCustomerCountryId();
		String customerStateId = customerTO.getCustomerStateId();
		String customerCityId = customerTO.getCustomerCityId();
		String customerZipCode = customerTO.getCustomerZipCode();
		String customerEmail = customerTO.getCustomerEmail();
		String customerGender = customerTO.getCustomerGender();
		String strCustomerContactNumber = customerTO.getStrCustomerContactNumber();
		String strCustomerDOB = customerTO.getStrCustomerDOB();
		String customerType = customerTO.getCustomerType();
		String customerPassword = customerTO.getCustomerPassword();
		
		
		
		//Validators
		String AlphaSpacesPattern = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
		String AlphaSpecialNumericPattern = "^[.0-9a-zA-Z ,-]+$";
		String AlphaPattern = "^[a-zA-Z]*$";
		String AlphaNumericPattern = "^[a-zA-Z0-9]*$";
		String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+  "[a-zA-Z0-9_+&*-]+)*@" +  "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
		String NumberPattern = "^[0-9]{10}$";
		String genderPattern = "^[mM]?$|^[fF]?$";
		
		
		
		//Validations
		if( (customerName.isEmpty()) || (customerName==null) || (!(customerName.matches(AlphaSpacesPattern))) || (customerName.length()>45))
		{
			count++;		
		}
		
		if( (customerAddress.isEmpty()) || (customerAddress==null) || (!(customerAddress.matches(AlphaSpecialNumericPattern))) || (customerAddress.length()>50))
		{	
			count++;
		}	
		
		if( (customerCountryId.isEmpty()) || (customerCountryId==null) || (customerCountryId.equals("-")) || (!(customerCountryId.matches(AlphaPattern))) || customerCountryId.length()>4 || customerAddress.length()==0)
		{
			count++;	
		}
		
		if( (customerStateId.isEmpty()) || (customerStateId==null) || (customerStateId.equals("-")) || (!(customerStateId.matches(AlphaPattern))) || (customerStateId.length()>4) || (customerStateId.length()==0) )
		{
			count++;	
		}
		
		if( (customerCityId.isEmpty()) || (customerCityId==null) || (customerCityId.equals("-")) || (!(customerCityId.matches(AlphaPattern))) || (customerCityId.length()>4) || (customerCityId.length()==0) )
		{
			count++;
		}
		
		if( (customerZipCode.isEmpty()) || (customerZipCode==null) || (!(customerZipCode.length()<11))  || (!(customerZipCode.matches(AlphaNumericPattern))))
		{
			count++;
		}
		
		if( (customerEmail.isEmpty()) || (customerEmail==null) || (!(customerEmail.matches(emailPattern))) )
		{
			count++;
		}
		
		if( (customerGender.isEmpty()) || (customerGender==null) || (!(customerGender.matches(genderPattern))))
		{
			count++;
		}
		
		if( (strCustomerContactNumber.isEmpty()) || (strCustomerContactNumber==null) || (!(strCustomerContactNumber.matches(NumberPattern)) ))
		{
			count++;
		}
		else
			{
				customerTO.setCustomerContactNumber(Long.parseLong(strCustomerContactNumber));
			}
	
		
		if( (strCustomerDOB==null) || (strCustomerDOB.isEmpty()) )
			{
				count++;
			}
		else
		{
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date birthDate;
			try 
			{
				birthDate = sdf.parse(strCustomerDOB);
			}
			catch (ParseException e) 
			{
				throw new MVCApplicationException(e);
			}

		    long ageInMillis = System.currentTimeMillis() - birthDate.getTime();

		    double age = ageInMillis /(365 * 24*60*60*1000l);

		    if(age>=18 && age<=80)
		    {
		    	customerTO.setCustomerDOB(birthDate);
		    }
		    else
		    	count++;
		    
		    
		}		
		
			
		
		if( (customerType.isEmpty()) || (customerType==null) || (customerType.endsWith("-")) || (!(customerType.matches(AlphaPattern))) || (customerType.length()!=1) )
		{
			count++;
		}
		
		if( (customerPassword.isEmpty()) || (customerPassword==null) || (!(customerPassword.matches(AlphaSpecialNumericPattern))) || (!(customerPassword.length()<20)) )
		{
			count++;
		}
		return count;
		
		
	}
	
	
	
	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< VALIDATE UPDATION ENTRIES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	
	
	
	
	public int validateUpdationEntries(CustomerTO customerTO)
	{
		
		String customerName = customerTO.getCustomerName();
		String customerAddress = customerTO.getCustomerAddress();
	    String customerCountryId = customerTO.getCustomerCountryId();
		String customerStateId = customerTO.getCustomerStateId();
		String customerCityId = customerTO.getCustomerCityId();
		String customerZipCode = customerTO.getCustomerZipCode();
		String customerEmail = customerTO.getCustomerEmail();
		
		
		int count = 0;
		
		
		//Validators
				String AlphaSpacesPattern = "[a-zA-Z][a-zA-Z ]+[a-zA-Z]$";
				String AlphaSpecialNumericPattern = "^[.0-9a-zA-Z ,-]+$";
				String AlphaPattern = "^[a-zA-Z]*$";
				String AlphaNumericPattern = "^[a-zA-Z0-9]*$";
				String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+  "[a-zA-Z0-9_+&*-]+)*@" +  "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
				
				
		
				//Validations
				if( (customerName.isEmpty()) || (customerName==null) || (!(customerName.matches(AlphaSpacesPattern))) || (customerName.length()>45))
				{
					count++;
				}
				
				if( (customerAddress.isEmpty()) || (customerAddress==null) || (!(customerAddress.matches(AlphaSpecialNumericPattern))) || (customerAddress.length()>50))
				{	
					count++;
				}
				
				if( (customerCountryId.isEmpty()) || (customerCountryId==null) || (!(customerCountryId.matches(AlphaPattern))) || customerCountryId.length()>4 || customerAddress.length()==0)
				{
					count++;
				}
				
				if( (customerStateId.isEmpty()) || (customerStateId==null) || (!(customerStateId.matches(AlphaPattern))) || (customerStateId.length()>4) || (customerStateId.length()==0) )
				{	
					count++;
				}
				
				if( (customerCityId.isEmpty()) || (customerCityId==null) || (!(customerCityId.matches(AlphaPattern))) || (customerCityId.length()>4) || (customerCityId.length()==0) )
				{
					count++;
				}
				
				if( (customerZipCode.isEmpty()) || (customerZipCode==null) || (!(customerZipCode.length()<11))  || (!(customerZipCode.matches(AlphaNumericPattern))))
				{
					count++;
				}
				
				if( (customerEmail.isEmpty()) || (customerEmail==null) || (!(customerEmail.matches(emailPattern))) )
				{
					count++;
				}
				
				
				return count;
		
		
	}


}
