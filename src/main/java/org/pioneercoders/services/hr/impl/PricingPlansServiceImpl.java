package org.pioneercoders.services.hr.impl;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.hr.PricingPlanesDao;
import org.pioneercoders.dao.hr.PricinnPlanTrnDao;
import org.pioneercoders.dto.hr.PricingPlansDto;
import org.pioneercoders.dto.hr.PricingPlansTrnDto;
import org.pioneercoders.entity.hr.PricingPlanTrnEntity;
import org.pioneercoders.entity.hr.PricingPlanesEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.hr.PricingPlansService;
import org.pioneercoders.utils.CollectionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PricingPlansServiceImpl implements PricingPlansService{
	
	private static final Logger log = LoggerFactory.getLogger(PricingPlansServiceImpl.class);
	
	@Autowired
	PricingPlanesDao pricingPlansDao;
	
	@Autowired
	PricinnPlanTrnDao pricingPlanTrnDao;
	

	public PricingPlansDto createPricingPlaneRecord(PricingPlansDto pricinePlansDto) throws ServiceException {
		PricingPlansDto finalDto=null;
		try {
			PricingPlanesEntity planesEntity = DozerBeanMapperSingletonWrapper.getInstance().map(pricinePlansDto, PricingPlanesEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(pricingPlansDao.createPricingPlanesRecord(planesEntity),PricingPlansDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	public List<PricingPlansDto> getPricingPlaneDetailsList() throws ServiceException {
	      
	   try{
			List<PricingPlanesEntity> entity = pricingPlansDao.getPricingPlaneDetailsList();
			List<PricingPlansDto> pricingPlansList = CollectionMapper.getMappingList(entity.iterator(), PricingPlansDto.class);
			return pricingPlansList;
		}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}

	public PricingPlansTrnDto createPricingPlaneTrnRecord(PricingPlansTrnDto pricinePlansTrnDto) throws ServiceException {
		PricingPlansTrnDto finalDto=null;
		try {
			pricinePlansTrnDto.setPurchasedDate(new Date());
			PricingPlanTrnEntity pricingPlansTrnEntity = DozerBeanMapperSingletonWrapper.getInstance().map(pricinePlansTrnDto, PricingPlanTrnEntity.class);
			finalDto = DozerBeanMapperSingletonWrapper.getInstance().map(pricingPlanTrnDao.createPricingPlanTrnRecord(pricingPlansTrnEntity),PricingPlansTrnDto.class);
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalDto;
	}

	public PricingPlansTrnDto getPricingPlaneTrnDetailsByHrId(Long hrId)
			throws ServiceException {
		try{
			PricingPlansTrnDto pricingPlansTrnDto= null;
			PricingPlanTrnEntity entity = pricingPlanTrnDao.getPricingPlanTrnRecordByHrId(hrId);
			if(entity !=null){
				 pricingPlansTrnDto=DozerBeanMapperSingletonWrapper.getInstance().map(entity, PricingPlansTrnDto.class);
				 return pricingPlansTrnDto;
			}
			return pricingPlansTrnDto;
			}catch(DBException e){
				throw new ServiceException(e.getMessage(),e);
			}
	}
	

}
