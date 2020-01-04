package org.pioneercoders.dao.admin.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.admin.PaymentsDao;
import org.pioneercoders.entity.admin.PaymentsEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentsDaoImpl implements PaymentsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	private static final Logger log = LoggerFactory.getLogger(PaymentsDaoImpl.class);
	@Override
	public PaymentsEntity insertPayment(PaymentsEntity paymentsEntity)
			throws DBException {
		try {
			Session session = sessionFactory.getCurrentSession();
			paymentsEntity.setId((Long)session.save(paymentsEntity));
		} catch (Exception e) {
			if(log.isErrorEnabled()) {
				 log.error("Exception Occred while creating Payment  Record ["+paymentsEntity.getId()+"]");
				 log.error(e.getMessage());
			}
			throw new DBException(e.getMessage(),e);
		}
		if(log.isDebugEnabled()) {
			log.debug("Company Record inserted with id ["+paymentsEntity.getId()+"]");
		}
		return paymentsEntity;
	}
	@Override
	public List<PaymentsEntity> getPaymentsByUserId(Long userId)
			throws DBException {
		Query query= null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = null;
			hql = "from PaymentsEntity p where p.user.id="+userId;
			query = session.createQuery(hql);
		} catch (Exception e) {
			// TODO: handle exception
			throw new DBException(e.getMessage(),e);
		}
		return  query.list();
	}
	
	@Override
	public List<PaymentsEntity> getTotalAmountByDate(String startDate,String endDate) throws DBException {
		Query query= null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from PaymentsEntity p where p.createOn between '"+startDate+"' and '"+endDate+"'";
			query = session.createQuery(hql);
		} catch (Exception e) {
			// TODO: handle exception
			throw new DBException(e.getMessage(),e);
		}
		return  query.list();
	}

}
