package org.pioneercoders.dao.admin;

import java.util.List;

import org.pioneercoders.entity.admin.PaymentsEntity;
import org.pioneercoders.exceptions.DBException;

public interface PaymentsDao {
	
	public PaymentsEntity insertPayment(PaymentsEntity paymentsEntity) throws DBException;
	public  List<PaymentsEntity> getPaymentsByUserId(Long userId) throws DBException;
	public List<PaymentsEntity> getTotalAmountByDate(String startDate,String endDate)throws DBException;
	
	
}
