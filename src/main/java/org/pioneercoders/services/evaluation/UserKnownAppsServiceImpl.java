package org.pioneercoders.services.evaluation;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.evaluation.UserKnownAppsDao;
import org.pioneercoders.dto.evaluation.UserKnownAppsDto;
import org.pioneercoders.entity.evaluation.UserKnownAppsEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserKnownAppsServiceImpl  implements  UserKnownAppsService{

	@Autowired
	UserKnownAppsDao userKnowAppsDao;

	@Override
	public UserKnownAppsDto createUserKnownApps(UserKnownAppsDto userKnownAppsDto) throws ServiceException {
		UserKnownAppsDto finalDto=null;
		try {
			UserKnownAppsEntity entity = DozerBeanMapperSingletonWrapper.getInstance().map(userKnownAppsDto, UserKnownAppsEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(userKnowAppsDao.createUserKnownAppsInfo(entity),UserKnownAppsDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	@Override
	public UserKnownAppsDto getUserKnownAppsDetailsByUserId(Long userId)throws ServiceException {
			UserKnownAppsDto evaluationDto=null;
			try{
				UserKnownAppsEntity entity = userKnowAppsDao.getUserKnownAppsInfoByUserId(userId);
				if(entity!=null){
					evaluationDto=DozerBeanMapperSingletonWrapper.getInstance().map(entity, UserKnownAppsDto.class);
				}
				return evaluationDto;
			} catch(DBException e) {
					throw new ServiceException(e.getMessage(),e);
			}
	}
	
}
