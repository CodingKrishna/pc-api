package org.pioneercoders.dao.hr.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.hr.JobInfoTrnDao;
import org.pioneercoders.entity.hr.JobInfoTrnEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobInfoTrnDaoImpl implements JobInfoTrnDao{

	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(JobInfoTrnDaoImpl.class);
	
	public JobInfoTrnEntity createJobInfoTrnRecord(JobInfoTrnEntity jobInfoTrnEntity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			jobInfoTrnEntity.setId((Long)session.save(jobInfoTrnEntity));
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating JobInfoTrnEntity  Record ["+jobInfoTrnEntity.getJob()+"] ["+jobInfoTrnEntity.getStudentId()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()) {
			log.debug("JobInfoTrnEntity Record inserted with id ["+jobInfoTrnEntity.getId()+"] ["+jobInfoTrnEntity.getStudentId()+"] ["+jobInfoTrnEntity.getJob().getId()+"]");
		}
		return jobInfoTrnEntity;
	}

	public List<JobInfoTrnEntity> getJobInfoTrnListByJobId(Long jobId) throws DBException {
		log.debug("Entered into getJobInfoTrnList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from JobInfoTrnEntity where job.id="+jobId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getJobInfoTrnList");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}
	
	public List<JobInfoTrnEntity> getJobInfoTrnListByStudentId(Long studentId,Long jobId) throws DBException {
		log.debug("Entered into getJobInfoTrnList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from JobInfoTrnEntity where studentId="+studentId+" and job.id="+jobId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getJobInfoTrnList");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
