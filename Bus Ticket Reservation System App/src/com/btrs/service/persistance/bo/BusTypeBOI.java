package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.BusTypeTO;
import com.btrs.service.exception.MVCApplicationException;

public interface BusTypeBOI 
{

	public List<BusTypeTO> getBusTypes(BusTypeTO busTypeTO) throws SQLException, MVCApplicationException;
	
}
