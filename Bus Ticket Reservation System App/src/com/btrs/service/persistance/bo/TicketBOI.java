package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.TicketTO;

public interface TicketBOI 
{
	

/*	public List<TicketTO> getTickets(String customerID) throws SQLException;

	public boolean cancelReservation(String ticketID) throws SQLException;*/

	
	//Book Tickets
	public boolean getTravelDetails(TicketTO ticketTO);

	List<TicketTO> getTickets(String customerID) throws SQLException;

	boolean cancelReservation(String ticketID) throws SQLException;
	
}
