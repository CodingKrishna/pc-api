package org.pioneercoders.dao.evaluation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.entity.evaluation.InterviewFeedbackEntity;
import org.pioneercoders.entity.evaluation.UserInterviewStatusEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InterviewFeedbackDaoImpl implements InterviewFeedbackDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(InterviewFeedbackDaoImpl.class);

	@Override
	public List<InterviewFeedbackEntity> getInterviewFeedbackList() throws DBException {
		List<InterviewFeedbackEntity> list = null;
 		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from InterviewFeedbackEntity");
			list = query.list();
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getFeedbacklist");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		return list;
	}

	@Override
	public UserInterviewStatusEntity insertOrUpadateStudentFeedBack(UserInterviewStatusEntity entity) throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			if(entity.getId()==null){
				entity.setId((Long)session.save(entity));
			}else{
				session.update(entity);
			}
		} catch(Exception e){
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occred while Executing InsertOrUpdateStudentFeedBack ["+entity.getFtfExtraComments()+"] ["+entity.getUser().getId()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()) {
			log.debug("Record inserted with id ["+entity.getId()+"] ["+entity.getUser().getId()+"]");
		}
		return entity;
	}

	@Override
	public UserInterviewStatusEntity getInterviewFeedBackDetailsByUserId(Long userId) throws DBException {
		Query query =null;
		try {
			Session session = sessionFactory.getCurrentSession();
			query= session.createQuery("from UserInterviewStatusEntity where user.id=:userId");
			query.setParameter("userId", userId);
		} catch(Exception e) {
			if(log.isErrorEnabled()){
				log.error("Exception Occred while executing getInterviewFeedBackDetailsByUserId");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
				
		} if(log.isDebugEnabled()) {
				log.debug("FeedBackDetails Method failed");
			}
			return (UserInterviewStatusEntity) query.uniqueResult();
	}

	@Override
	public List<UserInterviewStatusEntity> getInterviewFeedBacksListByGoodOrExcellent() throws DBException {
		List<UserInterviewStatusEntity> list = null;
 		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UserInterviewStatusEntity where (attitude=5 or attitude=7) and (logical=9 or logical=11) and (sysRating=13 or sysRating=14) and (teleCommunication=1 or teleCommunication=3) and (teleProgramming=13 or teleProgramming=14) and taskRating =13 or taskRating=14)");
			list = query.list();
			
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getFeedbacklist");
				log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
		return list;
	}

	
	

}
