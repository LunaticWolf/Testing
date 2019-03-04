package com.btrs.service.persistance.bo;

import java.sql.SQLException;
import java.util.List;

import com.btrs.model.entity.CityTO;
import com.btrs.model.entity.CountryTO;
import com.btrs.model.entity.StateTO;
import com.btrs.model.entity.ZipCodeTO;

public interface GPSBOI 
{

	public List<CountryTO> getCountries(CountryTO countryTO) throws SQLException;
	public List<StateTO> getStates(StateTO stateTO) throws  SQLException;
	public List<CityTO> getCities(CityTO cityTO) throws  SQLException;
	public List<ZipCodeTO> getZipCodes(ZipCodeTO zipCodeTO) throws  SQLException;
	
}
