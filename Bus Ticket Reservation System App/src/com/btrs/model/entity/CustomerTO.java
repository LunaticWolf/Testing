package com.btrs.model.entity;

import java.util.Date;

public class CustomerTO 
{
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Fields >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerCountryId;
	private String customerStateId;
	private String customerCityId;
	private String customerZipCode;
	private String customerEmail;
	private String customerGender;
	private String strCustomerContactNumber;
	private String strCustomerDOB;
	private String customerType;
	private String customerPassword;
	
	
	private Date customerDOB;
	private long customerContactNumber;
	
	
	
	
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Constructors >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public CustomerTO() {}



	//Without ID
	public CustomerTO(String customerName,
			String customerAddress, String customerCountryId,
			String customerStateId, String customerCityId,
			String customerZipCode, String customerEmail,
			String customerGender, String strCustomerContactNumber,
			String strCustomerDOB, String customerType, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCountryId = customerCountryId;
		this.customerStateId = customerStateId;
		this.customerCityId = customerCityId;
		this.customerZipCode = customerZipCode;
		this.customerEmail = customerEmail;
		this.customerGender = customerGender;
		this.strCustomerContactNumber = strCustomerContactNumber;
		this.strCustomerDOB = strCustomerDOB;
		this.customerType = customerType;
		this.customerPassword = customerPassword;
	}


	//For Update
	public CustomerTO(String customerName, String customerAddress,
			String customerCountryId, String customerStateId,
			String customerCityId, String customerZipCode, String customerEmail) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCountryId = customerCountryId;
		this.customerStateId = customerStateId;
		this.customerCityId = customerCityId;
		this.customerZipCode = customerZipCode;
		this.customerEmail = customerEmail;
	}


	
	public CustomerTO(String customerName, String customerAddress, String customerCountryId,
			String customerStateId, String customerCityId, String customerZipCode, String customerEmail,
			String customerGender, String strCustomerContactNumber, String strCustomerDOB, String customerType)
	{
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerCountryId = customerCountryId;
		this.customerStateId = customerStateId;
		this.customerCityId = customerCityId;
		this.customerZipCode = customerZipCode;
		this.customerEmail = customerEmail;
		this.customerGender = customerGender;
		this.strCustomerContactNumber = strCustomerContactNumber;
		this.strCustomerDOB = strCustomerDOB;
		this.customerType = customerType;
	}



	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Getters & Setters >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}



	public String getCustomerCountryId() {
		return customerCountryId;
	}



	public void setCustomerCountryId(String customerCountryId) {
		this.customerCountryId = customerCountryId;
	}



	public String getCustomerStateId() {
		return customerStateId;
	}



	public void setCustomerStateId(String customerStateId) {
		this.customerStateId = customerStateId;
	}



	public String getCustomerCityId() {
		return customerCityId;
	}



	public void setCustomerCityId(String customerCityId) {
		this.customerCityId = customerCityId;
	}



	public String getCustomerZipCode() {
		return customerZipCode;
	}



	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public String getCustomerGender() {
		return customerGender;
	}



	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}



	public String getStrCustomerContactNumber() {
		return strCustomerContactNumber;
	}



	public void setStrCustomerContactNumber(String strCustomerContactNumber) {
		this.strCustomerContactNumber = strCustomerContactNumber;
	}



	public String getStrCustomerDOB() {
		return strCustomerDOB;
	}



	public void setStrCustomerDOB(String strCustomerDOB) {
		this.strCustomerDOB = strCustomerDOB;
	}



	public String getCustomerType() {
		return customerType;
	}



	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}



	public String getCustomerPassword() {
		return customerPassword;
	}



	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}



	public Date getCustomerDOB() {
		return customerDOB;
	}



	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}



	public long getCustomerContactNumber() {
		return customerContactNumber;
	}



	public void setCustomerContactNumber(long customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}
	 
	 
	
	
	
	
}
