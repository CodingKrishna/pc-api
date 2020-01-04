package org.pioneercoders.services.common.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.common.InstructorDao;
import org.pioneercoders.dto.common.InstructorDto;
import org.pioneercoders.entity.common.InstructorEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.common.InstructorService;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class InstructorServiceImpl implements InstructorService{
	
	private static final Logger log = LoggerFactory.getLogger(InstructorServiceImpl.class);
	
	@Autowired
	InstructorDao instructorDao;

	@Override
	public InstructorDto createInstructorInfo(InstructorDto instructorDto) throws ServiceException {
		// TODO Auto-generated method stub
		InstructorDto finalInstructorDto=null;
		try {
			instructorDto.setStatus(Constants.STATUS_ACTIVE);
			instructorDto.setCreatedOn(Constants.CREATED_ON());
			InstructorEntity instructorEntity = DozerBeanMapperSingletonWrapper.getInstance().map(instructorDto, InstructorEntity.class);
			finalInstructorDto = DozerBeanMapperSingletonWrapper.getInstance().map(instructorDao.createInstructorInfo(instructorEntity),InstructorDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalInstructorDto;
	}

	@Override
	public List<InstructorDto> getInstructorInfoList() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			List<InstructorEntity> list = instructorDao.getInstructorsList();
			List<InstructorDto> insturctorsList = CollectionMapper.getMappingList(list.iterator(), InstructorDto.class);
			log.info("Returning Instructors List -->: ");
			return insturctorsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing InstructorsList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	

}
