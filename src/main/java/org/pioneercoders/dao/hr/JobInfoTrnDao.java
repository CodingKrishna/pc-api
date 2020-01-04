package org.pioneercoders.dao.hr;

import java.util.List;

import org.pioneercoders.entity.hr.JobInfoTrnEntity;
import org.pioneercoders.exceptions.DBException;

public interface JobInfoTrnDao {
	
	public JobInfoTrnEntity createJobInfoTrnRecord(JobInfoTrnEntity jobInfoTrnEntity) throws DBException;
	
	public List<JobInfoTrnEntity> getJobInfoTrnListByJobId(Long jobId) throws DBException;
	
	public List<JobInfoTrnEntity> getJobInfoTrnListByStudentId(Long studentId,Long jobId) throws DBException;

}
