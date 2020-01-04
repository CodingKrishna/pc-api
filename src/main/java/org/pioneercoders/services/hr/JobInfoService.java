package org.pioneercoders.services.hr;

import java.util.List;

import org.pioneercoders.dto.hr.JobInfoDto;
import org.pioneercoders.dto.hr.JobInfoTrnDto;
import org.pioneercoders.exceptions.ServiceException;

public interface JobInfoService {
	
	public JobInfoDto createJobInfoRecord(JobInfoDto jobInfoDto) throws ServiceException;
	
	public List<JobInfoDto> getAllJobsByHrId(Long hrId) throws ServiceException;
	
	public JobInfoDto updateJobInfo(JobInfoDto jobInfoDto)throws ServiceException;
	
	public JobInfoTrnDto createJobInfoTrnRecord(JobInfoTrnDto jobInfoTrnDto) throws ServiceException;
	
	public List<JobInfoTrnDto> getJobInfoTrnListByJobId(Long jobId) throws ServiceException;
	
	public List<JobInfoTrnDto> getJobInfoTrnListByStudentId(Long studentId,Long jobId) throws ServiceException;
	
}
