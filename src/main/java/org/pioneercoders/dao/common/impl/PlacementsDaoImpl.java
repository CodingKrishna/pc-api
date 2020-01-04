package org.pioneercoders.dao.common.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.common.PlacementsDao;
import org.pioneercoders.entity.common.PlacementsEntity;
import org.pioneercoders.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlacementsDaoImpl implements PlacementsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public static final Logger logger = LoggerFactory.getLogger(PlacementsDaoImpl.class);
	
	@Override
	public List<PlacementsEntity> getPlacementsList() throws DBException {
		logger.debug("Entered into getPlacementsList Methode -->: ");
		try {
			Session session = sessionFactory.getCurrentSession();
			String queryString = "from PlacementsEntity";
			Query query = session.createQuery(queryString);
			return query.list();
		}catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Exception occured while executing getPlacementsList Method ");
				logger.error(e.getMessage());
			}
			throw new DBException(e.getMessage(), e);
		}
	}

}
