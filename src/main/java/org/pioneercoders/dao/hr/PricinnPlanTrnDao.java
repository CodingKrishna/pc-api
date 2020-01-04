package org.pioneercoders.dao.hr;

import org.pioneercoders.entity.hr.PricingPlanTrnEntity;
import org.pioneercoders.exceptions.DBException;

public interface PricinnPlanTrnDao {

	public PricingPlanTrnEntity createPricingPlanTrnRecord(PricingPlanTrnEntity pricingPlanTrnEntity) throws DBException;
	public PricingPlanTrnEntity getPricingPlanTrnRecordByHrId(Long hrId) throws DBException;
}
