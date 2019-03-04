package com.btrs.service.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.btrs.model.entity.UserTO;
import com.btrs.service.constants.ErrorConstants;
import com.btrs.service.constants.SuccessConstants;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.exception.MVCBusinessException;
import com.btrs.service.persistance.bo.UserBO;
import com.btrs.service.persistance.bo.UserBOI;



public class LoginController extends HttpServlet
{

	private static final long serialVersionUID = 1L;
       
	 static String page = null;
	
	
    public LoginController() 
    {
        super();    
   }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String theCommand = request.getParameter("TheCommand");
		
		
		switch (theCommand) 
		{
			case "HOME": page = SuccessConstants.HOME_PAGE;
				break;

		default: page = SuccessConstants.LOGIN_PAGE;
			break;
		}
		
		deployPageRequest(request, response, page);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String userId = request.getParameter("UserId");
		String password = request.getParameter("password");
		
		UserTO userTO = new UserTO(userId, password);
	
		UserBOI userBOI = new UserBO();
		try 
		{	
		
			boolean validUser = userBOI.validateUser(userTO); 
			
			if(validUser)
			{
				
				HttpSession session = request.getSession();
				session.setAttribute("Welcome", userTO);
				page = SuccessConstants.HOME_PAGE;
			}
			else
			{
				throw new MVCApplicationException();
			}
		
		
		} 
		catch (MVCApplicationException e) 
		{
			request.setAttribute("Err-User", ErrorConstants.LOGIN_ERROR);
			page = ErrorConstants.LOGIN_PAGE;
			
		} 
		catch (MVCBusinessException e) 
		{
			request.setAttribute("ERRORMAP", e.getErrorMap());
			page = ErrorConstants.LOGIN_PAGE;
		}	
		
		deployPageRequest(request, response, page);
	}
	
	
	
	
	
	
	
	
	public void deployPageRequest(HttpServletRequest request,HttpServletResponse response, String page) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}

}
