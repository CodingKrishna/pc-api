package org.pioneercoders.dao.hr;

import java.util.List;

import org.pioneercoders.entity.hr.JobInfoEntity;
import org.pioneercoders.exceptions.DBException;

public interface JobInfoDao {
	
	public JobInfoEntity createJobInfoRecord(JobInfoEntity jobInfoEntity) throws DBException;
	
	public List<JobInfoEntity> getJobInfoListByHrId(Long hrId) throws DBException;
	
	public JobInfoEntity updateJobInfo(JobInfoEntity entity) throws DBException;
	
}
