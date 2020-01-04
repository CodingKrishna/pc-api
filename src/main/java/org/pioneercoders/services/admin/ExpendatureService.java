package org.pioneercoders.services.admin;

import java.util.List;

import org.pioneercoders.dto.admin.ExpendatureDto;
import org.pioneercoders.exceptions.ServiceException;

public interface ExpendatureService {
	
    public ExpendatureDto saveExpendatrue(ExpendatureDto expendatureDto)throws ServiceException;
	
	public List<ExpendatureDto> getAllExpendatureList()throws ServiceException;

}
