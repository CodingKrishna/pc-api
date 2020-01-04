package org.pioneercoders.dao.hr;

import java.util.List;

import org.pioneercoders.entity.hr.PricingPlanesEntity;
import org.pioneercoders.exceptions.DBException;

public interface PricingPlanesDao {
	
	public PricingPlanesEntity createPricingPlanesRecord(PricingPlanesEntity entity) throws DBException;
	
	public List<PricingPlanesEntity> getPricingPlaneDetailsList() throws DBException;
}
