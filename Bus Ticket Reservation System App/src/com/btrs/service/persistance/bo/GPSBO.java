package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.CityTO;
import com.btrs.model.entity.CountryTO;
import com.btrs.model.entity.StateTO;
import com.btrs.model.entity.ZipCodeTO;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.persistance.dao.GPSDAO;


public class GPSBO
{
	
	GPSDAO gpsDAO = new GPSDAO();
	
	public List<CountryTO> getCountries(CountryTO countryTO) throws  MVCApplicationException
	{
		return gpsDAO.getCountries(countryTO);
	}

	
	public List<StateTO> getStates(StateTO stateTO) throws   MVCApplicationException 
	{
		return gpsDAO.getStates(stateTO);
	}
	
	
	public List<CityTO> getCities(CityTO cityTO) throws  MVCApplicationException
	{
		return gpsDAO.getCities(cityTO);
	}
	
	public List<ZipCodeTO> getZipCodes(ZipCodeTO zipCodeTO) throws  MVCApplicationException
	{
		return gpsDAO.getZipCodes(zipCodeTO);
	}
	
}
