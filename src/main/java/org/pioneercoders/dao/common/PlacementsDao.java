package org.pioneercoders.dao.common;

import java.util.List;

import org.pioneercoders.entity.common.PlacementsEntity;
import org.pioneercoders.exceptions.DBException;

public interface PlacementsDao {
	
	public List<PlacementsEntity> getPlacementsList() throws DBException;

}
