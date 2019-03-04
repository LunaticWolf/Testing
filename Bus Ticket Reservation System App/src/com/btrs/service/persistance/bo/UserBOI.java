package com.btrs.service.persistance.bo;

import com.btrs.model.entity.UserTO;
import com.btrs.service.exception.MVCApplicationException;
import com.btrs.service.exception.MVCBusinessException;

public interface UserBOI 
{

	public boolean validateUser(UserTO userTO) throws MVCApplicationException, MVCBusinessException;
	
}
