package org.pioneercoders.services.admin;

import java.util.HashMap;
import java.util.List;

import org.pioneercoders.dto.admin.PaymentsDto;
import org.pioneercoders.exceptions.ServiceException;

public interface PaymentsService {
	public PaymentsDto insertPayment(PaymentsDto paymentsDto)  throws ServiceException;
	public List<PaymentsDto> getPaymentsByUserId(Long userId)  throws ServiceException;
	public HashMap<String, Object> getPayListByDate(String startDate,String endDate) throws ServiceException;
	
}
