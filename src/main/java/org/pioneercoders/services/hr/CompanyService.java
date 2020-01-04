package org.pioneercoders.services.hr;

import java.util.List;

import org.pioneercoders.dto.hr.CompanyDto;
import org.pioneercoders.exceptions.ServiceException;

public interface CompanyService {
	
	public CompanyDto createCompanyRecord(CompanyDto companyDto) throws ServiceException;
	
	public List<CompanyDto> getAllCompaniesList() throws ServiceException;

}
