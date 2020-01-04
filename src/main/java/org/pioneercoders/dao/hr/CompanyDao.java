package org.pioneercoders.dao.hr;

import java.util.List;

import org.pioneercoders.entity.hr.CompanyEntity;
import org.pioneercoders.exceptions.DBException;

public interface CompanyDao {

	public CompanyEntity createCompanyRecord(CompanyEntity companyEntity) throws DBException;
	
	public List<CompanyEntity> getCompaniesList() throws DBException;
	
	public CompanyEntity getCompanyById(Long id) throws DBException;
	
}
