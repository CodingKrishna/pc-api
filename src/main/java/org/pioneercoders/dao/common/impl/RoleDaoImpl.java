package org.pioneercoders.dao.common.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pioneercoders.dao.common.RoleDao;
import org.pioneercoders.entity.common.RoleEntity;
import org.pioneercoders.exceptions.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	public List<RoleEntity> getAllRoles() throws DBException {
		try {
			Session session = sf.getCurrentSession();
			return session.createQuery("from RoleEntity").list();
		} catch (Exception e) {
			throw new DBException(e.getMessage(), e);
		}
	}
	
	
}
