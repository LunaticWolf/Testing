package com.btrs.model.entity;

public class CustomerTypeTO 
{

	private String customerTypeId;
	private String customerType;
	private String customerPriority;
	private int customer_weightage;
	
	
	public CustomerTypeTO() {}


	public CustomerTypeTO(String customerTypeId, String customerType,
			String customerPriority, int customer_weightage)
	{
		super();
		this.customerTypeId = customerTypeId;
		this.customerType = customerType;
		this.customerPriority = customerPriority;
		this.customer_weightage = customer_weightage;
	}


	public String getCustomerTypeId() {
		return customerTypeId;
	}


	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}


	public String getCustomerType() {
		return customerType;
	}


	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	public String getCustomerPriority() {
		return customerPriority;
	}


	public void setCustomerPriority(String customerPriority) {
		this.customerPriority = customerPriority;
	}


	public int getCustomer_weightage() {
		return customer_weightage;
	}


	public void setCustomer_weightage(int customer_weightage) {
		this.customer_weightage = customer_weightage;
	}
	
	
	
	
	
}
