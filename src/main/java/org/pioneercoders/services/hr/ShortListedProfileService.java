package org.pioneercoders.services.hr;

import java.util.List;

import org.pioneercoders.dto.hr.ShortListedProfileDto;
import org.pioneercoders.exceptions.ServiceException;

public interface ShortListedProfileService {

	public ShortListedProfileDto createShortLisedProfiles(ShortListedProfileDto ShortListedProfileDto) throws ServiceException;
	
	public List<ShortListedProfileDto> getShortListedProfilesList()throws ServiceException;
}
