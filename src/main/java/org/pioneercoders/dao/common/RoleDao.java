package org.pioneercoders.dao.common;

import java.util.List;

import org.pioneercoders.entity.common.RoleEntity;
import org.pioneercoders.exceptions.DBException;

public interface RoleDao {

	public List<RoleEntity> getAllRoles() throws DBException;
}
