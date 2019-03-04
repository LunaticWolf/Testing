package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.BusTO;
import com.btrs.service.exception.MVCApplicationException;

public interface BusBOI 
{

	public boolean validateBusEntry(BusTO busTO) throws   MVCApplicationException;
	
	public List<BusTO> getBusses() throws  MVCApplicationException;
}
