package org.pioneercoders.dao.user;

import java.util.List;

import org.pioneercoders.entity.student.ReferralEntity;
import org.pioneercoders.exceptions.DBException;

public interface ReferralDao {

	public ReferralEntity createReferral(ReferralEntity referralEntity)throws DBException;
	
	public int addReferralRecords(List<ReferralEntity> entity)throws DBException;
	
	public List<ReferralEntity> getReferralsByUserId(Long userId) throws DBException;
	
}
