package org.pioneercoders.services.hr.impl;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.hr.CompanyDao;
import org.pioneercoders.dao.hr.JobInfoDao;
import org.pioneercoders.dao.hr.JobInfoTrnDao;
import org.pioneercoders.dto.hr.CompanyDto;
import org.pioneercoders.dto.hr.JobInfoDto;
import org.pioneercoders.dto.hr.JobInfoTrnDto;
import org.pioneercoders.entity.hr.JobInfoEntity;
import org.pioneercoders.entity.hr.JobInfoTrnEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.JobInfoService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class JobInfoServiceImpl implements JobInfoService{
	
	
	private static final Logger log = LoggerFactory.getLogger(JobInfoServiceImpl.class);
	
	@Autowired
	JobInfoDao jobInfoDao;
	
	@Autowired
	JobInfoTrnDao jobInfoTrnDao;
	
	@Autowired
	CompanyDao companyDao;
	

	public JobInfoDto createJobInfoRecord(JobInfoDto jobInfoDto) throws ServiceException {
		// TODO Auto-generated method stub
		JobInfoDto finaljobInfoDto=null;
		try {
			JobInfoEntity jobInfoEntity = DozerBeanMapperSingletonWrapper.getInstance().map(jobInfoDto, JobInfoEntity.class);
			finaljobInfoDto = DozerBeanMapperSingletonWrapper.getInstance().map(jobInfoDao.createJobInfoRecord(jobInfoEntity), JobInfoDto.class);
			CompanyDto companyDto = DozerBeanMapperSingletonWrapper.getInstance().map(companyDao.getCompanyById(finaljobInfoDto.getCompany().getId()),CompanyDto.class);
			finaljobInfoDto.setCompany(companyDto);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finaljobInfoDto;
	}

	public List<JobInfoDto> getAllJobsByHrId(Long hrId) throws ServiceException {
		try {
			List<JobInfoEntity> list = jobInfoDao.getJobInfoListByHrId(hrId);
			List<JobInfoDto> jobInfoList = CollectionMapper.getMappingList(list.iterator(), JobInfoDto.class);

			log.info("Returning jobInfoList List -->: ");
			return jobInfoList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing jobInfoList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public JobInfoDto updateJobInfo(JobInfoDto jobInfoDto) throws ServiceException {
		JobInfoDto finalJobInfoDto=null;
		try {
			JobInfoEntity jobInfoEntity = DozerBeanMapperSingletonWrapper.getInstance().map(jobInfoDto,JobInfoEntity.class);
			finalJobInfoDto = DozerBeanMapperSingletonWrapper.getInstance().map(jobInfoDao.updateJobInfo(jobInfoEntity),JobInfoDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalJobInfoDto;
	}

	public JobInfoTrnDto createJobInfoTrnRecord(JobInfoTrnDto jobInfoTrnDto) throws ServiceException {
		JobInfoTrnDto finaljobInfoTrnDto=null;
		try {
			JobInfoTrnEntity jobInfoTrnEntity = DozerBeanMapperSingletonWrapper.getInstance().map(jobInfoTrnDto, JobInfoTrnEntity.class);
			finaljobInfoTrnDto = DozerBeanMapperSingletonWrapper.getInstance().map(jobInfoTrnDao.createJobInfoTrnRecord(jobInfoTrnEntity), JobInfoTrnDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finaljobInfoTrnDto;
	}

	public List<JobInfoTrnDto> getJobInfoTrnListByJobId(Long jobId) throws ServiceException {
		try {
			List<JobInfoTrnEntity> list = jobInfoTrnDao.getJobInfoTrnListByJobId(jobId);
			List<JobInfoTrnDto> jobInfoTrnList = CollectionMapper.getMappingList(list.iterator(), JobInfoTrnDto.class);

			log.info("Returning jobInfoTrnList -->: ");
			return jobInfoTrnList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing jobInfoTrnList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	public List<JobInfoTrnDto> getJobInfoTrnListByStudentId(Long studentId,Long jobId) throws ServiceException {
		try {
			List<JobInfoTrnEntity> list = jobInfoTrnDao.getJobInfoTrnListByStudentId(studentId,jobId);
			List<JobInfoTrnDto> jobInfoTrnList = CollectionMapper.getMappingList(list.iterator(), JobInfoTrnDto.class);

			log.info("Returning jobInfoTrnList -->: ");
			return jobInfoTrnList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing jobInfoTrnList Methode");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
