package org.pioneercoders.services.admin.impl;

import java.util.HashMap;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.admin.ExpendatureDao;
import org.pioneercoders.dao.admin.PaymentsDao;
import org.pioneercoders.dto.admin.ExpendatureDto;
import org.pioneercoders.dto.admin.PaymentsDto;
import org.pioneercoders.entity.admin.ExpendatureEntity;
import org.pioneercoders.entity.admin.PaymentsEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.admin.PaymentsService;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PaymentsServiceImpl implements PaymentsService{
	
	private static final Logger log = LoggerFactory.getLogger(PaymentsServiceImpl.class);
	@Autowired
	 PaymentsDao paymentsDao;
	
	@Autowired
	ExpendatureDao expendatureDao ;

	@Override
	public PaymentsDto insertPayment(PaymentsDto paymentsDto)
			throws ServiceException {
			PaymentsDto finalPaymentsDto = null;
			paymentsDto.setCreateOn(Constants.CREATED_ON());
			PaymentsEntity paymentsEntity = DozerBeanMapperSingletonWrapper.getInstance().map(paymentsDto, PaymentsEntity.class);
			try {
				finalPaymentsDto = DozerBeanMapperSingletonWrapper.getInstance().map(paymentsDao.insertPayment(paymentsEntity),PaymentsDto.class);
			}catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return finalPaymentsDto;
	}

	@Override
	public List<PaymentsDto> getPaymentsByUserId(Long userId)
			throws ServiceException {
		List<PaymentsDto> paymentsList = null;
		try {
			List<PaymentsEntity> list = paymentsDao.getPaymentsByUserId(userId);
			paymentsList = CollectionMapper.getMappingList(list.iterator(), PaymentsDto.class);
			log.info("Returning paymentsList -->: ");
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing quizList data ");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return paymentsList;
	}

	@Override
	public HashMap<String, Object> getPayListByDate(String startDate,String endDate) throws ServiceException {
		HashMap<String, Object> finalPayments = new HashMap();
		try {
			List<PaymentsEntity> payList = paymentsDao.getTotalAmountByDate(startDate, endDate);
			List<PaymentsDto> paymentsList = CollectionMapper.getMappingList(payList.iterator(), PaymentsDto.class);
			
			List<ExpendatureEntity> expList = expendatureDao.getTotalExpeListByDate(startDate, endDate);
			List<ExpendatureDto> expendatursList = CollectionMapper.getMappingList(expList.iterator(), ExpendatureDto.class);

			finalPayments.put("purchases", payList);
			finalPayments.put("expendatures", expendatursList);
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getPayList By Date Method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
		return finalPayments;
	}
}
