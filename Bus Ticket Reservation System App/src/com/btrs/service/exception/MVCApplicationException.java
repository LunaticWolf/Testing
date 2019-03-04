package com.btrs.service.exception;

public class MVCApplicationException extends Exception
{

	private static final long serialVersionUID = 1L;
	

		public MVCApplicationException()
		{
			super();
		}
	
		public MVCApplicationException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
		{
			super(arg0, arg1, arg2, arg3);
		}
	
		public MVCApplicationException(String arg0, Throwable arg1) 
		{
			super(arg0, arg1);	
		}
	
		public MVCApplicationException(String arg0)
		{
			super(arg0);	
		}
	
		public MVCApplicationException(Throwable arg0) 
		{
			super(arg0);	
		}
	
	

}
