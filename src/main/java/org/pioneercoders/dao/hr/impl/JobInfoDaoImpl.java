package org.pioneercoders.dao.hr.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.hr.JobInfoDao;
import org.pioneercoders.entity.hr.JobInfoEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class JobInfoDaoImpl implements JobInfoDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(JobInfoDaoImpl.class);

	public JobInfoEntity createJobInfoRecord(JobInfoEntity jobInfoEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			jobInfoEntity.setId((Long)session.save(jobInfoEntity));
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating JobInfo  Record ["+jobInfoEntity.getJobTitle()+"] ["+jobInfoEntity.getLocation()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()) {
			log.debug("JobInfo Record inserted with id ["+jobInfoEntity.getId()+"] ["+jobInfoEntity.getJobTitle()+"] ["+jobInfoEntity.getLocation()+"]");
		}
		return jobInfoEntity;
	}

	public List<JobInfoEntity> getJobInfoListByHrId(Long HrId) throws DBException {
		log.debug("Entered into getJobInfoList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from JobInfoEntity where user.id="+HrId;
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getJobInfoList");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

	public JobInfoEntity updateJobInfo(JobInfoEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(entity);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while updating JobInfo  Record ["+entity.getJobTitle()+"] ["+entity.getLocation()+"]");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
			
		}
		if(log.isDebugEnabled()){
			log.debug("JobInfo Record is updated with id ["+entity.getId()+"] ["+entity.getJobTitle()+"] ["+entity.getLocation()+"]");
		}
		return entity;
	}

}
