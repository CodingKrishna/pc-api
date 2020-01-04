package org.pioneercoders.services.evaluation;

import org.pioneercoders.dto.evaluation.UserKnownAppsDto;
import org.pioneercoders.exceptions.ServiceException;

public interface UserKnownAppsService {

	public UserKnownAppsDto createUserKnownApps(UserKnownAppsDto UserKnownAppsDto)throws ServiceException;
	
	public UserKnownAppsDto getUserKnownAppsDetailsByUserId(Long userId)throws ServiceException;
}
