package org.pioneercoders.services.hr.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.hr.CompanyDao;
import org.pioneercoders.dto.hr.CompanyDto;
import org.pioneercoders.entity.hr.CompanyEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.CompanyService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CompanyServiceImpl implements CompanyService {

private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
	
	@Autowired
	CompanyDao companyDao;
	
	public CompanyDto createCompanyRecord(CompanyDto companyDto)
			throws ServiceException {
		// TODO Auto-generated method stub
		CompanyDto finalCompanyDto=null;
		try {
			CompanyEntity companyEntity = DozerBeanMapperSingletonWrapper.getInstance().map(companyDto, CompanyEntity.class);
			finalCompanyDto = DozerBeanMapperSingletonWrapper.getInstance().map(companyDao.createCompanyRecord(companyEntity), CompanyDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalCompanyDto;
	}

	public List<CompanyDto> getAllCompaniesList() throws ServiceException {
		try {
			List<CompanyEntity> list = companyDao.getCompaniesList();
			List<CompanyDto> companyList = CollectionMapper.getMappingList(list.iterator(), CompanyDto.class);

			log.info("Returning companyList data -->: ");
			return companyList ;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing companyList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
