package com.btrs.service.controller;

import java.io.IOException;
import java.net.HttpRetryException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.btrs.service.constants.SuccessConstants;


public class LogoutController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	String page = null;
    
    public LogoutController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String theCommand = request.getParameter("TheCommand");
		
		switch (theCommand) 
		{
			case "LogOut": logout(request,response);
			break;

		}
		
		
		deployPageRequest(request, response, page);
	}

	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
	{
	
		HttpSession session = request.getSession();
		session.invalidate();
		
		request.setAttribute("LogOut", SuccessConstants.USER_LOGOUT);
		page = SuccessConstants.LOGIN_PAGE;
		
	}


	
	void deployPageRequest(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}
	
}
