package com.btrs.service.exception;

import java.util.Map;



public class MVCBusinessException extends Exception
{

	Map<String, String> errorMap;
	
	
	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
	
	

	private static final long serialVersionUID = 1L;
		
		
		public MVCBusinessException() 
		{
			super();	
		}
	
		public MVCBusinessException(String arg0, Throwable arg1, boolean arg2,boolean arg3)
		{
			super(arg0, arg1, arg2, arg3);
		}
	
		public MVCBusinessException(String arg0, Throwable arg1) 
		{
			super(arg0, arg1);
		}
	
		public MVCBusinessException(String arg0) 
		{
			super(arg0);	
		}
	
		public MVCBusinessException(Throwable arg0) 
		{
			super(arg0);
		}

	
	
}
