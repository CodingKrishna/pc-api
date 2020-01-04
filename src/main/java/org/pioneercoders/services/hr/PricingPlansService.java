package org.pioneercoders.services.hr;

import java.util.List;

import org.pioneercoders.dto.hr.PricingPlansDto;
import org.pioneercoders.dto.hr.PricingPlansTrnDto;
import org.pioneercoders.exceptions.ServiceException;

public interface PricingPlansService {
	

	public PricingPlansDto createPricingPlaneRecord(PricingPlansDto pricinePlansDto) throws ServiceException;

	public List<PricingPlansDto> getPricingPlaneDetailsList()throws ServiceException;
	
	public PricingPlansTrnDto createPricingPlaneTrnRecord(PricingPlansTrnDto pricinePlansTrnDto) throws ServiceException;

	public PricingPlansTrnDto getPricingPlaneTrnDetailsByHrId(Long hrId)throws ServiceException;

}
