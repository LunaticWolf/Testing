package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.btrs.model.entity.UserTO;
import com.btrs.service.constants.ErrorConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.exception.MVCBusinessException;
import com.btrs.service.persistance.dao.UserDAO;
import com.btrs.service.persistance.dao.UserDAOI;


public class UserBO implements UserBOI
{

	static Map<String,String> errorMap = new HashMap<String,String>();
	
	public UserBO()
	{	
		errorMap.put("ErrUserPassword","");
	}
	
	
	@Override
	public boolean validateUser(UserTO userTO) throws MVCApplicationException, MVCBusinessException
	{
		
		boolean validateUser = false;
		int count = validateLogin(userTO);	
		
		UserDAOI userDAOI = new UserDAO();

		if(!(count>0))
		{
			try
			{
				
				validateUser = userDAOI.verifyUserAuthentication(userTO);
			}
			catch(SQLException e)
			{
				throw new MVCApplicationException(e);
			}
		}
		else
		{
			MVCBusinessException mbException = new MVCBusinessException();
			mbException.setErrorMap(errorMap);
			
			throw mbException;
		}
		
		
	
		return validateUser;
		
	}

	
	private int validateLogin(UserTO userTO) 
	{
		
		
		String user = userTO.getUserId();
		String password = userTO.getPassword();
		
		String userIdPattern = "^[0-9]*$";
		String passwordPattern = "^[a-zA-Z0-9_]*$";
		
		int count=0;
		
	
		if(user==null || password==null || user.isEmpty() || password.isEmpty())
		{
			count++;
			errorMap.put("ErrUserPassword", ErrorConstants.EMPTY_USER_PASSWORD);
		}
		
		if((!(user.length()<11)) || (!(user.matches(userIdPattern))  || (!(password.matches(passwordPattern)))))
		{
			
			count++	;
			errorMap.put("ErrUserPassword", ErrorConstants.INVALID_USER_PASSWORD);
		}	
		
		
		return count;
	}

}
