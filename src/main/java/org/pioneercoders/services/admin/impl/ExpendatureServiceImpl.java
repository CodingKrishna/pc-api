package org.pioneercoders.services.admin.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.admin.ExpendatureDao;
import org.pioneercoders.dto.admin.ExpendatureDto;
import org.pioneercoders.entity.admin.ExpendatureEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.admin.ExpendatureService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)

public class ExpendatureServiceImpl implements ExpendatureService{

		
	private static final Logger log = LoggerFactory.getLogger(ExpendatureServiceImpl.class);
	
	@Autowired
	ExpendatureDao expendatureDao;
	
	@Override
	public ExpendatureDto saveExpendatrue(ExpendatureDto expendatureDto) throws ServiceException {
		ExpendatureDto finalDto=null;
		try {
			expendatureDto.setCreateOn(new Date());
			ExpendatureEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(expendatureDto, ExpendatureEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(expendatureDao.saveExpendature(entity),ExpendatureDto.class);
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing Expendature record Save");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}
	
	@Override
	public List<ExpendatureDto> getAllExpendatureList() throws ServiceException {
		log.info("Entered into getAllExpendatureList Method-->: ");
		List<ExpendatureEntity> list;
		try {
			list = expendatureDao.getExpendatureList();
			List<ExpendatureDto> expendatureList = CollectionMapper.getMappingList(list.iterator(), ExpendatureDto.class);
			log.info("Returning expendatureList data -->: ");
			return expendatureList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllExpendatureListsList method");
				log.error(e.getMessage());
			}
			
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
