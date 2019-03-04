package com.btrs.service.persistance.dao;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.BusTO;
import com.btrs.service.exception.MVCApplicationException;

public interface BusDAOI 
{

	public String generateBusId(String id) throws  MVCApplicationException;
	public boolean addNewBus(BusTO busTO) throws  MVCApplicationException;
	public List<BusTO> getBusses() throws MVCApplicationException;
	
}
