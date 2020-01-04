package org.pioneercoders.services.hr.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.hr.ShortListedProfilesDao;
import org.pioneercoders.dto.hr.ShortListedProfileDto;
import org.pioneercoders.entity.hr.ShortListedProfileEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.ShortListedProfileService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ShortListedProfileServiceImpl implements ShortListedProfileService {
	
private static final Logger log = LoggerFactory.getLogger(ShortListedProfileServiceImpl.class);
	
	@Autowired
	ShortListedProfilesDao shortListedProfileDao;
	
	public ShortListedProfileDto createShortLisedProfiles(ShortListedProfileDto ShortListedProfileDto) throws ServiceException {
		ShortListedProfileDto finalDto=null;
		try {
			ShortListedProfileEntity profileEntity = DozerBeanMapperSingletonWrapper.getInstance().map(ShortListedProfileDto, ShortListedProfileEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(shortListedProfileDao.createProfileRecord(profileEntity),ShortListedProfileDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	public List<ShortListedProfileDto> getShortListedProfilesList() throws ServiceException {
		try {
			List<ShortListedProfileEntity> list = shortListedProfileDao.getShortListedProfiles();
			List<ShortListedProfileDto> profilesList = CollectionMapper.getMappingList(list.iterator(), ShortListedProfileDto.class);
			log.info("Returning ShortListedProfiles List data -->: ");
			return profilesList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing userList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
