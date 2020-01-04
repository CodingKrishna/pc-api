package org.pioneercoders.dao.hr;

import java.util.List;

import org.pioneercoders.entity.hr.ShortListedProfileEntity;
import org.pioneercoders.exceptions.DBException;

public interface ShortListedProfilesDao {
	
	public ShortListedProfileEntity createProfileRecord(ShortListedProfileEntity shortListedProfileEntity) throws DBException;
	
	public List<ShortListedProfileEntity> getShortListedProfiles() throws DBException;

}
