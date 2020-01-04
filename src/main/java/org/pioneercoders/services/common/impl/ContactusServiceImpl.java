package org.pioneercoders.services.common.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.common.ContactusDao;
import org.pioneercoders.dto.common.ContactusDto;
import org.pioneercoders.entity.common.ContactusEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.common.ContactusService;
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
public class ContactusServiceImpl implements ContactusService{
	
	private static final Logger log = LoggerFactory.getLogger(ContactusServiceImpl.class);
	
	@Autowired
	ContactusDao contactusDao;

	@Override
	public ContactusDto createContactusInfo(ContactusDto contactusDto)throws ServiceException {
		// TODO Auto-generated method stub
		ContactusDto finalContactusDto=null;
		try {
			contactusDto.setStatus(Constants.STATUS_ACTIVE);
			contactusDto.setCreatedOn(Constants.CREATED_ON());
			ContactusEntity contactusEntity = DozerBeanMapperSingletonWrapper.getInstance().map(contactusDto, ContactusEntity.class);
			finalContactusDto = DozerBeanMapperSingletonWrapper.getInstance().map(contactusDao.createContactusInfo(contactusEntity),ContactusDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalContactusDto;
	}

	@Override
	public List<ContactusDto> getContactusInfoList() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			List<ContactusEntity> list = contactusDao.getContactusInfoList();
			List<ContactusDto> contactUsList = CollectionMapper.getMappingList(list.iterator(), ContactusDto.class);

			log.info("Returning ContactUs List -->: ");
			return contactUsList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing ContactUsList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
