package org.pioneercoders.dao.common;

import java.util.List;

import org.pioneercoders.entity.common.SupportEntity;
import org.pioneercoders.exceptions.DBException;

public interface SupportDao{
	
	public SupportEntity createSupportRecord(SupportEntity supportEntity) throws DBException;

	public List<SupportEntity> getAllSupports() throws DBException;
	

}
