package org.pioneercoders.dao.common;

import java.util.List;

import org.pioneercoders.entity.common.ContactusEntity;
import org.pioneercoders.exceptions.DBException;

public interface ContactusDao {

	public ContactusEntity createContactusInfo(ContactusEntity contactusEntity) throws DBException;
	
	public List<ContactusEntity> getContactusInfoList()throws DBException;

}
