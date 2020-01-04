package org.pioneercoders.dao.evaluation;

import java.util.List;

import org.pioneercoders.entity.evaluation.UserKnownAppsEntity;
import org.pioneercoders.exceptions.DBException;

public interface UserKnownAppsDao {
	
	public UserKnownAppsEntity createUserKnownAppsInfo(UserKnownAppsEntity UserKnownAppsEntity) throws DBException;
	
	public UserKnownAppsEntity getUserKnownAppsInfoByUserId(Long userId) throws DBException;
	
	
	

}
