package org.pioneercoders.dao.evaluation.codingtest.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.evaluation.codingtest.CodingTestQstnsTrnDao;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnsAssignToUserTrnEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CodingTestQstnsTrnDaoImpl implements CodingTestQstnsTrnDao{
	@Autowired
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory.getLogger(CodingTestQstnsTrnDaoImpl.class);
	@Override
	public List<CodingTestQstnsAssignToUserTrnEntity> getAllQuestionsByUserId(Long userId) throws DBException {
		List<CodingTestQstnsAssignToUserTrnEntity> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CodingTestQstnsAssignToUserTrnEntity where user.id="+userId);
			list = query.list();
		} catch (Exception e) {
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occured while Executing getAllQuestionsByUserId "+userId);
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		return list;
	}

	@Override
	public CodingTestQstnsAssignToUserTrnEntity addQuestions(CodingTestQstnsAssignToUserTrnEntity codingTestQstnsAssignToUserTrnEntity)throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Long id = (Long)session.save(codingTestQstnsAssignToUserTrnEntity);
			codingTestQstnsAssignToUserTrnEntity.setId(id);
		} catch (Exception e) {
			 if(log.isErrorEnabled()) {
				 log.error("Exception Occured while creating  Record");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		
		return codingTestQstnsAssignToUserTrnEntity;
	}

}
