package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.BusTO;
import com.btrs.model.entity.BusTypeTO;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.dao.BusTypeDAO;
import com.btrs.service.persistance.dao.BusTypeDAOI;

public class BusTypeBO implements BusTypeBOI
{

	public List<BusTypeTO> getBusTypes(BusTypeTO busTypeTO) throws  MVCApplicationException
	{
		BusTypeDAOI busTypeDAOI = (BusTypeDAOI) new BusTypeDAO();
		
		try 
		{
			return busTypeDAOI.getBusTypes(busTypeTO);
		} 
		catch (SQLException e) 
		{
			throw new MVCApplicationException(e);
		}	
		
	}

}
