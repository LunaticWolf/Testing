package com.btrs.service.persistance.dao;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.BusTypeTO;
import com.btrs.service.exception.MVCApplicationException;

public interface BusTypeDAOI 
{

	public List<BusTypeTO> getBusTypes(BusTypeTO busTypeTO) throws SQLException, MVCApplicationException;
	
}
