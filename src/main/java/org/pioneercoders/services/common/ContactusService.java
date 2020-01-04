package org.pioneercoders.services.common;

import java.util.List;

import org.pioneercoders.dto.common.ContactusDto;
import org.pioneercoders.exceptions.ServiceException;

public interface ContactusService {

	public ContactusDto createContactusInfo(ContactusDto contactusDto) throws ServiceException;
	
	public List<ContactusDto> getContactusInfoList()throws ServiceException;
}
